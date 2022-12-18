package SKInternship.board.service;

import SKInternship.board.Repository.BoardMapper;
import SKInternship.board.controller.dto.BoardInsertRequestDto;
import SKInternship.board.controller.dto.BoardUpdateRequestDto;
import SKInternship.board.controller.dto.SearchDto;
import SKInternship.board.domain.Board;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardMapper boardMapper;

  /**
   * 게시물 등록
   */
  @Transactional
  public void insertBoard(BoardInsertRequestDto requestDto) {
    Board board = new Board(requestDto);
    boardMapper.save(board);
  }

  /**
   * 게시판 목록 조회
   * @return 게시판 목록
   */
  public Page<Board> findAll(SearchDto searchDto, int pageNum) {
    PageHelper.startPage(pageNum, 10);
    return boardMapper.findAll(searchDto);
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
  public void updateBoard(BoardUpdateRequestDto requestDto) {
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
