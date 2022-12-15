package SKInternship.board.domain;

import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  private Long id;

  @NonNull
  private String memberId;
  @NonNull
  private String memberPw;
  @NonNull
  private String memberName;

}
