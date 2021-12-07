import java.util.*;
import java.io.*;

public class P1 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.contains("+")) {
        ans += Integer.parseInt(s.substring(1));
      }
      else {
        ans-= Integer.parseInt(s.substring(1));
      }
    }

    System.out.println(ans);
  }
}
