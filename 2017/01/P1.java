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

    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      String n = "";
      if (i == s.length()-1) {
        if (s.charAt(i) == s.charAt(0)) {
          n += s.charAt(i);
        }
      }
      else {
        if (s.charAt(i) == s.charAt(i+1)) {
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
