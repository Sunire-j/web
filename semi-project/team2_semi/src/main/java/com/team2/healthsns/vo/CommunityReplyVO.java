package com.team2.healthsns.vo;

import lombok.Data;

@Data
public class CommunityReplyVO {
    private int comment_id;
    private String writer;
    private int post_id;
    private String content;
    private int like;
    private int target_parent;
    private String write_date;
    private int depth;
    private String email;
    private int isdelete;
}
