package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadgesDto {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByTypeDto attachments;
}
