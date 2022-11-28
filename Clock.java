import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Clock {
  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = dateTime.format(dtf);
    String redWord = "\u001B[31m" + "time" + "\u001B[37m";
    System.out.printf("The current %s is %s \n", redWord, formattedTime);
  }  
}
