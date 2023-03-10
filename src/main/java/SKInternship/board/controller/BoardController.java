package SKInternship.board.controller;

import SKInternship.board.controller.dto.*;
import SKInternship.board.domain.Board;
import SKInternship.board.service.BoardService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

  private final BoardService boardService;

  // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
  private String showMessageAndRedirect(ResponseDto responseDto, Model model) {
    model.addAttribute("params", responseDto);
    return "common/responseRedirect";
  }

  /**
   * 게시판 목록 조회
   * @param model
   * @return 게시판 목록
   */
  @GetMapping("/openBoardList.do")
  public String openBoardList(@ModelAttribute SearchDto searchDto,
                              @SessionAttribute(name = "loginMember", required = false) MemberDto memberDto,
                              @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) {
    log.info("게시판 목록 조회");
    PageInfo<Board> boardList = new PageInfo<>(boardService.findAll(searchDto, pageNum), 10);
    model.addAttribute("boardList", boardList);
    model.addAttribute("search", searchDto);
    model.addAttribute("memberDto", memberDto);
    return "board/boardList";
  }

  /**
   * 게시물 작성 페이지
   * @return 게시물 작성 페이지
   */
  @GetMapping("/writeBoard.do")
  public String openBoardWrite(@SessionAttribute(name = "loginMember", required = false) MemberDto memberDto, Model model) {
    log.info("게시물 작성 페이지");
    model.addAttribute("memberDto", memberDto);
    return "board/boardWrite";
  }

  /**
   * 게시물 저장
   * @param requestDto
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/insertBoard.do")
  public String insertBoard(BoardInsertRequestDto requestDto, Model model) {
    log.info("게시물 저장");
    boardService.insertBoard(requestDto);
    ResponseDto responseDto = new ResponseDto(
        "게시글 생성이 완료되었습니다.", "/board/openBoardList.do", RequestMethod.GET, null);
    return showMessageAndRedirect(responseDto, model);
  }

  /**
   * 게시물 상세 조회
   * @param id
   * @param model
   * @return 게시물 상세 조회 페이지
   */
  @GetMapping("/viewBoard.do")
  public String viewBoard(@RequestParam Long id,
                          @SessionAttribute(name = "loginMember", required = false) MemberDto memberDto, Model model) {
    log.info("게시물 상세 조회");
    BoardResponseDto responseDto = new BoardResponseDto(boardService.findById(id));
    model.addAttribute("board", responseDto);
    model.addAttribute("memberDto", memberDto);
    return "/board/boardDetail";
  }

  /**
   * 게시물 수정 페이지
   * @param id
   * @param model
   * @return 게시물 수정 페이지
   */
  @GetMapping("/viewUpdateBoard.do")
  public String updateBoard(@RequestParam Long id,
                            @SessionAttribute(name = "loginMember", required = false) MemberDto memberDto,
                            Model model) {
    log.info("게시물 수정 페이지");
    BoardResponseDto responseDto = new BoardResponseDto(boardService.findById(id));
    model.addAttribute("board", responseDto);
    model.addAttribute("memberDto", memberDto);
    return "board/boardWrite";
  }

  /**
   * 게시물 수정
   * @param requestDto
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/updateBoard.do")
  public String updateBoard(BoardUpdateRequestDto requestDto, Model model) {
    log.info("게시물 수정");
    boardService.updateBoard(requestDto);
    ResponseDto responseDto = new ResponseDto(
        "게시글 수정이 완료되었습니다.", "/board/openBoardList.do", RequestMethod.GET, null);
    return showMessageAndRedirect(responseDto, model);
  }

  /**
   * 게시물 삭제
   * @param id
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/deleteBoard.do")
  public String deleteBoard(@RequestParam Long id, Model model) {
    log.info("게시물 삭제");
    boardService.deleteBoard(id);
    ResponseDto responseDto = new ResponseDto(
        "게시글 삭제가 완료되었습니다.", "/board/openBoardList.do", RequestMethod.GET, null);
    return showMessageAndRedirect(responseDto, model);
  }

}
