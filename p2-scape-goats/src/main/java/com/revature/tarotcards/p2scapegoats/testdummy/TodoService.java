package com.revature.tarotcards.p2scapegoats.testdummy;

import java.util.List;

// External Service - Lets say this comes from WunderList
// Create TodoServiceStub
// Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {

    public List<String> retrieveTodos(String user);

    void deleteTodo(String todo);

}
