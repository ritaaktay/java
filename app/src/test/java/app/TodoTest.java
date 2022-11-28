package app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TodoTest {
  @Test 
  public void testStartWithEmptyTodoList() {
    Todo todo = new Todo();
    ArrayList<String> empty = new ArrayList<String>();
    assertTrue("initializes with empty todo list", todo.todos.isEmpty());
  }

  @Test 
  public void testAddsTodosToList() {
    Todo todo = new Todo();
    ArrayList<String> expected = new ArrayList<String>();
    expected.add("Get milk");
    todo.addTodo("Get milk");
    assertEquals("adds todos to list", expected, todo.getTodos());
  }
}
