document.getElementById("userid").addEventListener("blur", function () {
  var regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,16}$/;
  var warning = document.getElementById("warning");

  if (!regex.test(this.value)) {
    warning.innerText =
      "아이디는 8~16자의 영어 대문자, 소문자, 숫자만 사용할 수 있습니다.";
  } else {
    warning.innerText = "";
  }
});

document.getElementById("userpwd").addEventListener("blur", function () {
  var regex =
    /^(?:(?=.*\d)(?=.*[a-z])(?=.*[A-Z])|(?=.*\d)(?=.*[^a-zA-Z0-9\s])(?=.*[a-z])|(?=.*[^a-zA-Z0-9\s])(?=.*[a-z])(?=.*[A-Z])|(?=.*\d)(?=.*[^a-zA-Z0-9\s])(?=.*[A-Z])).{8,16}$/;
  var warning = document.getElementById("warning");

  if (!regex.test(this.value)) {
    warning.innerText =
      "비밀번호는 영어 대문자, 소문자, 특수문자 및 숫자 중 최소 세 가지를 조합하여 생성해야 합니다.";
  } else {
    warning.innerText = "";
  }
});

document.getElementById("useremail").addEventListener("blur", function () {
  var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  var warning = document.getElementById("warning");

  if (!regex.test(this.value)) {
    warning.innerText = "유효한 이메일 주소를 입력하세요.";
  } else {
    warning.innerText = "";
  }
});
