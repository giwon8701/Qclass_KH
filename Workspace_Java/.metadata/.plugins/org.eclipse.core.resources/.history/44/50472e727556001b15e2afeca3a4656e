package com.biz;

import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {
	
	private ScoreDao dao;
	
	public ScoreBizImpl() {
		dao = new ScoreDaoImpl();
	}

	@Override
	public List<ScoreDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(int s_no) {
		return dao.selectOne(s_no);
	}

	@Override
	public int insert(ScoreDto score) {
		int sum = getSum(score.getS_kor(), score.getS_eng(), score.getS_math());
		double avg = getAvg(sum);
		String grade = getGrade(avg);
		
		score.setS_sum(sum);
		score.setS_avg(avg);
		score.setS_grade(grade);
		
		return dao.insert(score);
	}

	@Override
	public int update(ScoreDto score) {
		int sum = getSum(score.getS_kor(), score.getS_eng(), score.getS_math());
		double avg = getAvg(sum);
		String grade = getGrade(avg);
		
		score.setS_sum(sum);
		score.setS_avg(avg);
		score.setS_grade(grade);
		
		return dao.update(score);
	}

	@Override
	public int delete(int s_no) {
		return dao.delete(s_no);
	}
	
	private int getSum(int kor, int eng, int math) {
		return kor +  eng + math;
	}
	
	private double getAvg(int sum) {
		return sum / 3.0;
	}

	private String getGrade(double avg) {
		
		switch((int)avg/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
}


















