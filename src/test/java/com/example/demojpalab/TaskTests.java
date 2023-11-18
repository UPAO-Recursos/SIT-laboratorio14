package com.example.demojpalab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demojpalab.tasks.Task;
import com.example.demojpalab.tasks.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskTests {
	@Mock
	private TaskRepository taskRepository;

	@Test
	void testTaskTitleIsValid() {
		// Arrange
		Task task = new Task("Titulo", "Descripcion");

		// Act
		boolean isValid = task.isValid();

		// Assert
		assertEquals(isValid, true);
	}

	@Test
	void testTaskTitleIsNotValid() {
		// Arrange
		Task task = new Task("Titulo123123", "Descripcion");

		// Act
		boolean isValid = task.isValid();

		// Assert
		assertEquals(isValid, false);
	}

	@Test
	void testTaskDescriptionIsNotValid() {
		// Arrange
		Task task = new Task("Titulo", "Descripcion1982731982378912738179823");

		// Act
		boolean isValid = task.isValid();

		// Assert
		assertEquals(isValid, false);
	}

	@Test
	void testTaskDescriptionIsValid() {
		// Arrange
		Task task = new Task("Titulo", "Descripci");

		// Act
		boolean isValid = task.isValid();

		// Assert
		assertEquals(isValid, true);
	}

	@Test
	void TaskDescriptionIsValidAndMoreThan5() {
		// Arrange
		Task task = new Task("Titulo", "Descripcion");

		// Act
		boolean isValid = task.isValid();
		boolean moreThan5 = task.getDescription().length() > 5;

		// Assert
		assertEquals(isValid, true);
		assertTrue(moreThan5);
	}

	@Test
	void TaskDescriptionIsNotValidAndLessThan5() {
		// Arrange
		Task task = new Task("Titulo", "Desc");

		// Act
		boolean isValid = task.isValid();
		boolean moreThan5 = task.getDescription().length() > 5;

		// Assert
		assertEquals(isValid, false);
		assertFalse(moreThan5);
	}
}
