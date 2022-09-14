package com.fp.smartDoctor.treatment.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.fp.smartDoctor.treatment.model.vo.Clinic;
import com.fp.smartDoctor.treatment.model.vo.ListSurgeryBooking;
import com.fp.smartDoctor.treatment.model.vo.Patient;
import com.fp.smartDoctor.treatment.model.vo.RevOProom;

@Repository
public class TreatmentDao {

	
	//수술실 예약 상세조회
	public RevOProom selectRevOProom(SqlSessionTemplate sqlSession,int bookingNo) {
		return sqlSession.selectOne("treatmentMapper.selectOProom", bookingNo);
	}
	
	//수술실 예약을 위한 정보조회
	public Clinic selectforInsertRevOP(SqlSessionTemplate sqlSession, int clinicNo) {
		//ListSurgeryBooking list  = new ListSurgeryBooking();
		
		Clinic c = sqlSession.selectOne("treatmentMapper.forinsertOProom",clinicNo);
		return c;
	}
	
	
	
	//수술실 예약 풀캘린더 정보 조회
	public List<RevOProom> getCalendar(SqlSessionTemplate sqlSession)  {
		List<RevOProom> calendar = sqlSession.selectList("treatmentMapper.calendarList");
		return calendar;
	}
	
	//수술실 중복 체크
	public int checkOverlapRsv(SqlSessionTemplate sqlSession, HashMap<String, String> paraMap) {
		return sqlSession.selectOne("treatmentMapper.checkOverlapRsv", paraMap);
	}
	
	//수술실 예약(insert)
	public int insertReservation(SqlSessionTemplate sqlSession, HashMap<String, String> paraMap) {
		return sqlSession.insert("treatmentMapper.insertReservation", paraMap);
	}
	
	//수술실 예약 취소
	public int cslRsvOP(SqlSessionTemplate sqlSession, int bookingNo) {
		return sqlSession.update("treatmentMapper.rsvCancel",bookingNo);
	}
	
	
	public Patient selectNowPatient(SqlSessionTemplate sqlSession, Patient p) {
		return sqlSession.selectOne("treatmentMapper.selectNowPatient", p);
	}
}