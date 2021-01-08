package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @BeforeEach
    void setUp() {
        System.out.println("Starting test...");
    }

    @Test
    void mapToBoards() {
        //Given
        TrelloBoardDto boardDto1 = new TrelloBoardDto("1", "To-do", new ArrayList<TrelloListDto>());
        TrelloBoardDto boardDto2 = new TrelloBoardDto("2", "Home work", new ArrayList<TrelloListDto>());
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(boardDto1);
        boardDtos.add(boardDto2);

        //When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(boardDtos);

        //Then
        assertEquals(boards.get(1).getId(), boardDto2.getId());
    }

    @Test
    void mapToBoardsDto() {
        //Given
        TrelloBoard board1 = new TrelloBoard("1", "To-do", new ArrayList<TrelloList>());
        TrelloBoard board2 = new TrelloBoard("2", "Home work", new ArrayList<TrelloList>());
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(board1);
        boards.add(board2);

        //When
        List<TrelloBoardDto> boardDtos = trelloMapper.mapToBoardsDto(boards);

        //Then
        assertEquals(boardDtos.get(1).getId(), board2.getId());
    }

    @Test
    void mapToList() {
        //Given
        TrelloListDto listDto1 = new TrelloListDto("1", "To-do", true);
        TrelloListDto listDto2 = new TrelloListDto("2", "Home work", true);
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(listDto1);
        listDtos.add(listDto2);

        //When
        List<TrelloList> lists = trelloMapper.mapToList(listDtos);

        //Then
        assertEquals(lists.get(1).getId(), listDto2.getId());
    }

    @Test
    void mapToListDto() {
        //Given
        TrelloList list1 = new TrelloList("1", "To-do", true);
        TrelloList list2 = new TrelloList("2", "Home work", true);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);

        //When
        List<TrelloListDto> listDtos = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals(listDtos.get(1).getId(), list2.getId());
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("test", "Testing testing attention pls", "top", "1");

        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals(cardDto.getListId(), card.getListId());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test", "Testing testing attention pls", "top", "1");

        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals(cardDto.getListId(), card.getListId());
    }
}