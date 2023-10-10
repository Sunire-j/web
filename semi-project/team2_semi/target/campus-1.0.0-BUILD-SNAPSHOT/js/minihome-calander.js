const calendarBody = document.getElementById("calendarBody");
const currentMonthYear = document.getElementById("currentMonthYear");
const emojiMenu = document.getElementById("emojiMenu");
let currentDate = new Date();
let selectedCell = null;
function generateCalendar(year, month) {
  calendarBody.innerHTML = "";
  const daysInMonth = new Date(year, month + 1, 0).getDate();
  const firstDay = new Date(year, month, 1).getDay();
  const monthText = getMonthText(month);
  currentMonthYear.textContent = `${monthText} ${year}`;
  let day = 1;
  for (let i = 0; i < 6; i++) {
    const row = document.createElement("tr");
    for (let j = 0; j < 7; j++) {
      const cell = document.createElement("td");
      //
      if ((j + 1) % 7 === 1) {
        cell.style.color = "red";
      } else if ((j + 1) % 7 === 0) {
        cell.style.color = "blue";
      }
      //
      if (i === 0 && j < firstDay) {
        cell.textContent = "";
      } else if (day > daysInMonth) {
        cell.textContent = "";
      } else {
        cell.textContent = day++;

        cell.addEventListener(
          "click",
          (event) => {
            selectedCell = event.target;
            if (selectedCell.tagName === "SPAN") {
              selectedCell = selectedCell.parentNode;
            }
            emojiMenu.style.display = "block";
            emojiMenu.style.left = selectedCell.offsetLeft + "px";
            emojiMenu.style.top =
              selectedCell.offsetTop + selectedCell.offsetHeight + "px";
          },
          { once: true }
        );
      }

      row.appendChild(cell);
    }

    calendarBody.appendChild(row);
  }

  // 마지막 행 숨기기
  calendarBody.lastElementChild.style.display = "none";
}

function insertEmoji(emoji) {
  emojiMenu.style.display = "none";

  if (selectedCell) {
    var originalContent = selectedCell.textContent;

    // If there is a check mark in the content then replace the existing emoji with the new one
    if (originalContent.includes("✓")) {
      var updatedContent =
        originalContent.slice(0, originalContent.indexOf(" ")) + " " + emoji;

      selectedCell.textContent = updatedContent;

      // Remove old check mark if exists
      if (selectedCell.querySelector(".check-mark")) {
        selectedCell.removeChild(selectedCell.querySelector(".check-mark"));
      }

      // Add new check mark
      var checkMark = document.createElement("span");
      checkMark.className = "check-mark";
      checkMark.textContent = "✓";

      selectedCell.appendChild(checkMark);
    } else {
      var updatedContent = originalContent + " " + emoji;

      selectedCell.textContent = updatedContent;

      // Add new check mark
      var checkMark = document.createElement("span");
      checkMark.className = "check-mark";
      checkMark.textContent = "✓";

      selectedCell.appendChild(checkMark);

      // Add click event to the span element
      checkMark.addEventListener("click", function () {
        console.log("test");
        window.location.href = "MiniHome_Memo_View.html"; // Update this with your actual path
        return false; // Prevents the parent cell's click event from firing
      });
    }
  }
}
function getMonthText(month) {
  const monthNames = [
    "JANUARY",
    "FEBRUARY",
    "MARCH",
    "APRIL",
    "MAY",
    "JUNE",
    "JULY",
    "AUGUST",
    "SEPTEMBER",
    "OCTOBER",
    "NOVEMBER",
    "DECEMBER",
  ];
  const monthIndex = Math.max(0, Math.min(month, 11));
  const monthText = monthNames[monthIndex];

  return monthText;
}

generateCalendar(currentDate.getFullYear(), currentDate.getMonth());

function previousMonth() {
  currentDate.setMonth(currentDate.getMonth() - 1);
  generateCalendar(currentDate.getFullYear(), currentDate.getMonth());
}
function nextMonth() {
  currentDate.setMonth(currentDate.getMonth() + 1);
  generateCalendar(currentDate.getFullYear(), currentDate.getMonth());
}
