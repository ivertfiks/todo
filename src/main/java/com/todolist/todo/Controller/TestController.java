package com.todolist.todo.Controller;

import com.todolist.todo.Service.TestService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("test")
public class TestController {

    TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping()
    public void test() {
        testService.test();
    }

    @PostMapping()
    public void postTest() {
        testService.test();
    }

    @DeleteMapping()
    @PutMapping
    public void deleteTest() {
        testService.test();
    }

}