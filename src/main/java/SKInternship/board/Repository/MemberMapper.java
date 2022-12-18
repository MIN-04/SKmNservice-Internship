package SKInternship.board.Repository;

import SKInternship.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
  Optional<Member> findById(String memberId);
  void joinMember(Member member);
}
