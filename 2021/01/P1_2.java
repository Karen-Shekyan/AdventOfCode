import java.util.*;
import java.io.*;

public class P1_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNext()) {
      s += sc.next() + " ";
    }
    int ans = 0;
    String[] data = s.split(" ");
    int curr = Integer.parseInt(data[0]) + Integer.parseInt(data[1]) + Integer.parseInt(data[2]);

    for (int i = 1; i < data.length-2; i++) {
      int x = Integer.parseInt(data[i]);
      int y = Integer.parseInt(data[i+1]);
      int z = Integer.parseInt(data[i+2]);
      if (x + y + z > curr) {
        ans++;
      }
      curr = x + y + z;
    }

    System.out.println(ans);
  }
}
