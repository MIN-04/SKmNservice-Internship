package SKInternship.board.controller;

import SKInternship.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/members/member")
  public String login() {
    return null;
  }



  // TODO : 로그아웃

  // TODO : 회원 가입
}
