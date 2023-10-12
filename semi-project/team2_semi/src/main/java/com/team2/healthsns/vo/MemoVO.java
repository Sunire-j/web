package com.team2.healthsns.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoVO {
    private int memoid;
    private String userid;
    private int emoji;
    private String write_date;
    private String cat;
    private String content;
    private String bodypart;
    private int add_auth;
}
