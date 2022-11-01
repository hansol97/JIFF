package com.kh.model.dao;

import static com.kh.common.JIFFTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member logIn(Connection conn, String memberId, String memberPwd) {
		
		Member m = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("logIn");
		// "SELECT MEMBER_NAME FROM MEMBER WHERE MEMBER_ID = ?";
		//String SQL = "SELECT MEMBER FROM MEMBER WHERE MEMBER_ID = ?" // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.
		//											AND MEMBER_PWD =?"
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 있을때만
				m = new Member(rset.getInt("MEMBER_NO")
							  ,rset.getString("MEMBER_ID")
							  ,rset.getString("MEMBER_PWD")
							  ,rset.getString("MEMBER_NAME")
							  ,rset.getInt("AGE")
							  ,rset.getInt("GRADE")
							  ,rset.getInt("COUNT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rset);
			close(pstmt);
		}
		return m;
	}
	
	public int updateGrade(Connection conn, Member m) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    
	    String sql = prop.getProperty("updateGrade");
	    
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
	
	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		/*
		Properties prop = new Properties();
		prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		*/
		String sql = prop.getProperty("insertMember"); 
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setInt(4, m.getAge());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public void selectMem(Connection conn, Member m) {
	    PreparedStatement pstmt = null;
	    
	    String sql = prop.getProperty("logIn");
	    
	    
	    
	}
	
	public int updateMember(Connection conn , Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setInt(2, m.getAge());
			pstmt.setString(3, m.getMemberPwd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
