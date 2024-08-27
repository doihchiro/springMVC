package com.yeezy.entity;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class CustomUser extends User {

    private Member member;

    public CustomUser(Member member) {
        super(member.getUsername(), member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
        this.member = member;
    }

}
