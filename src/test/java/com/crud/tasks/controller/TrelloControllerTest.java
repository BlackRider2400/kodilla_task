package com.crud.tasks.controller;

import com.crud.tasks.domain.BadgesDto;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloControllerTest {
    @InjectMocks
    private TrelloController trelloController;

    @Mock
    private TrelloFacade trelloFacade;

    @Test
    void testGetTrelloBoards(){
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "test", new ArrayList<>()));
        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> resultList = trelloController.getTrelloBoards();

        //Then
        assertEquals(trelloBoardDtos.size(), resultList.size());
    }

    @Test
    void testCreateTrelloCardDto(){
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test", "testing", "top", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test", new BadgesDto());
        when(trelloFacade.createCard(cardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto resultCardDto = trelloController.createdTrelloCard(cardDto);

        //Then
        assertEquals(createdTrelloCardDto.getName(), resultCardDto.getName());
        assertEquals(createdTrelloCardDto.getId(), resultCardDto.getId());
    }
}