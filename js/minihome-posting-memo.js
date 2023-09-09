// HTML의 DOM 요소를 가져옵니다.
var firstSelect = document.getElementById("bodypart_first");
var secondSelect = document.getElementById("bodypart_second");
var selectedList = document.getElementById("selected-list");

// 첫 번째 select box에서 선택이 변경될 때마다 이 함수를 호출합니다.
firstSelect.addEventListener("change", function () {
  // 먼저 두 번째 select box의 내용을 비웁니다.
  while (secondSelect.firstChild) {
    secondSelect.removeChild(secondSelect.firstChild);
  }

  // 첫 번째 select box에서 선택한 값을 가져옵니다.
  var selectedValue = firstSelect.options[firstSelect.selectedIndex].value;

  // 상체가 선택된 경우
  if (selectedValue == "1") {
    var options = ["가슴", "어깨", "등", "팔", "복부", "허리"];
    secondSelect.style.backgroundColor = "#7aa5e9";
    secondSelect.style.color = "#FFFFFF";
  }
  // 하체가 선택된 경우
  else if (selectedValue == "2") {
    var options = ["허벅지", "엉덩이", "종아리"];
    secondSelect.style.backgroundColor = "#4066b0";
    secondSelect.style.color = "#FFFFFF";
  }

  // 위에서 설정한 옵션을 두 번째 select box에 추가합니다.
  for (var i = 0; i < options.length; i++) {
    var newOption = document.createElement("option");
    newOption.value = i + 1;
    newOption.text = options[i];
    secondSelect.appendChild(newOption);
  }
});

// 두 번째 select box에서 선택이 변경될 때마다 이 함수를 호출합니다.
secondSelect.addEventListener("change", function () {
  var firstSelectedValueText =
    firstSelect.options[firstSelect.selectedIndex].text;
  var secondSelectedValueText =
    secondSelect.options[secondSelect.selectedIndex].text;

  // 새로운 option 생성 후, text와 value 설정
  let newOptionForSelectedList = document.createElement("option");

  newOptionForSelectedList.text = `${firstSelectedValueText} - ${secondSelectedValueText}`;

  if (firstSelectedValueText === "상체") {
    newOptionForSelectedList.style.backgroundColor = "#7aa5e9";
    newOptionForSelectedList.style.color = "#ffffff";
  } else if (firstSelectedValueText === "하체") {
    newOptionForSelectedList.style.backgroundColor = "#4066b0";
    newOptionForSelectedList.style.color = "#ffffff";
  }

  selectedList.add(newOptionForSelectedList);
});

// Selected List 에서 아이템 클릭 시 삭제하는 이벤트 리스너 추가
selectedList.addEventListener("click", function (e) {
  selectedList.remove(e.target.selectedIndex);
});

// 이미지 파일이 로드되면 실행되는 함수입니다.
function loadImage(event) {
  var image = document.getElementById("preview");
  image.src = URL.createObjectURL(event.target.files[0]);
}
