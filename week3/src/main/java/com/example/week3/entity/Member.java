package com.example.week3.entity;

public class Member {
    public int userId; // 인스턴스 변수
    public String username;

    // 생성자 : 반환타입
    public Member(int userId, String username) {
        this.userId = userId; // this 참조변수
        this.username = username;
    }

    public void sayName() {
        System.out.println("제 이름은 " + this.username);
    }
}
