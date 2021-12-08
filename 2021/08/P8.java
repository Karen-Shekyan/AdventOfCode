import java.util.*;
import java.io.*;

public class P8 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }
    String[][][] data = new String[data1.size()][2][];
    for (int i = 0; i < data.length; i++) {
      String s = data1.get(i);
      String in = s.substring(0,s.indexOf("|"));
      String out = s.substring(s.indexOf("|")+2);
      data[i][0] = in.split(" ");
      data[i][1] = out.split(" ");
    }

    int ans = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i][1].length; j++) {
        int len = data[i][1][j].length();
        if (len == 2 || len == 4 || len == 3 || len == 7) {
          ans++;
        }
      }
    }

    System.out.println(ans);
  }
}
