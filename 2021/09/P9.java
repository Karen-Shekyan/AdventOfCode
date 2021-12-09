import java.util.*;
import java.io.*;

public class P9 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }

    int[][] data = new int[data1.size()][data1.get(0).length()];
    for (int i = 0; i < data1.size(); i++) {
      for (int j = 0; j < data1.get(i).length(); j++) {
        String s = "" + data1.get(i).charAt(j);
        data[i][j] = Integer.parseInt(s);
      }
    }

    int ans = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        boolean up = true;
        boolean left = true;
        boolean down = true;
        boolean right = true;

        if (i-1 >= 0) {
          if (!(data[i-1][j] > data[i][j])) {
            up = false;
          }
        }
        if (j-1 >= 0) {
          if (!(data[i][j-1] > data[i][j])) {
            left = false;
          }
        }
        if (i+1 < data.length) {
          if (!(data[i+1][j] > data[i][j])) {
            down = false;
          }
        }
        if (j+1 < data[i].length) {
          if (!(data[i][j+1] > data[i][j])) {
            right = false;
            //System.out.println(data[i][j]);
          }
        }

        if (up && left && down && right) {
          ans += 1 + data[i][j];
          //System.out.println(data[i][j]);
        }
      }
    }

    System.out.println(ans);
  }
}
