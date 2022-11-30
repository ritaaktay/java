package app;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class ShoopingListTest {
  @Test
  public void testHasEmptyItemList() {
    ShoppingList sList = new ShoppingList();
    assertTrue(sList.list.size() == 0);
  }

  @Test
  public void testAddsItemToList() {
    ShoppingList sList = new ShoppingList();
    ShoppingItem banana = new ShoppingItem("banana", 1.99);
    sList.addItem(banana);
    assertTrue(sList.list.contains(banana));
  }

  @Test
  public void getsItemsFromList() {
    ShoppingList sList = new ShoppingList();
    ShoppingItem banana = new ShoppingItem("banana", 1.99);
    sList.addItem(banana);
    ArrayList<ShoppingItem> testList = new ArrayList<ShoppingItem>();
    testList.add(banana);
    assertEquals(testList, sList.getItems());
  }
}
