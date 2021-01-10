package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloConfigTest {
    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void shouldReturnValidValues(){
        assertEquals(trelloConfig.getTrelloApiEndpoint(), "https://api.trello.com/1");
        assertEquals(trelloConfig.getTrelloAppKey(), "dbe8a9e808fffc9c2ba14487d8f66c73");
        assertEquals(trelloConfig.getTrelloToken(), "01fd5928217a83a60147d67c2bb1406356f1c0eb35060640deeca72b22c75d5d");
        assertEquals(trelloConfig.getTrelloUser(), "chris42318403");
    }
}