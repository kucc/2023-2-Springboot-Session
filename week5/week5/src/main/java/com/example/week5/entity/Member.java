package com.example.week5.entity;

public class Member {
    public int memberId; // 인스턴스 변수
    public String name;
    public int teamId;

    // 생성자 : 반환타입
    public Member(int memberId, String name, int teamId) {
        this.memberId = memberId; // this 참조변수
        this.name = name;
        this.teamId = teamId;
    }
}
