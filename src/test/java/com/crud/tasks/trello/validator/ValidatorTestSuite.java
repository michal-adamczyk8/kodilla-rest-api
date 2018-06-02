package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTestSuite {

    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    public void shouldValidateTrelloBoard() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "test list 1", true);
        TrelloList trelloList2 = new TrelloList("2", "test list 2", false);
        TrelloList trelloList3 = new TrelloList("3", "test list 3", true);
        TrelloList trelloList4 = new TrelloList("4", "test list 4", false);
        TrelloList trelloList5 = new TrelloList("5", "test list 5", true);
        TrelloList trelloList6 = new TrelloList("6", "test list 6", false);
        List<TrelloList> trelloLists1 = Arrays.asList(trelloList1, trelloList2);
        List<TrelloList> trelloLists2 = Arrays.asList(trelloList3, trelloList4);
        List<TrelloList> trelloLists3 = Arrays.asList(trelloList5, trelloList6);
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test", trelloLists1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "anything", trelloLists2);
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "something", trelloLists3);
        List<TrelloBoard> trelloBoardList = Arrays.asList(trelloBoard1, trelloBoard2, trelloBoard3);

        //When
        List<TrelloBoard> retrievedTrelloBoardList = trelloValidator.validateTrelloBoards(trelloBoardList);

        //Then
        Assert.assertEquals(2, retrievedTrelloBoardList.size());
    }
}
