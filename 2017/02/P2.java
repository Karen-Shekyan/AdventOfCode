import java.util.*;
import java.io.*;

public class P2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<int[]> data = new ArrayList<int[]> ();
    int r = 0;
    while (sc.hasNextLine()) {
      data.add(r)
      r++;
    }

    int max = 0;
    int min = 10000;
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] < min) {
          min = data[i][j];
        }
        if (data[i][j] > max) {
          max = data[i][j];
        }
      }
    }

    System.out.println(max-min);
  }
}
