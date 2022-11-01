package com.kh.controller;


import java.util.ArrayList;

import com.kh.model.service.ReserveService;
import com.kh.model.vo.Member;
import com.kh.model.vo.Reserve;
import com.kh.view.MainView;

public class ReserveController {

    // 예매하기
    public void insertReserve(Member m, int movieNo, String viewDate) {
        
        int flag = new ReserveService().selectMovie(movieNo);
        if (flag == 0) {
            new MainView().displayFail("존재하지 않는 영화입니다.");
            return;
        }
        
        Reserve r = new Reserve();
        r.setMemberNo(m.getMemberNo());
        r.setMovieNo(movieNo);
        r.setViewDate(viewDate);
        
        int result = new ReserveService().insertReserve(r);

        if (result > 0) { // 예매 성공시 실행
            // 예매 성공 시 count 증가
            
            int result2 = new ReserveService().increseCount(m);
            if (result2 > 0) {
                new MainView().displaySuccess("예매되었습니다.");
            } else new MainView().displayFail("예매 실패");
        } else {
            new MainView().displayFail("예매 실패");
        }
    }
    
    // 예매 목록 보기
    public void selectReserve(Member m) {
        ArrayList<Reserve> list = new ReserveService().selectReserve(m);

        if (list.isEmpty()) {
            new MainView().displayFail("예매 내역이 없습니다.");
        } else {
            new MainView().reserveList(list);
        }
    }
    
    // 예매 취소
    public void deleteReserve(Member m, int reserveNo) {
        int result = new ReserveService().deleteReserve(reserveNo);
        
        if (result > 0) {
            int result2 = new ReserveService().decreseCount(m);
            if(result2 > 0) {
                new MainView().displaySuccess("취소되었습니다.");
            } else new MainView().displayFail("예매 취소 실패");
        }
        else new MainView().displayFail("예매 취소 실패");
    }
}
