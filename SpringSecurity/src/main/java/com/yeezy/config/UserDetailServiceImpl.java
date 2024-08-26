package com.yeezy.config;

import com.yeezy.entity.CustomUSer;
import com.yeezy.entity.Member;
import com.yeezy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> member = memberRepository.findByUsername(username);

        if (member.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new CustomUSer(member.get());
    }
}
