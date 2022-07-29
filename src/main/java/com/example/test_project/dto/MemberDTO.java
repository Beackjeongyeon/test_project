package com.example.test_project.dto;

import com.example.test_project.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public MemberDTO(String memberEmail, String memberPassword, String memberName) {
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
    }

    public static MemberDTO toFind(MemberEntity save) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(save.getId());
        memberDTO.setMemberEmail(save.getMemberEmail());
        memberDTO.setMemberPassword(save.getMemberPassword());
        memberDTO.setMemberName(save.getMemberName());
        return memberDTO;
    }
}
