package SKInternship.board.Repository;

import SKInternship.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
  Member findById(String memberId);
  void joinMember(Member member);
}
