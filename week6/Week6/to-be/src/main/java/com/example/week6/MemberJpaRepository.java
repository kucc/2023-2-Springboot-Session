package com.example.week6;

import com.example.week6.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Integer>{
    List<Member> findByTeam_teamId(int teamId);
}
