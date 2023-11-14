package com.example.week6.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int teamId;
    public String teamname;
    @OneToMany(mappedBy = "team")
    public List<Member> members = new ArrayList<>();

    public Team(int teamId, String teamname) {
        this.teamId = teamId;
        this.teamname = teamname;
    }

    public Team() {

    }
}
