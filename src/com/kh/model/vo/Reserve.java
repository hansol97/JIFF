package com.kh.model.vo;

import java.sql.Date;

public class Reserve {
    private int reserveNo;
    private int memberNo;
    private int movieNo;
    private String viewDate;
    private String cancleYn;
    
    
    public Reserve() {
        super();
    }
    public Reserve(int reserveNo, int memberNo, int movieNo, String viewDate, String cancleYn) {
        super();
        this.reserveNo = reserveNo;
        this.memberNo = memberNo;
        this.movieNo = movieNo;
        this.viewDate = viewDate;
        this.cancleYn = cancleYn;
    }
    
    
    public int getReserveNo() {
        return reserveNo;
    }
    public void setReserveNo(int reserveNo) {
        this.reserveNo = reserveNo;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public int getMovieNo() {
        return movieNo;
    }
    public void setMovieNo(int movieNo) {
        this.movieNo = movieNo;
    }
    public String getViewDate() {
        return viewDate;
    }
    public void setViewDate(String viewDate) {
        this.viewDate = viewDate;
    }
    public String getCancleYn() {
        return cancleYn;
    }
    public void setCancleYn(String cancleYn) {
        this.cancleYn = cancleYn;
    }
    
    @Override
    public String toString() {
        return "Reserve [" + reserveNo + "] memberNo=" + memberNo + ", movieNo=" + movieNo + ", viewDate="
                + viewDate + ", cancleYn=" + cancleYn + "]";
    }
}
