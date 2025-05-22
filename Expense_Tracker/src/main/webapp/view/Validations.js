$(document).ready(function () {
  // Form submit event
  $("#regForm").on("submit", function (e) {
    // Run all validations
    validName(e);
    validEmail(e);
    validPass(e);
    validCpass(e);
  });
  
  $("#logForm").on("submit", function (e) {
     // Run all validations
     validEmail(e);
     validPass(e);
   });

  // Optional: live validation on keyup
  $("#uname").on("keyup", () => validName());
  $("#email").on("keyup", () => validEmail());
  $("#pass").on("keyup", () => validPass());
  $("#cpass").on("keyup", () => validCpass());
});

const validName = (e) => {
  var name = $("#uname").val().trim();
  if (name === "") {
    $("#nameEr").html("Name is required!");
    if (e) e.preventDefault();
  } else {
    $("#nameEr").html("");
  }
};

const validEmail = (e) => {
  var email = $("#email").val().trim();
  if (email === "") {
    $("#emailEr").html("Email is required!");
    if (e) e.preventDefault();
  } else {
    $("#emailEr").html("");
  }
};

const validPass = (e) => {
  var pass = $("#pass").val().trim();
  if (pass === "") {
    $("#passEr").html("Password is required!");
    if (e) e.preventDefault();
  } else {
    $("#passEr").html("");
  }
};

const validCpass = (e) => {
  var pass = $("#pass").val().trim();
  var cpass = $("#cpass").val().trim();

  if (cpass === "") {
    $("#cpassEr").html("Confirm password is required!");
    if (e) e.preventDefault();
  } else if (pass !== cpass) {
    $("#cpassEr").html("Passwords do not match!");
    if (e) e.preventDefault();
  } else {
    $("#cpassEr").html("");
  }
};

/*const isEmailExist = (e) =>{
	var email = $("#email").val().trim();
	$.get("isEmailExist",{email},(rt)=>{
		
	})
}
*/