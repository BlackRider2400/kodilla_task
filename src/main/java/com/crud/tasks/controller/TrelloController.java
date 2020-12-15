package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/v1/trello")
@RestController
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public List getTrelloBoards(){

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {
            if (trelloBoardDto.getId() == null || trelloBoardDto.getName() == null || trelloBoardDto.getName().contains("Kodilla")){
                System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            }
        });

        return trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getId() == null || trelloBoardDto.getName() == null || trelloBoardDto.getName().contains("Kodilla"))
                .collect(Collectors.toList());
    }
}
