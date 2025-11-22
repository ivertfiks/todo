package com.todolist.todo;

import com.todolist.todo.Service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodoApplicationTests {

	TestService testService;

	@Test
	void testService_returnsOK() {
		testService = new TestService();
		String actual = testService.test();
		assertEquals("OK", actual);
	}

}
