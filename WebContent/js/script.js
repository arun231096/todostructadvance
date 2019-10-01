function home() {
	window.location = "list.do?method=getList";
}
function validateProfileForm() {
    var username = document.forms["form"]["username"].value;
    var name = document.forms["form"]["name"].value;
    var password = document.forms["form"]["password"].value;
    var designation = document.forms["form"]["designation"].value;
    var email = document.forms["form"]["email"].value;
    var mobile =document.forms["form"]["mobile"].value;
    var return_status = true;
    
    if(username == '') {             
        alert("username must be filled out");
        return_status = false;
    }
    if(name == '' || estimation == '0') {             
        alert("name must be filled out");
        return_status = false;
    }
    if(password == '') {             
        alert("passowrd must be filled out");
        return_status = false;
    }
    if(designation == '') {             
        alert("designation must be filled out");
        return_status = false;
    }
    if(email == '') {               
          alert("email must be filled out");
          return_status = false;
    }
    if(mobile == '') {             
        alert("mobile must be filled out");
        return_status = false;
    }
    return return_status;
}

function validateForm() {
    var title = document.forms["form"]["title"].value;
    var message = document.forms["form"]["message"].value;
    var estimation = document.forms["form"]["estimation"].value;
    var startDate = document.forms["form"]["startDate"].value;
    var endDate = document.forms["form"]["endDate"].value;
    var status =document.forms["form"]["status"].value;
    var return_status = true;
    if(title == '') {               
          alert("title must be filled out");
          return_status = false;
    }
    if(message == '') {             
        alert("message must be filled out");
        return_status = false;
    }
    if(estimation == '' || estimation == '0') {             
        alert("estimation must be filled out");
        return_status = false;
    }
    if(startDate == '' || isValidDate(startDate) == false) {             
        alert("start date must be filled out or format is wrong");
        return_status = false;
    }
    if(endDate == '' || isValidDate(endDate) == false) {             
        alert("end date must be filled out or format is wrong");
        return_status = false;
    }
    if(status == '') {             
        alert("status must be filled out");
        return_status = false;
    }
    return return_status;
}
function cleanForm() {
	var list = document.getElementsByClassName("form-control");
	for(i = 0; i < list.length; i++) {
		list[i].setAttribute("autocomplete", "new-password");
	}
	
}
function isValidDate(dateString) {
      var regEx = /^\d{4}-\d{2}-\d{2}$/;
      if(!dateString.match(regEx)) return false;
      var d = new Date(dateString);
      var dNum = d.getTime();
      if(!dNum && dNum !== 0) return false;
      console.log(d.toISOString().slice(0,10) === dateString);
      return d.toISOString().slice(0,10) === dateString;
}
function getData(id) {
	  tr = document.getElementById("listTable").rows[id];
	  id = tr.childNodes[1].value;
	  console.log(id);
	  window.location = "list.do?method=read&id="+id;
}
function deleteData(id) {
    tr = document.getElementById("listTable").rows[id];
    id = tr.childNodes[1].value;
    console.log(id);
    window.location = "delete.do?method=delete&id="+id;
}
function profile() {
	  window.location = "user.do?method=readUser";
}
function deleteuser() {
	if(window.confirm('Are you sure to delete')) {		
		window.location = "user.do?method=deleteUser";
	}
}