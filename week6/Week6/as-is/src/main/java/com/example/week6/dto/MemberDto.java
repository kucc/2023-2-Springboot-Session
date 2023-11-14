package com.example.week6.dto;

public class MemberDto {
    public Integer memberId;
    public String memberName;
    public Integer teamId;

    public MemberDto(Integer memberId, String memberName, Integer teamId) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.teamId = teamId;
    }
}
