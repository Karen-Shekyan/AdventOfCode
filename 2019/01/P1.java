import java.util.*;
import java.io.*;

public class P1 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    while (sc.hasNext()) {
      ans += Integer.parseInt(sc.next())/3-2;
    }

    System.out.println(ans);
  }
}
