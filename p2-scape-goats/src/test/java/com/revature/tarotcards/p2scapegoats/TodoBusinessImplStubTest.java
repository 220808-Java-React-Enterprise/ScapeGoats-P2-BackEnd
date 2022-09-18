package com.revature.tarotcards.p2scapegoats;

import com.revature.tarotcards.p2scapegoats.testdummy.TodoBusinessImpl;
import com.revature.tarotcards.p2scapegoats.testdummy.TodoService;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {
    @Test
    public void testRetrieveTodosRelatedToSprint_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());

    }

    @Test
    public void testRetrieveTodosRelatedToSprint_usingAStub2() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());

    }
}
