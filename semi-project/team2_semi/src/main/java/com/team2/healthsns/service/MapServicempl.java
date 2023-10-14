package com.team2.healthsns.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.team2.healthsns.mapper.MapMapper;
import com.team2.healthsns.vo.ReviewVO;

@Service
public class MapServicempl implements MapService {
	@Inject 
	MapMapper mapper;

	@Override
	public int WriteReview(ReviewVO vo) {
		// TODO Auto-generated method stub
		return mapper.WriteReview(vo);
	}

	@Override
	public List<ReviewVO> GetPlaceReview(String x, String y, String placeName) {
		// TODO Auto-generated method stub
		return mapper.GetPlaceReview(x, y, placeName);
	}

}
