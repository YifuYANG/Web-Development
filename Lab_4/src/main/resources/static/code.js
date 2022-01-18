function addPerson()
{
    var xhr = new XMLHttpRequest();
    xhr.onload=insertPerson;
    var info = {
        surname : document.getElementById("surname").value,
        firstname : document.getElementById("firstname").value
    };
    var toString = JSON.stringify(info);
    xhr.open("POST", "/addPerson");
    xhr.setRequestHeader("Content-Type","application/json");
    xhr.send(toString);
}

function removePerson(id)
{
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/removePerson?id="+id);
    xhr.onload=deletePerson;
    xhr.send();
}

function viewPhone(id)
{
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/phones/" + id);
    xhr.addEventListener("load",viewPhones)
    xhr.send();
}

function viewPhones()
{
    document.getElementById("view").innerHTML=this.responseText;
}


function addNumbers(id)
{
    let request = new XMLHttpRequest();
    let phone = {
        type : document.getElementById("type_1").value,
        number : document.getElementById("phone_number").value
    };
    request.addEventListener("load", insertPhone);
    request.onload = function ()
    {
        console.log(this.responseText);
    }
    request.open("POST", "/phones/add?id="+id);
    request.setRequestHeader("Content-Type","application/json");
    request.send(JSON.stringify(phone));
}
function insertPhone()
{
    var record = JSON.parse(this.responseText);
    var table = document.getElementById("phones");
    var rows = table.querySelectorAll("tr");
    var row = table.insertRow(rows.length-1);
    row.id="rw_"+record.id;
    var type_cell = row.insertCell(0);
    var number_cell = row.insertCell(1);
    var button_cell = row.insertCell(2);
    type_cell.innerHTML=record.type;
    number_cell.innerHTML=record.number;
    button_cell.innerHTML="<button onclick='removePhone("+record.id+")'>Remove</button>";
    document.getElementById("type_1").value="";
    document.getElementById("phone_number").value="";
}


function removePhone(id)
{
    var xhr = new XMLHttpRequest();
    xhr.onload=deletePhone;
    xhr.open("GET", "/removePhone?id="+id);
    xhr.send();
}
function deletePhone()
{
    var id = this.responseText;
    var table = document.getElementById("phones");
    var row = document.getElementById("rw_" + id);
    table.deleteRow(row.rowIndex);
}
function insertPerson()
{
    var record = JSON.parse(this.responseText);
    var table = document.getElementById("people");
    var rows = table.querySelectorAll("tr");
    var row = table.insertRow(rows.length-1);
    row.id="row_"+record.id;
    var firstname_cell = row.insertCell(0);
    var surname_cell = row.insertCell(1);
    var button_cell = row.insertCell(2);
    var button_cell2 = row.insertCell(3);
    firstname_cell.innerHTML=record.firstname;
    surname_cell.innerHTML=record.surname;
    button_cell.innerHTML="<button onclick='viewPhone("+record.id+")'>View</button>";
    button_cell2.innerHTML="<button onclick='removePerson("+record.id+")'>Remove</button>";
    document.getElementById("firstname").value="";
    document.getElementById("surname").value="";
    document.getElementById("firstname").focus();
}

function deletePerson()
{
    var id = this.responseText;
    var table = document.getElementById("people");
    var row = document.getElementById("row_" + id);
    table.deleteRow(row.rowIndex);
}


