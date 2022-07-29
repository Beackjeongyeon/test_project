package com.example.test_project.controller;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.dto.MemberDTO;
import com.example.test_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    final private MemberService memberService;

    @GetMapping("/save-form")
    public String saveForm(){
        return "/MemberPages/MemberSave";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        MemberDTO saveId = memberService.findById(id);
        return "redirect:/";
    }
}
