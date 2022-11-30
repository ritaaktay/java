package app;

import java.util.ArrayList;

public class ShoppingList {
  ArrayList<ShoppingItem> list = new ArrayList<ShoppingItem>();

  public void addItem(ShoppingItem item) {
    list.add(item);
  }

  public ArrayList<ShoppingItem> getItems() {
    return list;
  }
}
