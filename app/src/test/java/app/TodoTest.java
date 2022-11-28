package app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TodoTest {
  @Test public void testHasEmptyTodoList() {
    Todo todo = new Todo();
    ArrayList<String> empty = new ArrayList<String>();
    assertEquals("initializes with empty todo list", empty, todo.getTodos());
  }

  @Test public void testAddsTodosToList() {
    Todo todo = new Todo();
    ArrayList<String> todos = new ArrayList<String>();
    todos.add("Get milk");
    todo.addTodo("Get milk");
    assertEquals("adds todos to list", todos, todo.getTodos());
  }
}
