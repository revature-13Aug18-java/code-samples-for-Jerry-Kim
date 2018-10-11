$(document).ready(function() {

  $.get("/heyo/session", function() {
  }, "json").done(function(data) {
    $.get("/heyo/data/profile", {targetUsername: data.targetUsername, title: data.title }, function() {
    }, "json").done(function(empObject) {
      if(empObject.title === "employee") {
        $("#newReq").attr("href", "/heyo/employee/request?action=new");
        $("#viewReq").attr("href", "/heyo/employee/request?action=view");
        $("#edit").attr("href", "/heyo/employee/edit");
      }
      else {
        $("#viewReq").attr("href", "/heyo/manager/request?action=view");
      }

      var username = $("#username");
      username.html("<span>username: </span>");
      var firstName = $("#firstName");
      var lastName = $("#lastName");
      var title = $("#title");
      var manager = $("#manager");
      username.html("<span>Username: </span>" + empObject.username);
      firstName.html("<span>first name: </span>" + empObject.firstName);
      lastName.html("<span>last name: </span>" + empObject.lastName);
      title.html("<span>title: </span>" + empObject.title);
      if(manager)
        manager.html("<span>manager: </span>" + empObject.manager);
    });
  });
});


