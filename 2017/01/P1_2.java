import java.util.*;
import java.io.*;

public class P1_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNext()) {
      s += sc.next();
    }

    int ans = 0;
    int inc = s.length()/2;
    for (int i = 0; i < s.length(); i++) {
      String n = "";
      int d = inc + i;
      if (d >= s.length()) {
        d -= (s.length());
      }
      if (i == s.length()-1) {
        if (s.charAt(i) == s.charAt(d)) {
          n += s.charAt(i);
        }
      }
      else {
        if (s.charAt(i) == s.charAt(d)) {
          n += s.charAt(i);
        }
      }
      if (!n.equals("")) {
        ans += Integer.parseInt(n);
      }
    }

    System.out.println(ans);
  }
}
