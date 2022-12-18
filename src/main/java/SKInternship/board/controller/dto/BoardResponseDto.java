package SKInternship.board.controller.dto;

import SKInternship.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class BoardResponseDto {

  private Long id; // PK
  private String title; // 제목
  private String content; // 내용
  private String writer; // 작성자
  private int viewCnt; // 조회수
  private String createdAt; // 생성일

  public BoardResponseDto(Board board) {
    this.id = board.getId();
    this.title = board.getTitle();
    this.content = board.getContent();
    this.writer = board.getWriter();
    this.viewCnt = board.getViewCnt();
    this.createdAt = board.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
  }

}
