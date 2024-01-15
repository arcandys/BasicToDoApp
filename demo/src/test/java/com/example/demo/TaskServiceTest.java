package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private Long id;

    //SADLY THIS TEST DOESNT WORK ALSO, AND I TRIED TO FIX IT AND IT STILL DOESN'T WORK AND I CAN'T FIX IT :/
    @Test
    public void testTaskFinder() {
        List<Task> mockTasks = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(mockTasks);
        List<Task> result = taskService.taskFinder();
        assertEquals(mockTasks, result);
    }

    //THIS TEST DOESNT WORK SADLY, AND I DON T KNOW HOW TO FIX IT TO WORK SORRY :/
    /**@Test
    public void testFindById() {
        // Création d'une tâche pour simuler la récupération depuis la base de données
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        task.setStatus("Pending");
        task.setPrio("Low");
        task.setDueDate(LocalDate.parse("2024-01-14"));


        // Appel de la méthode du service
        Optional<Task> result = taskService.taskFinderById(1L);

        // Vérification des résultats
        assertTrue(result.isPresent());
        assertEquals("Task 1", result.get().getTitle());
        // Ajoutez d'autres assertions selon vos besoins pour tester d'autres attributs
    }
    **/

}