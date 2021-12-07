import java.util.*;
import java.io.*;

public class P2_2 {

  public static boolean isGood (String pass, String letter, String[] bounds) {
    int p1 = Integer.parseInt(bounds[0]);
    int p2 = Integer.parseInt(bounds[1]);
    System.out.println(p1 + " " + p2);
    boolean a = p1 < pass.length()+1 && pass.charAt(p1-1) == letter.charAt(0);
    boolean b = p2 < pass.length()+1 && pass.charAt(p2-1) == letter.charAt(0);
    System.out.println(a + " " + b);
    return ((a||b) && !(a&&b));
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
        System.out.println(pass);
      }
    }

    System.out.println(ans);
  }
}
