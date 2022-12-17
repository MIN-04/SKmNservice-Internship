package SKInternship.board.controller;

import SKInternship.board.controller.dto.BoardRequestDto;
import SKInternship.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/openBoardList.do")
  public String readList() {
    return "board/boardList";
  }

  @GetMapping("/write")
  public String openBoardWrite() {
    return "board/boardWrite";
  }

  @PostMapping("/new")
  public String insertBoard(BoardRequestDto requestDto) {
    log.info("게시글 저장");
    boardService.insertBoard(requestDto);

    return "redirect:/board/openBoardList.do";
  }

}
