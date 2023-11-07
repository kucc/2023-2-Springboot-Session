package com.example.week5;

import com.example.week5.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveUser(String username, int teamId) {
        jdbcTemplate.update("insert into member(name, teamId) values (?, ?)", username, teamId);
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", new MemberRowMapper());
    }

    public Member findUserById(int userId) {
        List<Member> query = jdbcTemplate.query("select * from MEMBER where memberId = ?", new MemberRowMapper(), userId);
        return query.get(0);
    }

    public List<Member> findByTeamId(int teamId) {
        List<Member> query = jdbcTemplate.query("select * from member where teamId = ?", new MemberRowMapper(), teamId);
        return query;
    }

    public class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(Integer.parseInt(rs.getString("memberId")), rs.getString("name"), Integer.parseInt(rs.getString("teamId")));
        }
    }
}
