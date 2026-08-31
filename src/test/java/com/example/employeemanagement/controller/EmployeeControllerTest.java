package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeResponse;
import com.example.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock EmployeeService service;
    @InjectMocks EmployeeController controller;

    @Test void searchReturnsPage() throws Exception {
        MockMvc mvc=MockMvcBuilders.standaloneSetup(controller).build();
        when(service.search(anyString(),anyString(),isNull(),any())).thenReturn(new PageImpl<>(List.of(new EmployeeResponse(1L,"John","Engineering","john@example.com",50000,true)), PageRequest.of(0,10),1));
        mvc.perform(get("/employees?page=0&size=10&search=John")).andExpect(status().isOk()).andExpect(jsonPath("$.content[0].name").value("John")).andExpect(jsonPath("$.totalElements").value(1));
    }

    @Test void dashboardStatsReturnsAnalytics() throws Exception {
        when(service.getTotalEmployees()).thenReturn(10L); when(service.getActiveEmployees()).thenReturn(8L); when(service.getDepartmentCount()).thenReturn(4L); when(service.getTotalPayroll()).thenReturn(650000d); when(service.getDepartmentStats()).thenReturn(List.of(new EmployeeService.DepartmentStat("Engineering",5)));
        MockMvc mvc=MockMvcBuilders.standaloneSetup(controller).build();
        mvc.perform(get("/employees/stats")).andExpect(status().isOk()).andExpect(jsonPath("$.totalEmployees").value(10)).andExpect(jsonPath("$.activeEmployees").value(8)).andExpect(jsonPath("$.departments").value(4)).andExpect(jsonPath("$.payroll").value(650000.0)).andExpect(jsonPath("$.departmentStats[0].department").value("Engineering"));
    }
}
