import java.util.*;
import java.io.*;

public class P1 {
  
  public static void main (String[] args) throws IOException{

    File f = new File(args[0]);
    Scanner input = new Scanner(f);

    String s = input.next();
    int floor = 0;
    int base = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        floor++;
      }
      else {
        floor--;
      }
      if (base == 0 && floor == -1) {
        base = i+1;
      }
    }

    System.out.println(floor);
    System.out.println(base);
  }
}
