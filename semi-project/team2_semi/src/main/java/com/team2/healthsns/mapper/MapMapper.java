package com.team2.healthsns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team2.healthsns.vo.ReviewVO;

@Mapper
public interface MapMapper {
	public int WriteReview(ReviewVO vo);
	public List<ReviewVO> GetPlaceReview(String x,String y,String placeName);
}
