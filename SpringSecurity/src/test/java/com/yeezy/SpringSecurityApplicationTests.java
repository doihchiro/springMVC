package com.yeezy;

import com.yeezy.entity.Member;
import com.yeezy.entity.Role;
import com.yeezy.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	PasswordEncoder encoder;

	@Test
	void createMember() {

		Member member = new Member();
		member.setUsername("coke");
		member.setPassword(encoder.encode("coke"));
		member.setName("이광수");
		member.setRole(Role.MEMBER);
		member.setEnabled(true);
		memberRepository.save(member);

	}

}
