var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
  if(xhr.readyState === 4 && xhr.status === 200) {
    var employees = JSON.parse(xhr.responseText);
    console.log(xhr.responseText);
    var dir = document.getElementById("directory");
    var empsArray = employees['Employees'];
    empsArray.forEach(function(emp) {
      var empDiv = document.createElement("div");
      var empA = document.createElement("a");
      empA.setAttribute("href", "/heyo/manager/profile?username=" + emp.username);
      empA.innerHTML = `${emp.lastName}, ${emp.firstName} - ${emp.title}`;
      empDiv.appendChild(empA);
      dir.appendChild(empDiv);
    });
  }
  else {
    console.log("nope");
    console.log(xhr.status);
    console.log(xhr.readyState);
  }
}
xhr.open('GET', "http://localhost:8080/heyo/data/employee?who=all");
xhr.send();
