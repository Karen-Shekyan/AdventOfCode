import java.util.*;
import java.io.*;

public class P1 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    int curr = sc.nextInt();
    while (sc.hasNextInt()) {
      int x = sc.nextInt();
      if (x > curr) {
        ans++;
      }
      curr = x;
    }
    System.out.println(ans);
  }
}
