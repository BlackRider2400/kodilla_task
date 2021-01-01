package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/v1/trello")
@RestController
public class TrelloController {

    private final TrelloService trelloService;

    @GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards(){
        return trelloService.fetchTrelloBoards();
    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloService.createTrelloCard(trelloCardDto);
    }
}
