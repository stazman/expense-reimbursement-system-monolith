function getAllReimbursements(){
    const rows = document.getElementById('reimbTableBody').innerHTML='';
    asyncFetch("http://localhost:8080/com.ers/allReimbursements.json", renderTable);
}