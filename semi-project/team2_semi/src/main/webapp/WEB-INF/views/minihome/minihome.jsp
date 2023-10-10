<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/minihome-default.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/calendar-module.css">

<div class="minihome-area">
    <div class="home-left">
        <div class="profile-area">
            <div class="profile-container">
                <div class="profile-pic">
                    <img src="../img/images.jpg">
                </div>
                <div class="name-id-section">
                    <div id="username-div" class="username-section" contentEditable="false">로니 콜먼</div>
                    <p class="userid-section">@${ownerid}</p>
                </div>
                <div class="self-comment-section">
                    <div id="self-comment">
                        <div id="self-comment-editable" contentEditable='false'>운동은 내 인생</div>
                    </div>

                    <div class="follow-count-section">
                        <div class="follower">팔로워 :&nbsp<p class="follower-count">0</p>
                        </div>
                        <div class="follow">팔로우 :&nbsp<p class="follow-count">30</p>
                        </div>
                    </div>
                </div>
                <div class="edit-profile-section">
                    <input type="button" value="프로필 수정" class="edit-profile" id='edit-button'
                           onclick='editProfile()'>
                    <input type='button' value='확인' class='edit-profile' id='confirm-button' style='display: none;'
                           onclick='confirmProfile()'>

                </div>
            </div>
        </div>
        <div class="count-area">
            <div class="count-area-container">
                <div class="today-attend-section">
                    <input type="button" value="출석체크" class="today-attend" id="today-attend">
                </div>
                <div class="memo-today-section">
                    <div class="memo">Memo :&nbsp<p class="memo-count">2</div>
                    <div class="today">Today :&nbsp<p class="today-count">13</div>
                </div>
                <div class="check-mine-post">
                    <a href="Community_Show_MyPost.html">내 글 보기</a>
                </div>
                <div class="reg-date">가입일자 :&nbsp<p>2023년 09월 08일</p>
                </div>
            </div>
        </div>

    </div>

    <!-- #endregion -->
    <div class="home-right">

        <div class="maincontainer">
            <!-- 이 아래부터 수정 허용 -->
            <div class="calendar-whole-section">
                <div class="controller-year-month-section">
                    <input type="button" value="PREV" class="month-control-button" onclick="previousMonth()">
                    <div>
                        <h1 class="year-month" id="currentMonthYear">AUGUST 2023</h1>
                    </div>
                    <input type="button" value="NEXT" class="month-control-button" onclick="nextMonth()">
                </div>
                <table id="calendar">
                    <thead>
                    <tr>
                        <th style="color: red;">일</th>
                        <th>월</th>
                        <th>화</th>
                        <th>수</th>
                        <th>목</th>
                        <th>금</th>
                        <th style="color: blue;">토</th>
                    </tr>
                    </thead>
                    <tbody id="calendarBody">
                    </tbody>
                </table>
                <div class="emoji-menu" id="emojiMenu">
                    <button onclick="insertEmoji('👍')">👍</button>
                    <button onclick="insertEmoji('🤔')">🤔</button>
                    <button onclick="insertEmoji('😎')">😎</button>
                    <!-- 다른 이모티콘을 추가할 수 있습니다. -->
                </div>
            </div>
            <div class="visitor-comment-section">
                <div class="comment-write-section">
                    <input type="text" name="comment-input" id="comment-input" class="comment-input"
                           placeholder="'로니 콜먼' 님의 미니홈 방명록">
                    <input type="button" value="방명록 등록" class="comment-post">
                </div>
                <div class="comment-list-section">
                    <ul class="commnet-list">
                        <li class="dummydata">
                            <div class="first-line-comment">
                                <div class="comment">몸 좋으시네요</div>
                                <div class="erase-button"><a href="#">삭제</a></div>
                            </div>
                            <div class="second-line-comment">
                                <div class="comment-writer-section">작성자 :&nbsp<a href="#">산본동왕쇼바</a>
                                </div>
                            </div>
                        </li>
                        <li class="dummydata">
                            <div class="first-line-comment">
                                <div class="comment">로니햄 폼 미쳤다 ㄷㄷ</div>
                                <div class="erase-button"><a href="#">삭제</a></div>
                            </div>
                            <div class="second-line-comment">
                                <div class="comment-writer-section">작성자 :&nbsp<a href="#">월미도질주본능</a>
                                </div>
                            </div>
                        </li>
                        <li class="dummydata">
                            <div class="first-line-comment">
                                <div class="comment">맞팔좀 해주세요</div>
                                <div class="erase-button"><a href="#">삭제</a></div>
                            </div>
                            <div class="second-line-comment">
                                <div class="comment-writer-section">작성자 :&nbsp<a href="#">상무지구1등삐끼</a>
                                </div>
                            </div>
                        </li>
                        <li class="dummydata">
                            <div class="first-line-comment">
                                <div class="comment">몸 좋으시네요</div>
                                <div class="erase-button"><a href="#">삭제</a></div>
                            </div>
                            <div class="second-line-comment">
                                <div class="comment-writer-section">작성자 :&nbsp<a href="#">산본동왕쇼바</a>
                                </div>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>
        </div>

    </div>
</div>

<script src="${pageContext.servletContext.contextPath}/js/community-default.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/minihome-calander.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/minihome-default.js"></script>