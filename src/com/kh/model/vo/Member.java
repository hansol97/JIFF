package com.kh.model.vo;

public class Member {

    private int memberNo;
    private String memberId;
    private String memberPwd;
    private String memberName;
    private int age;
    private int grade;
    private int count;
    public Member() {
        super();
    }
    public Member(int memberNo, String memberId, String memberPwd, String memberName, int age, int grade, int count) {
        super();
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.age = age;
        this.grade = grade;
        this.count = count;
    }
    public Member(String memberId, String memberPwd, String memberName, int age) {
        super();
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.age = age;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "Member [memberId=" + memberId +  ", memberName="
                + memberName + ", grade=" + grade + "]";
    }
}
