package com.example.test_project;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.dto.MemberDTO;
import com.example.test_project.service.BoardService;
import com.example.test_project.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class test {
    @Autowired
    private BoardService boardService;
    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("테스트 시나리오")
    public void BoardSaveTest() {
        String testTitle = "testTitle";
        String testWriter = "testWriter";
        String testContents = "testContents";

        Long saveId = boardService.save(new BoardDTO(testTitle, testWriter, testContents));
        BoardDTO boardDTO = boardService.findById(saveId);
        assertThat(testWriter).isEqualTo(boardDTO.getBoardWriter());

    }

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("테스트 시나리오2")
    public void MemberSaveTest() {
        String memberEmail = "memberEmail";
        String memberPassword = "memberPassword";
        String memberName = "memberName";
        Long saveId = memberService.save(new MemberDTO(memberEmail, memberPassword, memberName));
        MemberDTO memberDTO = memberService.findById(saveId);
        assertThat(memberDTO).isNotNull();


    }
}