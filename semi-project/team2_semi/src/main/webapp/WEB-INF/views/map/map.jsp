<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/default.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/community-nav.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/community-header.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/community-ranking-and-postlist.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/css/community-map.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=43f789e75b8922b41ac6921c8e130658&libraries=services"></script>



<header>
	<!-- 게시판 알려주는 박스 -->
	<div class="intro-board"
		style="background-image: url(${pageContext.servletContext.contextPath}/img/Map_Banner.png);">
		<div class="board-name">주변 헬스장 찾기</div>
	</div>
</header>

<!-- #region start -->
<!-- 랭킹영역 -->
<!-- #region start -->
<div class="content">
	<div class="left">
		<div class="follow-ranking">
			<ul>
				<li class="ranking-head">팔로워 랭킹 🏆</li>
				<li>&nbsp;</li>
				<li><a href="MiniHome_Home.html">#🥇 하이룽</a></li>
				<li><a href="MiniHome_Home.html">#🥈 2등입니다.</a></li>
				<li><a href="MiniHome_Home.html">#🥉 내아래로메달없음</a></li>
				<li><a href="MiniHome_Home.html">#4 : 진자억울하다</a></li>
				<li><a href="MiniHome_Home.html">#5 : 근육돼지</a></li>
				<li><a href="MiniHome_Home.html">#6 : 아침은닭가슴살사과쉐이크</a></li>
				<li><a href="MiniHome_Home.html">#7 : 금잔디명예소방관</a></li>
				<li><a href="MiniHome_Home.html">#8 : 인생최대업적롤플레</a></li>
				<li><a href="MiniHome_Home.html">#9 : 닭가슴살도시락소믈리에</a></li>
			</ul>
		</div>
		<div class="like-ranking">
			<ul>
				<li class="ranking-head">인기글 랭킹 🏆</li>
				<li>&nbsp;</li>
				<li><a href="Community_post.html">#🥇 어깨가 너무 아파요</a></li>
				<li><a href="Community_post.html">#🥈 오늘 기록 갱신</a></li>
				<li><a href="Community_post.html">#🥉 닭가슴살 1+1+1 행사</a></li>
				<li><a href="Community_post.html">#4 : 프로틴 이 맛이 맞아요?</a></li>
				<li><a href="Community_post.html">#5 : 정보)스트랩 추천</a></li>
				<li><a href="Community_post.html">#6 : 집 앞 헬스장 시설 수준</a></li>
				<li><a href="Community_post.html">#7 : 입원했는데, 누워있으면 근손실옴?</a></li>
				<li><a href="Community_post.html">#8 : 헬스장 불났다</a></li>
				<li><a href="Community_post.html">#9 : 눈바디 어떰?</a></li>
			</ul>
		</div>
	</div>

	<!-- 지도 부분 -->

	<div class="right" style = "margin-top: 110px;">
		<!--  <div id="search-box">
					<input type="text" value="이태원" id="keyword" placeholder="장소 검색">
					<button id="search-button" onclick="drawmap()">검색</button>
				</div>-->
		<div class=" map-container">
			<div class="map_wrap">
				<div id="map"
					style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

				<div id="menu_wrap" class="bg_white">
					<div class="option">
						<div>
							<form onsubmit="searchPlaces(); return false;">
								키워드 : <input type="text" value="" id="keyword" size="15">
								<button type="submit">검색</button>
							</form>
						</div>
					</div>
					<hr>
					<ul id="placesList"></ul>
					<div id="pagination"></div>
				</div>
			</div>
		</div>
		<div id="review-form" style="display: none; height: 200px;">
			<h2>
				<span id="place-name"></span>
			</h2>



			<form
				action="${pageContext.servletContext.contextPath}/submit-review"
				method="post">
				<label>별점:</label><br>
				<div class="star-rating">
					<input type="radio" id="5-stars" name="rating" value="5" /> <label
						for="5-stars" class="star">&#9733;</label> <input type="radio"
						id="4-stars" name="rating" value="4" /> <label for="4-stars"
						class="star">&#9733;</label> <input type="radio" id="3-stars"
						name="rating" value="3" /> <label for="3-stars" class="star">&#9733;</label>
					<input type="radio" id="2-stars" name="rating" value="2" /> <label
						for="2-stars" class="star">&#9733;</label> <input type="radio"
						id="1-star" name="rating" value="1" /> <label for="1-star"
						class="star">&#9733;</label>
				</div>
				<input type="hidden" id="placeName" value="placeName"
					name="placeName" /> <input type="hidden" id="x" value="x" name="x" />
				<input type="hidden" id="y" value="y" name="y" /> <br>
				<textarea name='comment'
					style="width: 100%; height: 40px; border: 1px solid #CCCCCC; background-color: #FFFDD0;"
					placeholder='리뷰를 남겨주세요'></textarea>

				<br /> <input type='submit' value='등록' />


			</form>

		</div>
		<div id="reviewBox"
			style="border: 1px solid #CCCCCC; background-color: #FFFDD0; width: 100%; overflow-y:auto; max-height: 300px; min-height: 100px; margin-top: 30px; display:none;">
			<!-- 여기에 리뷰 정보가 들어갑니다. -->
			<ul id="reviewlist">

			</ul>
		</div>
	</div>
</div>


<script>
			function fillForm(placeName, x, y) {
				document.getElementById('placeName').value = placeName;
				document.getElementById('x').value = x;
				document.getElementById('y').value = y;
			}
		</script>


<script>



			function showReviewForm(y, x, placeName) {
				console.log(placeName);
				document.getElementById('review-form').style.display = 'block';
				document.getElementById('place-name').textContent = placeName;
				document.getElementById('placeName').value = placeName;
				var inputx = document.getElementById('x');
				var inputy = document.getElementById('y');
				inputx.value = x.toString();
				inputy.value = y.toString();
				getreview(y.toString(),x.toString(),placeName);
			}
	function getreview(y,x,placeName){
		var reviewboxdiv = document.getElementById("reviewBox");
		reviewboxdiv.style.display="block";
		$.ajax({
			url:"${pageContext.servletContext.contextPath}/getreview",
			data:{
				x:x,
				y:y,
				placeName:placeName
			},
			type:'post',
			success:function(result){
				$('#reviewlist').empty();
				$(result).each(function(index,reviewvo){
					var rating = reviewvo.rating;
					console.log(reviewvo.comment);
					var star="";
					for(var i =0; i<rating; i++) {
						star += "⭐";
					}
					var htmltag = "<li class='review' style='border-bottom:1px solid #ddd;'>";
					htmltag +="<p class='rating'>"+star+"</p>";
					htmltag +="<p class='comment'>"+reviewvo.review+"</p>";
					htmltag +="<p class='author'><a href = '${pageContext.servletContext.contextPath}/minihome?id="+reviewvo.userid+"'>"+reviewvo.userid+"</a></p>";
					htmltag +="</li>";
					
					$('#reviewlist').append(htmltag);
				});
			},
			error:function(error){
				
			}
		});
	}
	</script>



<script
	src="${pageContext.servletContext.contextPath}/js/community-default.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/community-map.js"></script>
