package com.kh.model.service;

import static com.kh.common.JIFFTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.ReserveDao;
import com.kh.model.vo.Member;
import com.kh.model.vo.Reserve;

public class ReserveService {
    
    // 예매하기
    public int insertReserve(Reserve r) {
        Connection conn = getConnection();
        
        int result = new ReserveDao().insertReserve(conn, r);
        
        if (result > 0) commit(conn);
        else rollback(conn);
        
        close(conn);
        
        return result;
    }
    
    public int selectMovie(int movieNo) {
        Connection conn = getConnection();
        
        int flag = new ReserveDao().selectMovie(conn, movieNo);
        
        close(conn);
        
        return flag;
    }
    
    // 예매 성공 시 카운트 증가
    public int increseCount(Member m) {
        Connection conn = getConnection();
        
        int result2 = new ReserveDao().increseCount(conn, m);
        
        if (result2 > 0) commit(conn);
        else rollback(conn);
        
        close(conn);
        
        return result2;
                
    }
    
    // 예매 목록 보기
    public ArrayList<Reserve> selectReserve(Member m) {
        Connection conn = getConnection();
        
        ArrayList<Reserve> list = new ReserveDao().selectReserve(conn, m);
        
        close(conn);
        
        return list;
    }
    
    // 예매 취소
    public int deleteReserve(int reserveNo) {
        Connection conn = getConnection();
        
        int result = new ReserveDao().deleteReserve(conn, reserveNo);
        
        if (result > 0) commit(conn);
        else rollback(conn);
        
        close(conn);
        
        return result;
    }
    
    // 예매 취소 시 카운트 감소
    public int decreseCount(Member m) {
        Connection conn = getConnection();
        
        int result = new ReserveDao().decreseCount(conn, m);
        
        if (result > 0) commit(conn);
        else rollback(conn);
        
        close(conn);
        
        return result;
    }
}
