package SKInternship.board.domain;

import SKInternship.board.controller.dto.InsertBoardRequestDto;
import SKInternship.board.controller.dto.UpdateBoardRequestDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  private Long id; // PK
  private String title; // 제목
  private String content; // 내용
  private String writer; // 작성자
  private int viewCnt; // 조회수
  private LocalDateTime createdAt; // 생성일

  public Board(InsertBoardRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.writer = requestDto.getWriter();
  }

  public Board(UpdateBoardRequestDto requestDto) {
    this.id = requestDto.getId();
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
  }

}
