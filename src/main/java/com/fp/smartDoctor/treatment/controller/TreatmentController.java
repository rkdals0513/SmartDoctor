package com.fp.smartDoctor.treatment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fp.smartDoctor.treatment.model.service.TreatmentService;
import com.fp.smartDoctor.treatment.model.vo.ListSurgeryBooking;
import com.fp.smartDoctor.treatment.model.vo.Patient;
import com.fp.smartDoctor.treatment.model.vo.RevOProom;
import com.google.gson.Gson;

@Controller
public class TreatmentController {
	
	
	@Autowired 
	private TreatmentService tService;
	 
	
	@RequestMapping("enroll.tmt")
	public String enrollTreatment() {
		return "ljy/enrollTreatment";
	}
	
	

	//입원실 예약 조회 호출
	@RequestMapping("enrollForm.pr")
	public String prEnrollForm() {
		return "kcy/revPREnrollForm";
	}
	
	
	//수술실 예약 풀캘린더 조회
 	@RequestMapping("enrollForm.op")
	public String getCalendarList(ModelAndView mv, HttpServletRequest request) {
		return "kcy/revOREnrollForm";
		
		
//		List<Calendar> calendar = null;
//		try {
//			calendar = mService.getCalendar();
//			request.setAttribute("calendarList", calendar);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(calendar);
//		mv.setViewName(viewpage);
//		return mv;
	}
 	
 	@ResponseBody
 	@RequestMapping(value="list.ca", produces="application/json; charset=utf-8")
 	public String selectCalendarList() {
 		List<RevOProom> calendar = tService.getCalendar();
 		return new Gson().toJson(calendar);
 	}
	@RequestMapping("detail.mj")
	public String detail() {
		return "kmj/patientDetail";
	}
	@RequestMapping("pay.mj")
	public String pay() {
		return "kmj/page";
	}
	@RequestMapping("hospitalCalender.mj")
	public String hospitalCalender() {
		return "kmj/hospitalCalender";
	}

 	//수술실 예약 조회
	@RequestMapping("detail.op")
	public ModelAndView selectRevOProom(int no, ModelAndView mv) {
		
		ArrayList<ListSurgeryBooking> op = tService.selectRevOProom(no);
		mv.addObject("op", op).setViewName("kcy/revORDetail");
		
		return mv;
	}
	
	//수술실 예약을 위한 정보 조회
	@RequestMapping("fordetail.op")
	public ModelAndView selectforInsertRevOP(int no, ModelAndView mv) {
		
		ArrayList<ListSurgeryBooking> op = tService.selectRevOProom(no);
		mv.addObject("op", op).setViewName("kcy/revORDetail");
		
		return mv;
	}

	// 환자 조회
	@RequestMapping("detail.pt")
	public String selectPatient(Patient p, HttpSession session, ModelAndView mv) {
		
		Patient nowPatient = tService.selectNowPatient(p);
		System.out.println("진료중인 환자 : " + nowPatient);
		
		if(nowPatient == null) {
			session.setAttribute("alertMsg", "진료중인 환자가 없습니다.");
			return "redirect:enrollTreatment";
		}else {
			session.setAttribute("nowPatient", nowPatient);
			return "redirect:enrollTreatment";
		}
		
	}
}
