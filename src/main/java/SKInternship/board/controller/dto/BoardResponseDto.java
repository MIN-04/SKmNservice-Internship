package SKInternship.board.controller.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

  private Long id;                       // PK
  private String title;                  // 제목
  private String content;                // 내용
  private String writer;                 // 작성자
  private int viewCnt;                   // 조회수
  private LocalDateTime createdDate;     // 생성일시

}
