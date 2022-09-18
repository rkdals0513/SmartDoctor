package com.fp.smartDoctor.notice.model.service;

import java.util.ArrayList;

import com.fp.smartDoctor.common.model.vo.PageInfo;
import com.fp.smartDoctor.notice.model.vo.Notice;

public interface NoticeService {
	
	// 공지사항 리스트 조회
	int selectListCount();
	ArrayList<Notice> selectList(PageInfo pi);
	
	// 공지사항 작성하기
	int insertNotice(Notice n);
	
	// 공지사항 상세조회
	int increaseCount(int noticeNo);
	Notice selectNotice(int noticeNo);
	
	// 공지사항 삭제
	int deleteNotice(int noticeNo);

}
