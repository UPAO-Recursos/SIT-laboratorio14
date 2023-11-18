package com.example.demojpalab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.example.demojpalab.tasks.Task;
import com.example.demojpalab.tasks.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemojpalabApplicationTests {
	@Mock
	private TaskRepository taskRepository;

	// Test
	@Test
	void contextLoads() {
		return;
	}

	// JUnit
	@Test
	void testJUnit() {
		// Arrange
		String result = "Resultado";

		// Act
		String resultToCompare = "Resultad";

		// Assert
		assertEquals(result, resultToCompare);
	}

	// Mockito
	@Test
	void testMockito() {
		// Arrange
		Long id = 1L;
		Task result = new Task();

		when(taskRepository.findById(id)).thenReturn(Optional.of(result)); // Use Optional.of(result)

		// Act
		Optional<Task> respOptional = taskRepository.findById(id);

		// Assert
		assertTrue(respOptional.isPresent());
		Task resp = respOptional.get();
		assertNotNull(resp);
		assertInstanceOf(Task.class, resp);
	}

	// Mockito
	@Test
	void TaskFindByIdIsNotNullAndTaskInstance() {
		// Arrange
		Long id = 2L;
		Task result = new Task();

		when(taskRepository.findById(id)).thenReturn(Optional.of(result)); // Use Optional.of(result)

		// Act
		Optional<Task> respOptional = taskRepository.findById(1L);

		// Assert
		assertTrue(respOptional.isPresent());
		Task resp = respOptional.get();
		assertNotNull(resp);
		assertInstanceOf(Task.class, resp);
	}

}
