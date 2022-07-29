package com.example.test_project.service;

import com.example.test_project.dto.MemberDTO;
import com.example.test_project.entity.MemberEntity;
import com.example.test_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.save(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            MemberEntity save = optionalMemberEntity.get();
            return MemberDTO.toFind(save);
        }else{
            return null;
        }
    }
}
