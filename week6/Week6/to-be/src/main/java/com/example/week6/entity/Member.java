package com.example.week6.entity;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int memberId; // 인스턴스 변수
    public String name;
    @ManyToOne
    @JoinColumn(name = "teamId")
    public Team team;

    // 생성자 : 반환타입
    public Member(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    // 인자 없는 생성자
    public Member() {

    }
}
