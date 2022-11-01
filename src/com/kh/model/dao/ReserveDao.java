package com.kh.model.dao;

import static com.kh.common.JIFFTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;
import com.kh.model.vo.Reserve;

public class ReserveDao {
    
    private Properties prop = new Properties();
    
    public ReserveDao(){
        try {
            prop.loadFromXML(new FileInputStream("resources/reserve-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 예매하기
    public int insertReserve(Connection conn, Reserve r) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("insertReserve");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, r.getMemberNo());
            pstmt.setInt(2, r.getMovieNo());
            pstmt.setString(3, r.getViewDate());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    public int selectMovie(Connection conn, int movieNo) {

        int flag = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("selectMovie");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, movieNo);
            flag = pstmt.executeQuery().next() ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return flag;
    }
    
    // 예매시 카운트 증가
    public int increseCount(Connection conn, Member m) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("increseCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, m.getMemberNo());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    // 예매 목록 보기
    public ArrayList<Reserve> selectReserve(Connection conn, Member m) {
        ArrayList<Reserve> list = new ArrayList<Reserve>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectReserve");
                
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, m.getMemberNo());
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Reserve(rset.getInt("RESERVE_NO"),
                                     rset.getInt("MEMBER_NO"),
                                     rset.getInt("MOVIE_NO"),
                                     rset.getString("VIEW_DATE"),
                                     rset.getString("CANCLE_YN")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
    }
    
    // 예매 취소
    public int deleteReserve(Connection conn, int reserveNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("deleteReserve");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reserveNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
    
    public int selectReserve(Connection conn, int reserveNo) {

        int flag = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("selectReserve");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, reserveNo);
            flag = pstmt.executeQuery().next() ? 1 : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return flag;
    }
    
    // 예매 취소 시 카운트 감소
    public int decreseCount(Connection conn, Member m) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("decreseCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getMemberId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        
        return result;
    }
}
