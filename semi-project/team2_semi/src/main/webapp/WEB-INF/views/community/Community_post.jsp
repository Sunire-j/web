<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/community-nav.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/community-header.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/community-ranking-and-postlist.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/community-post.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<!-- ck에디터 -->
<script src="https://cdn.ckeditor.com/ckeditor5/39.0.2/super-build/ckeditor.js"></script>
<div class="check-post">
    <a href="">전체 게시물</a>&nbsp;&nbsp;&nbsp;
    <a href="Community_Show_MyPost.html">내 게시물</a>
    <hr>
</div>
<!-- #게시물 선택 바 끝/-->
<!-- 부위 카테고리 리스트 시작 -->
<div class="muscle-categories">
    <p>부위 카테고리</p>
</div>
<!-- 부위 카테고리 리스트 끝 -->
<div class="post_div" style="margin: 0 auto">
    <div class="content">
        <div class="content_title">
            <h1>${vo.title}</h1>
                <c:if test="${vo.board_cat=='auth'}">
            <h4>게시판 : <span><a href="#">인증게시판</a></span></h4>
                </c:if>
                <c:if test="${vo.board_cat=='free'}">
                    <h4>게시판 : <span><a href="#">자유게시판</a></span></h4>
                </c:if>
                <c:if test="${vo.board_cat=='qna'}">
                    <h4>게시판 : <span><a href="#">Q&A게시판</a></span></h4>
                </c:if>
            <hr>
        </div>
        <div class="content_post" style="min-height: 200px">
            ${vo.content}
        </div>
        <div class="content-post-tail" id="comment-anchor">
            <a href="#"><img src="../img/thumbs-up.png" alt="" class="icon">&nbsp;&nbsp;좋아요</a>
            <a href="#"><img src="../img/share-icon.jpg" alt="" class="icon">&nbsp;&nbsp;공유</a>
            <hr style="margin-top:10px;">
        </div>
        <div class="comment-area">
            <div class="comments_container bootdey">
                <div class="col-md-12 bootstrap snippets">
                    <div class="panel">
                        <div class="panel-body">
                            <textarea class="form-control" rows="2" placeholder="댓글을 입력하세요."></textarea>
                            <div class="mar-top clearfix">
                                <button class="btn btn-sm btn-primary pull-right" type="submit"><i
                                        class="fa fa-pencil fa-fw"></i> 작성
                                </button>
                                <a class="btn btn-trans btn-icon fa fa-video-camera add-tooltip" href="#"></a>
                                <a class="btn btn-trans btn-icon fa fa-camera add-tooltip" href="#"></a>
                                <a class="btn btn-trans btn-icon fa fa-file add-tooltip" href="#"></a>
                            </div>
                        </div>
                    </div>
                    <div class="panel">
                        <div class="panel-body">

                            <!-- 답글 작성 폼 -->
                            <div class="reply-form" style="display: none;">
                                <textarea class="form-control" rows="2" placeholder="답글을 입력하세요."></textarea>
                                <div class="mar-top clearfix">
                                    <button class="btn btn-sm btn-primary pull-right reply-submit-btn"
                                            type="submit"><i class="fa fa-pencil fa-fw"></i> 작성
                                    </button>
                                </div>
                            </div>

                            <div class="comments-block">
                                <a class="media-left" href="MiniHome_Home.html"><img class="img-circle img-sm"
                                                                                     alt="Profile Picture"
                                                                                     src="../img/profile1.png"></a>
                                <div class="media-body">
                                    <div class="mar-btm">
                                        <a href="MiniHome_Home.html"
                                           class="btn-link text-semibold media-heading box-inline">로니콜먼2</a>
                                        <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> 11분 전</p>
                                    </div>
                                    <p>와 몸 진짜 좋으세요 어떤 운동하세요?</p>
                                    <div class="pad-ver">
                                        <div class="btn-group">
                                            <a class="btn btn-sm btn-default btn-hover-success" href="#"><i
                                                    class="fa fa-thumbs-up"></i></a>
                                            <a class="btn btn-sm btn-default btn-hover-danger" href="#"><i
                                                    class="fa fa-thumbs-down"></i></a>
                                        </div>
                                        <a class="btn btn-sm btn-default btn-hover-primary" href="#">답글 작성</a>
                                    </div>
                                    <hr>

                                    <div>
                                        <div class="comments-block reply">
                                            <a class="media-left" href="MiniHome_Home.html"><img
                                                    class="img-circle img-sm" alt="Profile Picture"
                                                    src="../img/profile2.png"></a>
                                            <div class="media-body">
                                                <div class="mar-btm">
                                                    <a href="MiniHome_Home.html"
                                                       class="btn-link text-semibold media-heading box-inline">월미도질주남</a>
                                                    <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i>
                                                        7분 전</p>
                                                </div>
                                                <p>와 등 미쳤다..</p>
                                                <div class="pad-ver">
                                                    <div class="btn-group">
                                                        <a class="btn btn-sm btn-default btn-hover-success active"
                                                           href="#"><i class="fa fa-thumbs-up"></i> 좋아요 완료</a>
                                                        <a class="btn btn-sm btn-default btn-hover-danger"
                                                           href="#"><i class="fa fa-thumbs-down"></i></a>
                                                    </div>
                                                    <a class="btn btn-sm btn-default btn-hover-primary" href="#">답글
                                                        작성</a>
                                                </div>
                                                <hr>
                                            </div>
                                        </div>
                                        <div class="comments-block reply">
                                            <a class="media-left" href="MiniHome_Home.html"><img
                                                    class="img-circle img-sm" alt="Profile Picture"
                                                    src="../img/profile3.png">
                                            </a>
                                            <div class="media-body">
                                                <div class="mar-btm">
                                                    <a href="MiniHome_Home.html"
                                                       class="btn-link text-semibold media-heading box-inline">퉁퉁이</a>
                                                    <p class="text-muted text-sm"><i class="fa fa-globe fa-lg"></i>
                                                        2분 전</p>
                                                </div>
                                                <p>비가 와도 멈추지않아.</p>
                                                <div class="pad-ver">
                                                    <div class="btn-group">
                                                        <a class="btn btn-sm btn-default btn-hover-success"
                                                           href="#"><i class="fa fa-thumbs-up"></i></a>
                                                        <a class="btn btn-sm btn-default btn-hover-danger"
                                                           href="#"><i class="fa fa-thumbs-down"></i></a>
                                                    </div>
                                                    <a class="btn btn-sm btn-default btn-hover-primary" href="#">답글
                                                        작성</a>
                                                </div>
                                                <hr>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="comments-block">
                                <a class="media-left" href="MiniHome_Home.html"><img class="img-circle img-sm"
                                                                                     alt="Profile Picture"
                                                                                     src="../img/profile4.png"></a>
                                <div class="media-body">
                                    <div class="mar-btm">
                                        <a href="MiniHome_Home.html"
                                           class="btn-link text-semibold media-heading box-inline">별 거
                                            없네</a>
                                        <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> 11분 전</p>
                                    </div>
                                    <p>솔직히 제 몸이 더 좋죠?</p>
                                    <img class="img-responsive thumbnail" src="../img/body1.jpg" alt="Image">
                                    <div class="pad-ver">
                                            <span class="tag tag-sm"><i class="fa fa-heart text-danger"></i> 250
                                                좋아요</span>
                                        <div class="btn-group">
                                            <a class="btn btn-sm btn-default btn-hover-success" href="#"><i
                                                    class="fa fa-thumbs-up"></i></a>
                                            <a class="btn btn-sm btn-default btn-hover-danger" href="#"><i
                                                    class="fa fa-thumbs-down"></i></a>
                                        </div>
                                        <a class="btn btn-sm btn-default btn-hover-primary" href="#">답글 작성</a>
                                    </div>
                                    <hr>

                                    <div>
                                        <div class="comments-block reply">
                                            <a class="media-left" href="MiniHome_Home.html"><img
                                                    class="img-circle img-sm" alt="Profile Picture"
                                                    src="../img/profile5.png"></a>
                                            <div class="media-body">
                                                <div class="mar-btm">
                                                    <a href="MiniHome_Home.html"
                                                       class="btn-link text-semibold media-heading box-inline">성실남</a>
                                                    <p class="text-muted text-sm"><i class="fa fa-globe fa-lg"></i>
                                                        2분 전</p>
                                                </div>
                                                <p>왜 그렇게 삐뚤어지셨어요.. 근데 몸 진짜 좋으시네요 ㄷㄷ</p>
                                                <div>
                                                    <div class="btn-group">
                                                        <a class="btn btn-sm btn-default btn-hover-success"
                                                           href="#"><i class="fa fa-thumbs-up"></i></a>
                                                        <a class="btn btn-sm btn-default btn-hover-danger"
                                                           href="#"><i class="fa fa-thumbs-down"></i></a>
                                                    </div>
                                                    <a class="btn btn-sm btn-default btn-hover-primary" href="#">답글
                                                        작성</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
            <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
            <script type="text/javascript">


                $(document).ready(function () {
                    $('.btn-hover-primary').click(function (e) {
                        e.preventDefault();

                        // 기존의 열려있는 답글 폼이 있다면 제거
                        $('.reply-form').remove();

                        // 새로운 답글 폼 생성 및 삽입
                        var replyForm = $(
                            '<div class="reply-form">' +
                            '<textarea class="form-control" rows="2" placeholder="답글을 입력하세요."></textarea>' +
                            '<div class="mar-top clearfix">' +
                            '<button class="btn btn-sm btn-primary pull-right reply-submit-btn"><i class=\"fa fa-pencil fa-fw\"></i> 작성</button>' +
                            '</div>' +
                            '</div>'
                        );

                        $(this).parent().after(replyForm);
                    });

                    // '작성' 버튼 클릭 이벤트 처리
                    $(document).on('click', '.reply-submit-btn', function (e) {
                        e.preventDefault();
                        alert('답변이 등록되었습니다.');  // 실제 로직으로 대체 필요
                        $('.reply-form').remove();  // 답변 등록 후 폼 제거
                    });
                });

            </script>
        </div>

    </div>
    <div class="content_side_div" style="max-height: 300px">
        <div class="comment_button_side">
            <button onclick="scrollToElement('comment-anchor')">댓글</button>
        </div>

        <div class="like_comment_count">
            <div class="item">
                <img src="../img/view.png" alt="조회수">
                <p>조회수 : 10</p>
            </div>
            <div class="item">
                <img src="../img/comment.png" alt="댓글">
                <p>댓글 : 20</p>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.servletContext.contextPath}/js/community-post.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/community-default.js"></script>