package com.team2.healthsns.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
	private int reviewid;
	private String userid;
	private String name;
	private int rating;
	private String latitude;
	private String longitude;
	private String review;
}
