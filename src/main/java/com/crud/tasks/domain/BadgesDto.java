package com.crud.tasks.domain;

import com.crud.tasks.domain.AttachmentsByTypeDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesDto {

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByTypeDto attachmentsByType;
}