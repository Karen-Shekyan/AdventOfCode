import java.util.*;
import java.io.*;

public class P2 {

  public static boolean isGood (String pass, String letter, String[] bounds) {
    int rep = 0;
    for (int i = 0; i < pass.length(); i++) {
      if (pass.charAt(i) == letter.charAt(0)) {
        rep++;
      }
    }
    return (rep >= Integer.parseInt(bounds[0]) && rep <= Integer.parseInt(bounds[1]));
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    while (sc.hasNextLine()) {
      String s = sc.next();
      String[] bounds = s.split("-");
      String letter = sc.next().substring(0,1);
      String pass = sc.next();
      if (isGood(pass, letter, bounds)) {
        ans++;
      }
    }

    System.out.println(ans);
  }
}
