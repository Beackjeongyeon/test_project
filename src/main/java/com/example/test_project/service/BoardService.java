package com.example.test_project.service;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.entity.BoardEntity;
import com.example.test_project.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {
    final private BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.save(boardDTO);
        return boardRepository.save(boardEntity).getId();
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if(optionalBoardEntity.isPresent()) {
            BoardEntity save = optionalBoardEntity.get();
//            String saveId = boardEntity.getBoardWriter();
            return BoardDTO.toFind(save);
        }else{
            return null;
        }
    }
}