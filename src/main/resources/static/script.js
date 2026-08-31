let currentPage = 0;
const pageSize = 8;
async function api(url, options={}) { const r=await fetch(url,options); if(!r.ok){let e={};try{e=await r.json()}catch{} throw new Error(e.message||`Request failed: ${r.status}`)} return r.status===204?null:r.json(); }
async function loadDashboard(){
  try { const stats=await api('/employees/stats');
    document.getElementById('total-employees').textContent=stats.totalEmployees;
    document.getElementById('active-employees').textContent=stats.activeEmployees;
    document.getElementById('departments').textContent=stats.departments;
    document.getElementById('payroll').textContent=new Intl.NumberFormat('en-IN',{style:'currency',currency:'INR',maximumFractionDigits:0}).format(stats.payroll||0);
    renderDepartmentChart(stats.departmentStats||[]); await loadEmployees(currentPage);
  } catch(e){showAlert(e.message||'Unable to load dashboard.','danger');}
}
async function loadEmployees(page=0){
  currentPage=Math.max(0,page); const p=new URLSearchParams({page:currentPage,size:pageSize,search:document.getElementById('search')?.value.trim()||'',department:document.getElementById('department')?.value.trim()||''});
  const active=document.getElementById('active')?.value; if(active)p.set('active',active);
  try{const data=await api('/employees?'+p); renderEmployees(data.content||[]); document.getElementById('page-info').textContent=`Page ${data.number+1} of ${Math.max(data.totalPages,1)} · ${data.totalElements} employees`; document.getElementById('prev').disabled=data.first; document.getElementById('next').disabled=data.last;}catch(e){showAlert(e.message||'Unable to load employees.','danger');}
}
function changePage(delta){loadEmployees(currentPage+delta)}
function renderEmployees(data){const body=document.getElementById('employee-body');if(!body)return;body.innerHTML='';if(!data.length){body.innerHTML='<tr><td colspan="7" class="text-center empty">No employees match your filters.</td></tr>';return;}data.forEach(e=>{const tr=document.createElement('tr');tr.innerHTML=`<td class="ps-4">${e.id}</td><td class="fw-semibold">${escapeHtml(e.name)}</td><td>${escapeHtml(e.department)}</td><td>${escapeHtml(e.email)}</td><td>₹${Number(e.salary||0).toLocaleString('en-IN')}</td><td><span class="badge ${e.active?'text-bg-success':'text-bg-secondary'}">${e.active?'Active':'Inactive'}</span></td><td class="text-end pe-4"><a class="btn btn-sm btn-outline-primary me-1" href="/edit.html?id=${e.id}">Edit</a><button class="btn btn-sm btn-outline-danger" onclick="deleteEmployee(${e.id})">Delete</button></td>`;body.appendChild(tr);});}
function renderDepartmentChart(items){const el=document.getElementById('department-chart');if(!el)return;const max=Math.max(...items.map(x=>x.employees),1);el.innerHTML=items.length?items.map(x=>`<div class="mb-3"><div class="d-flex justify-content-between small mb-1"><span class="fw-semibold">${escapeHtml(x.department)}</span><span>${x.employees}</span></div><div class="bar"><span style="width:${Math.round(x.employees/max*100)}%"></span></div></div>`).join(''):'<p class="text-secondary mb-0">No department data yet.</p>';}
async function deleteEmployee(id){if(!confirm(`Delete employee ${id}?`))return;try{await api('/employees/'+id,{method:'DELETE'});showAlert('Employee deleted.','success');await loadDashboard();}catch(e){showAlert(e.message||'Delete failed.','danger');}}
function escapeHtml(v){return String(v??'').replace(/[&<>"']/g,c=>({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&#039;'}[c]));}
function showAlert(message,type='info'){const el=document.getElementById('alert-placeholder');if(!el)return;el.innerHTML=`<div class="alert alert-${type}">${escapeHtml(message)}</div>`;setTimeout(()=>el.innerHTML='',3500);}
document.addEventListener('DOMContentLoaded',()=>{if(document.getElementById('employee-body'))loadDashboard();const form=document.getElementById('employee-form');if(form)form.addEventListener('submit',submitEmployee);});
async function submitEmployee(e){e.preventDefault();const id=new URLSearchParams(location.search).get('id');const body={name:name.value.trim(),department:department.value.trim(),email:email.value.trim(),salary:Number(salary.value),active:document.getElementById('active-field')?.checked??true};try{await api(id?'/employees/'+id:'/employees',{method:id?'PUT':'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(body)});location.href='/?saved=1';}catch(err){showAlert(err.message||'Unable to save employee.','danger');}}
