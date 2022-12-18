package SKInternship.board.service;

import SKInternship.board.Repository.BoardMapper;
import SKInternship.board.controller.dto.InsertBoardRequestDto;
import SKInternship.board.controller.dto.UpdateBoardRequestDto;
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
   * 게시물 등록
   */
  @Transactional
  public void insertBoard(InsertBoardRequestDto requestDto) {
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
   * 게시물 상세 조회
   * @return 게시물 상세
   */
  public Board findById(Long id) {
    return boardMapper.findById(id);
  }

  /**
   * 게시물 수정
   * @param requestDto
   */
  public void updateBoard(UpdateBoardRequestDto requestDto) {
    Board board = new Board(requestDto);
    boardMapper.update(board);
  }

  /**
   * 게시물 삭제
   * @param id
   */
  public void deleteBoard(Long id) {
    boardMapper.deleteById(id);
  }

}
