async function fetchEmployees() {
  const res = await fetch('/employees');
  const data = await res.json();
  const tbody = document.querySelector('#employees-table tbody');
  tbody.innerHTML = '';
  data.forEach(emp => {
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${emp.id}</td><td>${emp.name}</td><td>${emp.department}</td><td>${emp.email}</td><td>${emp.salary}</td><td><button class="btn btn-sm btn-danger" onclick="deleteEmployee(${emp.id})">Delete</button></td>`;
    tbody.appendChild(tr);
  });
}

async function deleteEmployee(id) {
  if (!confirm('Delete employee ' + id + '?')) return;
  const res = await fetch('/employees/' + id, { method: 'DELETE' });
  if (res.ok) {
    showAlert('Employee deleted', 'success');
    fetchEmployees();
  } else {
    showAlert('Delete failed', 'danger');
  }
}

function showAlert(message, type = 'info') {
  const p = document.createElement('div');
  p.innerHTML = `<div class="alert alert-${type}">${message}</div>`;
  const placeholder = document.getElementById('alert-placeholder');
  placeholder.innerHTML = '';
  placeholder.appendChild(p);
  setTimeout(() => placeholder.innerHTML = '', 3000);
}

document.addEventListener('DOMContentLoaded', () => {
  if (document.getElementById('add-form')) {
    document.getElementById('add-form').addEventListener('submit', async (e) => {
      e.preventDefault();
      const body = {
        name: document.getElementById('name').value,
        department: document.getElementById('department').value,
        email: document.getElementById('email').value,
        salary: parseFloat(document.getElementById('salary').value)
      };
      const res = await fetch('/employees', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(body)
      });
      if (res.ok) {
        showAlert('Employee added', 'success');
        document.getElementById('add-form').reset();
      } else {
        showAlert('Add failed', 'danger');
      }
    });
  }
  if (document.querySelector('#employees-table')) fetchEmployees();
});
