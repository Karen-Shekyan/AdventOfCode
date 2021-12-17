import java.util.*;
import java.io.*;

public class P17 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNext()) {
      String s = sc.next();
      if (s.contains("x") || s.contains("y")) {
        data1.add(s);
      }
    }
    //System.out.println(data1);

    String x = data1.get(0);
    int x1 = Integer.parseInt(x.substring(x.indexOf("=")+1, x.indexOf(".")));
    int x2 = Integer.parseInt(x.substring(x.lastIndexOf(".")+1, x.indexOf(",")));
    // System.out.println(x1 + " " + x2);

    String y = data1.get(1);
    int y1 = Integer.parseInt(y.substring(y.indexOf("=")+1, y.indexOf(".")));
    int y2 = Integer.parseInt(y.substring(y.lastIndexOf(".")+1));
    // System.out.println(y1 + " " + y2);

    int ans = 0;
    for (int v = 1; v < 20000; v++) {
      int temp = v;
      int h = 0;
      int maxH = 0;
      boolean inRange = false;
      while (h > y1) {
        // System.out.println(h);
        // System.out.println(v);
        h += v;
        v--;
        if (h > maxH) {
          maxH = h;
        }
        if (h <= y2 && h >= y1) {
          //System.out.println("hi");
          inRange = true;
        }
      }
      //System.out.println("hi");
      if (inRange && maxH > ans) {
        ans = maxH;
        System.out.println(temp);
      }
      v = temp;
      //System.out.println(ans);
    }

    System.out.println(ans);
  }
}
