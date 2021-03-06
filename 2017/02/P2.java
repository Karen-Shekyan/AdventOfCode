import java.util.*;
import java.io.*;

public class P2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>> ();
    while (sc.hasNextInt()) {
      ArrayList<Integer> row = new ArrayList<Integer> ();
      for (int i = 0; i < 16; i++) {
        row.add(sc.nextInt());
      }
      data.add(row);
    }

    int checksum = 0;
    for (int i = 0; i < data.size(); i++) {
      int max = 0;
      int min = 100000;
      for (int j = 0; j < data.get(i).size(); j++) {
        if (data.get(i).get(j) < min) {
          min = data.get(i).get(j);
        }
        if (data.get(i).get(j) > max) {
          max = data.get(i).get(j);
        }
      }
      checksum += max-min;
    }

    System.out.println(checksum);
  }
}
