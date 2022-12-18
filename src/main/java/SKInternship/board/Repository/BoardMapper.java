package SKInternship.board.Repository;

import SKInternship.board.controller.dto.BoardSearchRequestDto;
import SKInternship.board.controller.dto.SearchDto;
import SKInternship.board.domain.Board;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

  /**
   * 게시글 저장
   * @param board - 게시글 정보
   */
  Long save(Board board);

  /**
   * 게시글 상세정보 조회
   * @param id - PK
   * @return 게시글 상세정보
   */
  Board findById(Long id);

  /**
   * 게시글 수정
   * @param board - 게시글 정보
   */
  void update(Board board);

  /**
   * 게시글 삭제
   * @param id - PK
   */
  void deleteById(Long id);

  /**
   * 게시글 리스트 조회
   * @return 게시글 리스트
   */
  Page<Board> findAll(SearchDto searchDto);
}
