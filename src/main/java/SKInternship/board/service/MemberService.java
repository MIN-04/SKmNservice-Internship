package SKInternship.board.service;

import SKInternship.board.Repository.MemberMapper;
import SKInternship.board.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberMapper memberMapper;

  // TODO : 로그인 (validation 아이디 존재여부)
  public Member findById(String memberId) {
    return memberMapper.findById(memberId);
  }


  // TODO : 로그아웃

  // TODO : 회원 가입

}
