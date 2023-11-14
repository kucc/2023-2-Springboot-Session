package com.example.week6;

import com.example.week6.entity.Member;
import com.example.week6.entity.Team;
import com.example.week6.exception.BusinessException;
import com.example.week6.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberJpaRepository memberRepository;
    private final TeamJpaRepository teamRepository;

    public MemberService(MemberJpaRepository memberRepository, TeamJpaRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public void saveUser(String username, int teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new BusinessException(ErrorCode.TEAM_NOT_FOUND));

        Member member = new Member(username, team);
        memberRepository.save(member);
    }

    public Member findUserById(int userId) {
        return memberRepository.findById(userId).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }

    public List<Member> findByTeamId(int teamId) {
        return memberRepository.findByTeam_teamId(teamId);
    }
}
