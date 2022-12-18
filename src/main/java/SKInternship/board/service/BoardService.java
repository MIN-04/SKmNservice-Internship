package SKInternship.board.service;

import SKInternship.board.Repository.BoardMapper;
import SKInternship.board.controller.dto.BoardRequestDto;
import SKInternship.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardMapper boardMapper;

  /**
   * 게시판 등록
   */
  @Transactional
  public void insertBoard(BoardRequestDto requestDto) {
    Board board = new Board(requestDto);
    boardMapper.save(board);
  }

  /**
   * 게시판 목록 조회
   * @return 게시판 목록
   */
  public List<Board> findAll() {
    return boardMapper.findAll();
  }

  /**
   * 게시판 상세 조회
   * @return 게시판 상세
   */
  public Board findById(Long id) {
    return boardMapper.findById(id);
  }

}
