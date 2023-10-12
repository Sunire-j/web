package com.team2.healthsns.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String userid;
    private String userpwd;
    private String username;
    private String email;
    private String pwd_q;
    private String pwd_a;
    private String date;
    private String profile_img;
    private String comment;
}
