package com.team2.healthsns.service;

import java.util.List;

import com.team2.healthsns.vo.ReviewVO;

public interface MapService {
	public int WriteReview(ReviewVO vo);
	public List<ReviewVO> GetPlaceReview(String x,String y,String placeName);

}
