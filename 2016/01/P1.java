import java.util.*;
import java.io.*;

public class P1 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNext()) {
      s += sc.next();
    }

    String[] data = s.split(",");

    int x = 0;
    int y = 0;
    int d = 0; //0 for up, 1 for right, 2 for down, 3 for left
    for (int i = 0; i < data.length; i++) {
      //turn
      if (data[i].contains("R")) {
        d++;
        if (d == 4) {
          d = 0;
        }
      }
      else {
        d--;
        if (d == -1) {
          d = 3;
        }
      }
      //move
      if (d == 0) {
        y += Integer.parseInt(data[i].substring(1));
      }
      if (d == 1) {
        x += Integer.parseInt(data[i].substring(1));
      }
      if (d == 2) {
        y -= Integer.parseInt(data[i].substring(1));
      }
      if (d == 3) {
        x -= Integer.parseInt(data[i].substring(1));
      }
      //System.out.println(x + " " + y);
    }

    System.out.println(Math.abs(x)+Math.abs(y));
  }
}
