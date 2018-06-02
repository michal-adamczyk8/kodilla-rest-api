package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    SimpleEmailService emailService;

    @Mock
    AdminConfig adminConfig;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "trello list 1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "trello list 1", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "trello list 1", true);
        TrelloListDto trelloListDto4 = new TrelloListDto("4", "trello list 1", false);
        List<TrelloListDto> trelloListDtoList1 = Arrays.asList(trelloListDto1, trelloListDto2);
        List<TrelloListDto> trelloListDtoList2 = Arrays.asList(trelloListDto3, trelloListDto4);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "trello board 1", trelloListDtoList1);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("2", "trello board 2", trelloListDtoList2);

        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(trelloBoardDto, trelloBoardDto1);
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtoList);

        //When
        List<TrelloBoardDto> retrievedList = trelloService.fetchTrelloBoards();
        String id1 = retrievedList.get(0).getId();
        String id2 =retrievedList.get(1).getId();

        //Then
        Assert.assertEquals(2, retrievedList.size());
        Assert.assertEquals("1", id1);
        Assert.assertEquals("2", id2);
    }

    @Test
    public void shouldCreateTrelloCard() {
        //Given
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "something something", "http://test.com");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test card", "testing", "123", "3");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto retrievedCreatedTrelloCardDto = trelloService.createdTrelloCard(trelloCardDto);
        String id = retrievedCreatedTrelloCardDto.getId();
        String name = retrievedCreatedTrelloCardDto.getName();
        String url = retrievedCreatedTrelloCardDto.getShortUrl();

        //Then
        Assert.assertEquals(id, "1");
        Assert.assertEquals("something something", name);
        Assert.assertEquals("http://test.com", url);
    }

}
