package SKInternship.board.service;

import SKInternship.board.controller.dto.BoardInsertRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {

  @Autowired
  BoardService boardService;

  @Test
  void save() {
    BoardInsertRequestDto requestDto = new BoardInsertRequestDto();
    requestDto.setTitle("1번 게시글 제목");
    requestDto.setContent("1번 게시글 내용");
    requestDto.setWriter("테스터");
    boardService.insertBoard(requestDto);
  }

}