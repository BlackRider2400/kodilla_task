package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttachmentsByTypeDto {
    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;
}
