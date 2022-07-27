package com.example.test_project.entity;

import com.example.test_project.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter @Setter
@Table(name = "board_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String boardTitle;

    @Column
    private String boardWriter;

    @Column
    private String boardContents;

    public static BoardEntity save(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        return boardEntity;
    }
}