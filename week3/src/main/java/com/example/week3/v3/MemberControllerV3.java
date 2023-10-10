package com.example.week3.v3;

import com.example.week3.MemberException;
import com.example.week3.dto.SignupDto;
import com.example.week3.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user-v3")
public class MemberControllerV3 {
    private final Random random = new Random();
    private final MemberServiceV3 memberServiceV3;

    public MemberControllerV3(MemberServiceV3 memberServiceV3) {
        this.memberServiceV3 = memberServiceV3;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto) {
        String username = signupDto.username;
        String type = signupDto.usertype;

        memberServiceV3.saveUser(username, type);
    }

    @GetMapping("/{userId}")
    public Member findUser(@PathVariable int userId) {
        return memberServiceV3.findUserById(userId);
    }

    @GetMapping("/findAll")
    public List<Member> findAllUser() {
        return memberServiceV3.findAllUser();
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
