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
    //TODO : member 매핑

    public Team(int teamId, String teamname) {
        this.teamId = teamId;
        this.teamname = teamname;
    }

    public Team() {

    }
}
