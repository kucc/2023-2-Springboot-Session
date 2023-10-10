package com.example.week3.entity;

public class Tutor extends Member {
    public String subject;

    public Tutor(int userId, String username, String subject) {
        super(userId, username);
        this.subject = subject;
    }
}