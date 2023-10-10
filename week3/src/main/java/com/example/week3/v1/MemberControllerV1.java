package com.example.week3.v1;

import com.example.week3.MemberException;
import com.example.week3.dto.SignupDto;
import com.example.week3.entity.Tutee;
import com.example.week3.entity.Tutor;
import com.example.week3.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user-v1")
public class MemberControllerV1 {
    private final List<Member> tempDatabase = new ArrayList<>();
    private final Random random = new Random();

    @PostMapping("/signup")
    public Member signup(@RequestBody SignupDto signupDto) {
        String username = signupDto.username;
        String type = signupDto.usertype;
        int userId = random.nextInt();

        Member member = null;
        if(type.equals("TUTOR")) {
            Tutor tutor = new Tutor(userId, username, "TUTOR");
            tempDatabase.add(tutor);
            member = tutor;
        } else if (type.equals("TUTEE")) {
            Tutee tutee = new Tutee(userId, username, "TUTEE");
            tempDatabase.add(tutee);
            member = tutee;
        } else {
//            throw new RuntimeException("wrong type!");
            throw new MemberException.WrongUserTypeException();
        }
        return member;
    }

    @GetMapping("/{userId}")
    public Member findUser(@PathVariable int userId) {
        for(Member member : tempDatabase) {
            if(member.userId == userId) {
                return member;
            }
        }
//        throw new RuntimeException("존재하지 않는 유저입니다.");
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

    @ExceptionHandler(MemberException.WrongUserTypeException.class)
    public ProblemDetail handleWrongUserTypeException(MemberException.WrongUserTypeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
