package app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
  @Test public void testReturnsItemAndPrice() {
    App app = new App();
    String result = app.getPriceLabel("Coffee Machine", 15.99);
    assertEquals("Should print item with price", "The price for item: Coffee Machine is 15.99", result);
  }
}
