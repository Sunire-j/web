function editProfile() {
  var usernameDiv = document.getElementById("username-div");
  var selfCommentDiv = document.getElementById("self-comment-editable");
  var selfCommentContainer = document.getElementById("self-comment");
  var editButton = document.getElementById("edit-button");
  var confirmButton = document.getElementById("confirm-button");

  // 편집 가능 상태로 변경
  usernameDiv.contentEditable = "true";
  selfCommentDiv.contentEditable = "true";

  // 테두리 색상 변경
  usernameDiv.style.border = "1px solid red";

  // Self Comment에 외곽선 추가 및 높이 조정
  selfCommentContainer.style.border = "1px solid red";
  selfCommentContainer.style.height = "83px";

  // 버튼 상태 변경
  editButton.style.display = "none";
  confirmButton.style.display = "inline-block";
}

function confirmProfile() {
  var usernameDiv = document.getElementById("username-div");
  var selfCommentDiv = document.getElementById("self-comment-editable");
  var selfCommentContainer = document.getElementById("self-comment");
  var editButton = document.getElementById("edit-button");
  var confirmButton = document.getElementById("confirm-button");

  if (usernameDiv.innerText.length < 2 || usernameDiv.innerText.length > 12) {
    alert("닉네임은 최소2자 이상 최대12자 이내로 작성해주세요.");
    return;
  }

  // 편집 불가능 상태로 변경
  usernameDiv.contentEditable = "false";
  selfCommentDiv.contentEditable = "false";

  // 테두리 색상 원래대로 복귀 (CSS 파일에 정의된 값으로 설정)
  usernameDiv.style.border = "";

  // Self Comment 외곽선 제거 및 높이 원복
  selfCommentContainer.style.border = "";
  selfCommentContainer.style.height = "";

  // 버튼 상태 변경
  editButton.style.display = "inline-block";
  confirmButton.style.display = "none";
}

document.getElementById("today-attend").addEventListener("click", function () {
  window.location.href = "MiniHome_Memo_Posting.html";
});
