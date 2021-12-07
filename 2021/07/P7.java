import java.util.*;
import java.io.*;

public class P7 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);
    String scan = "";
    while(sc.hasNext()) {
      scan += sc.next();
    }

    String[] data = scan.split(",");

    int ans = 100000000;
    int sum = 0;
    for (int i = 0; i < 2000; i++) {
      for (int j = 0; j < data.length; j++) {
        sum += Math.abs(Integer.parseInt(data[j]) - i);
      }
      if (sum < ans) {
        ans = sum;
      }
      sum = 0;
    }

    System.out.println(ans);
  }
}
