package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUsername;

    @Autowired
    RestTemplate restTemplate;

    private URI createUrl() {
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/kodillauser/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();
        return url;
    }

    public List<TrelloBoardDto> getTrelloBoards() {
        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(createUrl(), TrelloBoardDto[].class);

        Optional<TrelloBoardDto[]> optBoard = Optional.ofNullable(boardsResponse);

        List<TrelloBoardDto> trelloBoardsNotNull = new ArrayList<>();
        optBoard.ifPresent(response -> Arrays.asList(response));
        return trelloBoardsNotNull;
    }
}