import java.util.*;
import java.io.*;

public class P12 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String num = "";
    int ans = 0;
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
          num += s.charAt(i);
        }
        else if (!num.equals("")) {
          //System.out.println(num);
          ans += Integer.parseInt(num);
          num = "";
        }
      }
    }

    System.out.println(ans);
  }
}
