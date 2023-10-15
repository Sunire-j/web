<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

    $(function(){
        $.ajax({
            url:"${pageContext.servletContext.contextPath}/getfollowranking",
            type:'post',
            success:function(result){
                var rankingItems = $('.follow-ranking ul li').slice(2);
                for(var i = 0; i<result.length; i++){
                    var medal;
                    switch(i) {
                        case 0: medal = '🥇'; break;
                        case 1: medal = '🥈'; break;
                        case 2: medal = '🥉'; break;
                        default: medal = (i + 1) + '. '; break;
                    }
                    var obj = result[i];
                    $(rankingItems[i]).find('a').text(medal + obj.username).attr('href', "${pageContext.servletContext.contextPath}/minihome?id="+obj.userid);
                }
            },
            error:function(error){
                console.log(error.responseText);
            }
        });

        $.ajax({
            url:"${pageContext.servletContext.contextPath}/getpostranking",//게시글 랭킹 뽑아올 url
            type: 'post',
            success:function(result){
                //여기서 result, 즉 List<CommunityVO>를 활용한 구현
                var rankingItems = $('.like-ranking ul li').slice(2);
                for(var i = 0; i<result.length; i++){
                    var medal;
                    switch(i) {
                        case 0: medal = '🥇'; break;
                        case 1: medal = '🥈'; break;
                        case 2: medal = '🥉'; break;
                        default: medal = (i + 1) + '. '; break;
                    }
                    var obj = result[i];
                    $(rankingItems[i]).find('a').text(medal + obj.title).attr('href', "${pageContext.servletContext.contextPath}/board/view?post_id="+obj.post_id); //#자리에 뷰 주소 들어가야함
                }
            },
            error:function(error){
                console.log(error.responseText);
            }

        });

    });

</script>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/community-ranking-and-postlist.css">
<div class="left">
<!-- 팔로워 랭킹 리스트 -->
<div class="follow-ranking">
    <ul>
        <li class="ranking-head">팔로우 랭킹 🏆 </li>
        <li>&nbsp;</li>
        <li><a href="#">🥇</a></li>
        <li><a href="#">🥈</a></li>
        <li><a href="#">🥉</a></li>
        <li><a href="#">4.</a></li>
        <li><a href="#">5.</a></li>
        <li><a href="#">6.</a></li>
        <li><a href="#">7.</a></li>
        <li><a href="#">8.</a></li>
        <li><a href="#">9.</a></li>
    </ul>
</div>
<!-- 인기글 랭킹 리스트 -->
<div class="like-ranking">
    <ul>
        <li class="ranking-head">오늘의 인기글 🏆 </li>
        <li>&nbsp;</li>
        <li><a href="#">🥇</a></li>
        <li><a href="#">🥈</a></li>
        <li><a href="#">🥉</a></li>
        <li><a href="#">4.</a></li>
        <li><a href="#">5.</a></li>
        <li><a href="#">6.</a></li>
        <li><a href="#">7.</a></li>
        <li><a href="#">8.</a></li>
        <li><a href="#">9.</a></li>
    </ul>
</div>
</div>
