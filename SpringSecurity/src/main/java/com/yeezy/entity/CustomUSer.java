package com.yeezy.entity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CustomUSer extends User {

    private Member member;

    public CustomUSer(Member member) {
        super(member.getUsername(), member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
        this.member = member;
    }
}
