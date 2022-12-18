package SKInternship.board.controller.dto;

import SKInternship.board.common.Pagination;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponseDto<T> {

  private List<T> list = new ArrayList<>();
  private Pagination pagination;

  public PagingResponseDto(List<T> list, Pagination pagination) {
    this.list = list;
    this.pagination = pagination;
  }

}