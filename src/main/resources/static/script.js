async function api(url, options = {}) {
  const response = await fetch(url, options);
  if (!response.ok) throw new Error(`Request failed: ${response.status}`);
  return response.status === 204 ? null : response.json();
}

async function loadDashboard() {
  try {
    const [stats, employees] = await Promise.all([api('/employees/stats'), api('/employees')]);
    document.getElementById('total-employees').textContent = stats.totalEmployees;
    document.getElementById('active-employees').textContent = stats.activeEmployees;
    document.getElementById('departments').textContent = stats.departments;
    document.getElementById('payroll').textContent = new Intl.NumberFormat('en-IN', { style: 'currency', currency: 'INR', maximumFractionDigits: 0 }).format(stats.payroll || 0);
    renderEmployees(employees);
  } catch (error) {
    console.error(error);
    showAlert('Unable to load dashboard data. Check the backend and database connection.', 'danger');
  }
}

function renderEmployees(data) {
  const tbody = document.querySelector('#employees-table tbody');
  if (!tbody) return;
  tbody.innerHTML = '';
  document.getElementById('employee-count').textContent = `${data.length} record${data.length === 1 ? '' : 's'}`;
  if (!data.length) {
    tbody.innerHTML = '<tr><td colspan="7" class="text-center empty">No employees found. Add your first employee.</td></tr>';
    return;
  }
  data.forEach(emp => {
    const tr = document.createElement('tr');
    tr.innerHTML = `<td class="ps-4">${emp.id}</td><td class="fw-semibold">${escapeHtml(emp.name)}</td><td>${escapeHtml(emp.department)}</td><td>${escapeHtml(emp.email)}</td><td>₹${Number(emp.salary || 0).toLocaleString('en-IN')}</td><td><span class="badge ${emp.active ? 'text-bg-success' : 'text-bg-secondary'}">${emp.active ? 'Active' : 'Inactive'}</span></td><td class="text-end pe-4"><button class="btn btn-sm btn-outline-danger" onclick="deleteEmployee(${emp.id})">Delete</button></td>`;
    tbody.appendChild(tr);
  });
}

async function deleteEmployee(id) {
  if (!confirm(`Delete employee ${id}?`)) return;
  try {
    await api('/employees/' + id, { method: 'DELETE' });
    showAlert('Employee deleted successfully.', 'success');
    await loadDashboard();
  } catch (error) {
    showAlert('Delete failed.', 'danger');
  }
}

function escapeHtml(value) {
  return String(value ?? '').replace(/[&<>"']/g, char => ({ '&':'&amp;', '<':'&lt;', '>':'&gt;', '"':'&quot;', "'":'&#039;' }[char]));
}

function showAlert(message, type = 'info') {
  const placeholder = document.getElementById('alert-placeholder');
  if (!placeholder) return;
  placeholder.innerHTML = `<div class="alert alert-${type} shadow-sm">${escapeHtml(message)}</div>`;
  setTimeout(() => placeholder.innerHTML = '', 3500);
}

document.addEventListener('DOMContentLoaded', () => {
  if (document.getElementById('employees-table')) loadDashboard();
  const form = document.getElementById('add-form');
  if (form) form.addEventListener('submit', async (e) => {
    e.preventDefault();
    try {
      const body = { name: document.getElementById('name').value.trim(), department: document.getElementById('department').value.trim(), email: document.getElementById('email').value.trim(), salary: parseFloat(document.getElementById('salary').value) };
      await api('/employees', { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(body) });
      showAlert('Employee added successfully.', 'success');
      form.reset();
    } catch (error) { showAlert('Unable to add employee. Check the submitted data.', 'danger'); }
  });
});
