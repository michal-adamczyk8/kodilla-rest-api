package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {
    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    public void shouldGetAllTasks() {
        //Given
        Task task1 = new Task(1l, "test task 1", "test content");
        Task task2 = new Task(2l, "test task 2", "test content");
        Task task3 = new Task(3l, "test task 3", "test content");
        List<Task> taskList = Arrays.asList(task1, task2, task3);

        when(taskRepository.findAll()).thenReturn(taskList);

        //When
        List<Task> taskList1 =  dbService.getAllTasks();

        //Then
        Assert.assertEquals(3, taskList1.size());
    }

    @Test
    public void shouldFindOneTask() {
        //Given
        Task task1 = new Task(1l, "test task 1", "test content");
        Task task2 = new Task(2l, "test task 2", "test content");
        Task task3 = new Task(3l, "test task 3", "test content");
        List<Task> taskList = Arrays.asList(task1, task2, task3);

        when(taskRepository.findById(1l)).thenReturn(java.util.Optional.ofNullable(task1));

        //When
        Optional<Task> task = dbService.getTask(1l);

        //Then
        Assert.assertEquals("test task 1", task.get().getTitle());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1l, "test task", "test content");

        when(taskRepository.save(task)).thenReturn(task);
        //When
        Task testingTask = dbService.saveTask(task);

        //Then
        Assert.assertEquals(task, testingTask);
    }
}
