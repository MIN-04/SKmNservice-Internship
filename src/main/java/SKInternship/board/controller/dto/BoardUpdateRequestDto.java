package SKInternship.board.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateRequestDto {
  private Long id;             // PK
  private String title;        // 제목
  private String content;      // 내용
}
