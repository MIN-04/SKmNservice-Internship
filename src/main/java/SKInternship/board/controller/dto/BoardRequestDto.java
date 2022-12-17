package SKInternship.board.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {
  private Long id;
  private String title;        // 제목
  private String content;      // 내용
  private String writer;       // 작성자
  private String viewCnt;      // 조회수
}
