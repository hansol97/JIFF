package com.kh.controller;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MainView;

public class MemberController {

    public void logIn(String memberId, String memberPwd) {
        Member m = new MemberService().logIn(memberId, memberPwd);

        if (m.getMemberId() == null) {
            new MainView().displayNodata("아이디와 비밀번호를 다시 한 번 확인해주세요.");
        } else {
            new MemberService().updateGrade(m);
            m = new MemberService().logIn(memberId, memberPwd);
            new MainView().memberMenu(m);
        }
    }

    public void insertMember(String memberId, String memberPwd, String memberName, int age) {

        Member m = new Member(memberId, memberPwd, memberName, age);

        int result = new MemberService().insertMember(m);

        if (result > 0) {
            new MainView().displaySuccess("회원 추가 성공");
        } else {
            new MainView().displayFail("회원 추가 실패 ");
        }

    }
    
    public void selectMem(Member m) {
        new MemberService().selectMem(m);
    }

    public void updateMember(String memberPwd, String newPwd, int newAge) {
        Member m = new Member();

        m.setMemberId(memberPwd);
        m.setMemberPwd(newPwd);
        m.setAge(newAge);

        int result = new MemberService().updateMember(m);

        if (result > 0) {
            new MainView().displaySuccess("회원 정보 수정 성공");
        } else {
            new MainView().displayFail("회원 정보 수정 실패");
        }

    }

}
