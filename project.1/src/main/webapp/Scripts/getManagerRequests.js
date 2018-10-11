var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
  if(xhr.readyState === 4 && xhr.status === 200) {
    var reimbursements = JSON.parse(xhr.responseText);
    console.log(xhr.responseText);
    var viewlist = document.getElementById("viewlist");
    var reimbursementsArray = reimbursements['Reimbursements'];
    reimbursementsArray.forEach(function(res) {
      var resDiv = document.createElement("div");
      resDiv.innerHTML = `${res.name}, ${res.author} - ${res.description} ${res.amt} ${res.status}`;
      viewlist.appendChild(resDiv);
    });
  }
  else {
    console.log("nope");
    console.log(xhr.status);
    console.log(xhr.readyState);
  }
}
xhr.open('GET', "http://localhost:8080/heyo/data/requests?who=all");
xhr.send();
