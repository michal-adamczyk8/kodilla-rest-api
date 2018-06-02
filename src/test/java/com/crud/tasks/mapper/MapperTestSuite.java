package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MapperTestSuite {
    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1l, "test task", "test content");

        //When
        Task task  = taskMapper.mapToTask(taskDto);

        //Then
        Assert.assertEquals(Task.class, task.getClass());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1l, "test task", "test content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Given
        Assert.assertEquals(Task.class, task.getClass());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1l, "test task 1", "test content");
        Task task2 = new Task(2l, "test task 2", "test content");
        Task task3 = new Task(3l, "test task 3", "test content");
        List<Task> taskList = Arrays.asList(task1, task2, task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(TaskDto.class, taskDtoList.get(0).getClass());
    }
}
