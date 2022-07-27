package com.example.test_project.dto;

import com.example.test_project.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;

    public BoardDTO(String boardTitle, String boardWriter, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
    }

    public static BoardDTO toFind(BoardEntity save) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(save.getId());
        boardDTO.setBoardTitle(save.getBoardTitle());
        boardDTO.setBoardWriter(save.getBoardWriter());
        boardDTO.setBoardContents(save.getBoardContents());
        return boardDTO;
    }
}