function sendAjaxForSession() {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState === 4 && xhr.status === 200) {
      var employees = JSON.parse(xhr.responseText);
      console.log(xhr.responseText);
      console.log(employees.title);
    }
    else {
      console.log("nope");
      console.log(xhr.status);
      console.log(xhr.readyState);
    }
  }
  xhr.open('GET', "http://localhost:8080/heyo/session");
  xhr.send();
}

function createEmployeePage() {
}
