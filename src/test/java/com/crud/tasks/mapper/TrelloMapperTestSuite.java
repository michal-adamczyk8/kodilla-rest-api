package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {
    @InjectMocks
    TrelloMapper trelloMapper;


    @Test
    public void shouldMapToBoardsDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "list 1", true);
        TrelloList trelloList2 = new TrelloList("2", "list 2", false);
        TrelloList trelloList3 = new TrelloList("3", "list 3", true);
        TrelloList trelloList4 = new TrelloList("4", "list 4", false);
        TrelloList trelloList5 = new TrelloList("5", "list 5", true);
        TrelloList trelloList6 = new TrelloList("6", "list 6", false);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "board 1",
                Arrays.asList(trelloList1, trelloList2, trelloList3));
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "board 2",
                Arrays.asList(trelloList4, trelloList5, trelloList6));

        List<TrelloBoard> trelloBoardList = Arrays.asList(trelloBoard1, trelloBoard2);
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        Assert.assertEquals(TrelloBoardDto.class, trelloBoardDtoList.get(0).getClass());
    }

    @Test
    public void shouldMapToBoard() {
        //Given
        TrelloListDto trelloList1 = new TrelloListDto("1", "list 1", true);
        TrelloListDto trelloList2 = new TrelloListDto("2", "list 2", false);
        TrelloListDto trelloList3 = new TrelloListDto("3", "list 3", true);
        TrelloListDto trelloList4 = new TrelloListDto("4", "list 4", false);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "board 1",
                Arrays.asList(trelloList1, trelloList2));
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("2", "board 2",
                Arrays.asList(trelloList3, trelloList4));

        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(trelloBoardDto, trelloBoardDto1);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(TrelloBoard.class, trelloBoardList.get(0).getClass());
    }

    @Test
    public void shouldMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "list 1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "list 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "list 3", true);
        List<TrelloListDto> trelloListDtos = Arrays.asList(trelloListDto1, trelloListDto2, trelloListDto3);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Given
        Assert.assertEquals(TrelloList.class, trelloLists.get(0).getClass());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "list 1", true);
        TrelloList trelloList2 = new TrelloList("2", "list 2", false);
        TrelloList trelloList3 = new TrelloList("3", "list 3", true);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2, trelloList3);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals(TrelloListDto.class, trelloListDtos.get(0).getClass());
    }

    @Test
    public void shouldMapToCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card 1", "testing card", "123", "2");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Given
        Assert.assertEquals(TrelloCardDto.class, trelloCardDto.getClass());
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card 1", "testong card dto", "121", "4");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(TrelloCard.class, trelloCard.getClass());
    }

}
