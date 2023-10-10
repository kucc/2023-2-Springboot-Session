package com.example.week3.v3;

import com.example.week3.entity.Tutee;
import com.example.week3.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveTutor(String username) {
        String sql = "INSERT INTO MEMBER (username, usertype) VALUES (?, ?);";

        jdbcTemplate.update(sql,username, "TUTOR");
    }

    public void saveTutee(String username) {
        String sql = "INSERT INTO MEMBER (username, usertype) VALUES (?, ?);";
        jdbcTemplate.update(sql,username, "TUTEE");
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("select * from member", new MemberRowMapper());
    }

    public Member findUserById(int userId) {
        List<Member> query = jdbcTemplate.query("select * from MEMBER where userId = ?", new MemberRowMapper(), userId);
        return query.get(0);
    }

    public class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(Integer.parseInt(rs.getString("userId")), rs.getString("username"));
        }
    }
}
