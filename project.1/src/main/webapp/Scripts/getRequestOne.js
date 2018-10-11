$(document).ready(function() {
  function addAjaxEvent() {
    let saveButton = $(".resolveReimbursement").on("click", function(e) {
      let selectRef = e.target.dataset.selectRef;
      let select = $("#" + selectRef + " option" + ":selected")
      let selectedText = select.text(); //invoiceID
      let jqxhr = $.post("/heyo/data/request", {id: selectRef, action: selectedText}, function() {
        console.log('loading');
      }, "json").done(function(data) { 
        var managerLink = $( "<a/>", {
          html: data.updatedStatus + " by " + data.manager,
          href: ""
        });
        managerLink.data("targetUsername", data.manager);
        
        var replaceTarget = $("#" + data.id);
        replaceTarget = replaceTarget.parent();
        replaceTarget.html("");
        managerLink.appendTo(replaceTarget);
        managerLink.on("click", {targetUsername: data.manager},  function(e) {
          e.preventDefault();
          console.log("e data");
          console.log(e);
          $.get('/heyo/data/profile?targetUsername=' + e.data.targetUsername, function() {

          }, "json").done(function(res) {
            console.log("THE RES IS: ");
            console.log(res);
          });
        });
      });
    });
  }

  function createSelectAction(id) { //pass in reimbursment id to identify uniquely buttons
    //  let form = document.createElement("form");
    // form.setAttribute("method", "post");
    //form.setAttribute("action", "/heyo/data/request");
    let sel = document.createElement("select");
    sel.setAttribute("id", id);
    let op1 = document.createElement("option");
    op1.setAttribute("value", "approve");
    op1.innerHTML = "approve";
    let op2 = document.createElement("option");
    op2.setAttribute("value", "reject");
    // op2.setAttribute("id", "rejectOption" + id);
    op2.innerHTML = "reject";

    let sub = document.createElement("button");
    sub.setAttribute("class", "resolveReimbursement");
    sub.innerHTML = "go";
    sub.setAttribute("data-select-ref", id);

    sel.appendChild(op1);
    sel.appendChild(op2);
    sel.appendChild(sub);
    let div = document.createElement("div");
    div.appendChild(sel);
    div.appendChild(sub);
    return div;
  }


  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if(xhr.readyState === 4 && xhr.status === 200) {
      var reimbursements = JSON.parse(xhr.responseText);
      console.log(xhr.responseText);
      var viewlist = document.getElementById("viewlist");
      var reimbursementsArray = reimbursements['Reimbursements'];

      let table = document.createElement("table");
      reimbursementsArray.forEach(function(res) {
        var resDiv = document.createElement("div");
        var reimA = document.createElement("a");
        reimA.innerHTML = res.author;
        let tr = document.createElement("tr");

        //for each column
        let props = [res.id, res.author, res.name, res.description, res.amt, res.status]; 
        props.forEach(function(p) {
          let td = document.createElement("td");
          td.innerHTML = p;
          tr.appendChild(td);
        });

        let td = document.createElement("td");
        let selectAction = createSelectAction(res.id);
        td.appendChild(selectAction);
        tr.appendChild(td);
        table.appendChild(tr);
        viewlist.appendChild(table);
        addAjaxEvent();
        var el = $("#86")
      });
    }
    else {
      console.log("nope");
      console.log(xhr.status);
      console.log(xhr.readyState);
    }
  }
  xhr.open('GET', "http://localhost:8080/heyo/data/request?who=all");
  xhr.send();

});

