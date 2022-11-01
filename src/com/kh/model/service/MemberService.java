package com.kh.model.service;

import java.sql.Connection;
import static com.kh.common.JIFFTemplate.*;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {
    
    public Member logIn(String memberId, String memberPwd) {
        
        Connection conn = getConnection();
        Member m = new MemberDao().logIn(conn, memberId, memberPwd);
        
        close(conn);
        return m;

        
    }
    
    public void selectMem(Member m) {
        Connection conn = getConnection();
        
        new MemberDao().selectMem(conn, m);
    }
    
    public void updateGrade(Member m) {
        Connection conn = getConnection();
        
        int result = new MemberDao().updateGrade(conn, m);
        System.out.println(result);
        
        if (result > 0) commit(conn);
        else rollback(conn);
        
        close(conn);
                
    }

    public int insertMember(Member m) {
        
        Connection conn = getConnection();
        int result = new MemberDao().insertMember(conn, m);
        
        if(result >0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
    public int updateMember(Member m) {
        Connection conn =getConnection();
        int result = new MemberDao().updateMember(conn, m);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
}
