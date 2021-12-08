import java.util.*;
import java.io.*;

public class P1_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    while (sc.hasNext()) {
      int fuel = Integer.parseInt(sc.next())/3-2;
      while (fuel > 0) {
        ans += fuel;
        fuel = fuel/3-2;
      }
    }

    System.out.println(ans);
  }
}
