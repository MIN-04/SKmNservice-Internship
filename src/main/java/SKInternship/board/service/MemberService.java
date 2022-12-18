package SKInternship.board.service;

import SKInternship.board.Repository.MemberMapper;
import SKInternship.board.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberMapper memberMapper;

  public Member findById(String loginId, String loginPw) {
    Optional<Member> member = memberMapper.findById(loginId);

    if (member.isPresent()) {
      if (loginPw.equals(member.get().getMemberPw()))
        return member.get();
    }
    return null;
  }

}
