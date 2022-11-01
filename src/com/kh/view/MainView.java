package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.controller.MovieController;
import com.kh.controller.ReserveController;
import com.kh.model.vo.Member;
import com.kh.model.vo.Movie;
import com.kh.model.vo.Reserve;

public class MainView {

    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();
    private MovieController vc = new MovieController();
    private ReserveController rc = new ReserveController();

    public void mainMenu() {
        while (true) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("0. 종료");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
            case 1:
                logIn();
                break;
            case 2:
                insertMember();
                break;
            case 0:
                System.out.println("프로그램을 종료합니다.");
                return;
            default:
                System.out.println("잘못 누르셨습니다.");
            }
        }
    }

    public void logIn() {
        System.out.print("아이디입력 : ");
        String memberId = sc.nextLine();
        System.out.print("비밀번호 입력 : ");
        String memberPwd = sc.nextLine();

        mc.logIn(memberId, memberPwd);

    }

    public void insertMember() {
        System.out.println("-- 회원가입 --");
        System.out.print("아이디 : ");
        String memberId = sc.nextLine();
        System.out.print("비밀번호 :");
        String memberPwd = sc.nextLine();
        System.out.print("회원 이름 : ");
        String memberName = sc.nextLine();
        System.out.print("회원 나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        mc.insertMember(memberId, memberPwd, memberName, age);

    }

    public void memberMenu(Member m) {
        System.out.println(m);
        System.out.println("안녕하세요\n");
        while (true) {
            System.out.println("1. 전체 영화 목록");
            System.out.println("2. 제목으로 검색");
            System.out.println("3. 장르별 찾기");
            System.out.println("4. 영화 예매하기");
            System.out.println("5. 예매 내역 보기");
            System.out.println("6. 예매 취소하기");
            System.out.println("7. 회원 정보 수정");
            System.out.println("0. 로그아웃");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
            case 1:
                selectAll();
                break;
            case 2:
                selectByTitle();
                break;
            case 3:
                selectByGenre();
                break;
            case 4:
                insertReserve(m);
                break;
            case 5:
                selectReserve(m);
                break;
            case 6:
                deleteReserve(m);
                break;
            case 7:
                updateMember();
                break;
            case 0:
                System.out.println("로그아웃 합니다.");
                m = null;
                return;
            default:
                System.out.println("잘못 누르셨습니다.");
            }
        }
    }
    
    
    
    public void selectAll() {
        System.out.println("---- 현재 상영중인 영화 목록----");
        vc.selectAll();
    }
    
    public void selectByTitle() {
        System.out.println("---- 제목으로 검색하기 ----");
        System.out.println("검색할 제목을 입력하세요");
        String keyword = sc.nextLine();
        
        vc.selectByTitle(keyword);
    }
    
    
    public void selectByGenre() {
        System.out.println("--- 장르 모아 보기 ----");
        System.out.println("보고 싶은 장르를 검색해주세요");
        String genre = sc.nextLine();
        
        vc.selectByGenre(genre);
    }

    public void updateMember() {
        System.out.println("-- 회원 정보 수정 --");
        System.out.println("현재 비밀번호 : ");
        String memberPwd = sc.nextLine();
        
        System.out.print("새 비밀번호 : ");
        String newPwd = sc.nextLine();
        System.out.print("변경 나이 : ");
        int newAge = sc.nextInt();
        sc.nextLine();
        
        mc.updateMember(memberPwd, newPwd, newAge);
        
    }
    
    // 예매하기
    private void insertReserve(Member m) {
        System.out.print("영화 번호 : ");
        int movieNo = sc.nextInt();
        sc.nextLine();
        System.out.print("상영 날짜 : ");
        String viewDate = sc.nextLine();

        rc.insertReserve(m, movieNo, viewDate);
    }

    // 예매목록보기 요청
    private void selectReserve(Member m) {
        rc.selectReserve(m);
    }

    // 예매 취소
    private void deleteReserve(Member m) {

        rc.selectReserve(m);

        System.out.print("예매 취소할 번호를 입력해주세요. :");
        int reserveNo = sc.nextInt();
        sc.nextLine();
        rc.deleteReserve(m, reserveNo);
    }

    // 예매 목록 보기
    public void reserveList(ArrayList<Reserve> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + "\n");
        }
    }

    // ---------------------------------------------------------------

    public void displaySuccess(String message) {
        System.out.println(message);
    }

    public void displayFail(String message) {
        System.out.println(message);
    }
    public void displayNodata(String message) {
        System.out.println(message);
    }
    
    public void displayOne(ArrayList<Movie> list) {
        for(int i = 0; i<list.size(); i++) {            
            System.out.println(list.get(i));
        }
    }
    
    public void displayOne(Movie m) {
        System.out.println(m);
    }
}
