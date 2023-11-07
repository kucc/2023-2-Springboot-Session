package com.example.week5;

import com.example.week5.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveUser(String username, int teamId) {
        memberRepository.saveUser(username, teamId);
    }

    public Member findUserById(int userId) {
        return memberRepository.findUserById(userId);
    }

    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }

    public List<Member> findByTeamId(int teamId) {
        return memberRepository.findByTeamId(teamId);
    }
}
