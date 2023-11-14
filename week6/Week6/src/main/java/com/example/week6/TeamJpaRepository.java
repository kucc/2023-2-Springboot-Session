package com.example.week6;

import com.example.week6.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamJpaRepository extends JpaRepository<Team, Integer> {
}
