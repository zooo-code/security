package com.security.user.controller;


import lombok.Getter;

@Getter
public class MemberDto {

    private final String memberId;
    private final String password;

    public MemberDto(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}
