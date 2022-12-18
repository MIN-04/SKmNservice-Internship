package SKInternship.board;

import SKInternship.board.Repository.BoardMapper;
import SKInternship.board.controller.dto.BoardInsertRequestDto;
import SKInternship.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	BoardMapper boardMapper;

	@Test
	void save() {
		BoardInsertRequestDto boardInsertRequestDto = new BoardInsertRequestDto();
		boardInsertRequestDto.setTitle("1번 게시글 제목");
		boardInsertRequestDto.setContent("1번 게시글 내용");
		boardInsertRequestDto.setWriter("테스터");

		Board board = new Board(boardInsertRequestDto);

		boardMapper.save(board);
	}

}
