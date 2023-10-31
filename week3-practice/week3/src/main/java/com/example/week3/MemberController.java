package com.example.week3;

import com.example.week3.entity.Member;
import com.example.week3.entity.Tutee;
import com.example.week3.entity.Tutor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user-v1")
public class MemberController {
    private final List<Member> tempDatabase = new ArrayList<>();
    private final Random random = new Random();

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto) {
        String username = signupDto.username;
        String usertype = signupDto.usertype;
        int userId = random.nextInt();

        if(usertype.equals("TUTOR")) {
            Tutor tutor = new Tutor(userId, username, "코딩");
            tempDatabase.add(tutor);
        } else if (usertype.equals("TUTEE")) {
            Tutee tutee = new Tutee(userId, username, "고려대학교");
            tempDatabase.add(tutee);
        } else {
            throw new RuntimeException("wrong type!");
        }
    }

    @GetMapping("/findAll")
    public List<Member> findAll() {
        return tempDatabase;
    }

    @GetMapping("/{userId}")
    public Member findByUserId(@PathVariable int userId) {
        for(Member member : tempDatabase) {
            if (member.userId == userId) {
                return member;
            }
        }

        throw new MemberException.UserNotFoundException();
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleRuntimeException(RuntimeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MemberException.UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(MemberException.UserNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
