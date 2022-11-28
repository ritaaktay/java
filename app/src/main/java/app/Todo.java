package app;

import java.util.ArrayList;

public class Todo {
  ArrayList<String> todos = new ArrayList<String>();

  public ArrayList<String> getTodos() {
    return todos;
  }

  public void addTodo(String todo) {
    todos.add(todo);
  }
}
