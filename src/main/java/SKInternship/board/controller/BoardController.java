package SKInternship.board.controller;

import SKInternship.board.controller.dto.InsertBoardRequestDto;
import SKInternship.board.controller.dto.UpdateBoardRequestDto;
import SKInternship.board.domain.Board;
import SKInternship.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

  private final BoardService boardService;

  /**
   * 게시판 목록 조회
   * @param model
   * @return 게시판 목록
   */
  @GetMapping("/openBoardList.do")
  public String openBoardList(Model model) {
    log.info("게시판 목록 조회");
    List<Board> boardList = boardService.findAll();
    model.addAttribute("boardList", boardList);
    return "board/boardList";
  }

  /**
   * 게시물 작성 페이지
   * @return 게시물 작성 페이지
   */
  @GetMapping("/writeBoard.do")
  public String openBoardWrite() {
    log.info("게시물 작성 페이지");
    return "board/boardWrite";
  }

  /**
   * 게시물 저장
   * @param requestDto
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/insertBoard.do")
  public String insertBoard(InsertBoardRequestDto requestDto) {
    log.info("게시물 저장");
    boardService.insertBoard(requestDto);
    return "redirect:/board/openBoardList.do";
  }

  /**
   * 게시물 상세 조회
   * @param id
   * @param model
   * @return 게시물 상세 조회 페이지
   */
  @GetMapping("/viewBoard.do")
  public String viewBoard(@RequestParam Long id, Model model) {
    log.info("게시물 상세 조회");
    Board board = boardService.findById(id);
    model.addAttribute("board", board);
    return "/board/boardDetail";
  }

  /**
   * 게시물 수정 페이지
   * @param id
   * @param model
   * @return 게시물 수정 페이지
   */
  @GetMapping("/viewUpdateBoard.do")
  public String updateBoard(@RequestParam Long id, Model model) {
    log.info("게시물 수정 페이지");
    Board board = boardService.findById(id);
    model.addAttribute("board", board);
    return "board/boardWrite";
  }

  /**
   * 게시물 수정
   * @param requestDto
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/updateBoard.do")
  public String updateBoard(UpdateBoardRequestDto requestDto) {
    log.info("게시물 수정");
    boardService.updateBoard(requestDto);
    return "redirect:/board/openBoardList.do";
  }

  /**
   * 게시물 삭제
   * @param id
   * @return 게시판 목록 페이지로 리디렉션
   */
  @PostMapping("/deleteBoard.do")
  public String deleteBoard(@RequestParam Long id) {
    log.info("게시물 삭제");
    boardService.deleteBoard(id);
    return "redirect:/board/openBoardList.do";
  }

}
