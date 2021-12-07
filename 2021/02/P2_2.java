import java.util.*;
import java.io.*;

public class P2_2 {
  public static void main(String[] args) throws IOException{
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int h = 0;
    int d = 0;
    int aim = 0;

    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.contains("forward")) {
        h += Integer.parseInt(s.substring(s.indexOf(" ") +1));
        d += aim * Integer.parseInt(s.substring(s.indexOf(" ") +1));
      }
      if (s.contains("down")) {
        aim += Integer.parseInt(s.substring(s.indexOf(" ") +1));
      }
      if (s.contains("up")) {
        aim -= Integer.parseInt(s.substring(s.indexOf(" ") +1));
      }
    }

    System.out.println(h*d);
  }
}
