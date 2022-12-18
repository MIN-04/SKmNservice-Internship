package SKInternship.board.service;

import SKInternship.board.Repository.BoardMapper;
import SKInternship.board.common.Pagination;
import SKInternship.board.controller.dto.*;
import SKInternship.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
  public PagingResponseDto<BoardResponseDto> findAll(BoardSearchRequestDto requestDto) {

    int count = boardMapper.count(requestDto);
    if (count < 1) {
      return new PagingResponseDto<>(Collections.emptyList(), null);
    }

    Pagination pagination = new Pagination(count, requestDto);
    requestDto.setPagination(pagination);

    List<Board> list = boardMapper.findAll(requestDto);
    List<BoardResponseDto> responseDtos = new ArrayList<>();
    for (Board board : list) {
      responseDtos.add(new BoardResponseDto(board));
    }
    return new PagingResponseDto<>(responseDtos, pagination);

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
