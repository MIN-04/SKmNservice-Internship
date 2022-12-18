package SKInternship.board.controller;

import SKInternship.board.controller.dto.MemberDto;
import SKInternship.board.controller.dto.ResponseDto;
import SKInternship.board.domain.Member;
import SKInternship.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberService memberService;

  // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
  private String showMessageAndRedirect(ResponseDto responseDto, Model model) {
    model.addAttribute("params", responseDto);
    return "common/responseRedirect";
  }

  @GetMapping("/loginPage.do")
  public String loginPage() {
    return "member/loginPage";
  }

  @PostMapping("/login.do")
  public String login(@ModelAttribute MemberDto memberDto, HttpServletRequest request, Model model) {

    Member loginMember = memberService.findById(memberDto.getLoginId(), memberDto.getLoginPw());
    ResponseDto responseDto;
    if (loginMember == null) {
      responseDto = new ResponseDto(
          "로그인에 실패했습니다.", "/board/openBoardList.do", RequestMethod.GET, null);
    } else {
      responseDto = new ResponseDto(
          "환영합니다.", "/board/openBoardList.do", RequestMethod.GET, null);
      HttpSession session = request.getSession();
      session.setAttribute("loginMember", memberDto);
    }
    return showMessageAndRedirect(responseDto, model);
  }

  @PostMapping(value = "/logout.do")
  public String logout(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession();
    session.invalidate();
    ResponseDto responseDto = new ResponseDto(
        "로그아웃 되었습니다.", "/board/openBoardList.do", RequestMethod.GET, null);
    return showMessageAndRedirect(responseDto, model);
  }
}
