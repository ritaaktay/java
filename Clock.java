import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Clock {
  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = dateTime.format(dtf);
    System.out.printf("The current time is %s \n", formattedTime);
  }  
}
