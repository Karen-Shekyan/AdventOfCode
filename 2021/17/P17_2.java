import java.util.*;
import java.io.*;

public class P17_2 {
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
    for (int vx = 1; vx < 1000; vx++) {
      for (int vy = -300; vy < 500; vy++) {
        //System.out.println(ans + " " + vx + " " + vy);
        int tempx = vx;
        int tempy = vy;
        int h = 0;
        int d = 0;
        //System.out.println("hi");
        while (d <= x2 && h >= y1) {
          //System.out.println("hi");
          d += tempx;
          if (tempx > 0) {
            tempx--;
          }
          //System.out.println("hi");
          h += tempy;
          tempy--;
          //System.out.println(d + " " + h);
          if (d <= x2 && d >= x1 && h >= y1 && h <= y2) {
            ans += 1;
            break;
          }
        }
      }
    }

    System.out.println(ans);
  }
}
