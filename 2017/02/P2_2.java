import java.util.*;
import java.io.*;

public class P2_2 {
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
      int q = 0;
      for (int j = 0; j < data.get(i).size(); j++) {
        int one = data.get(i).get(j);
        for (int k = 0; k < data.get(i).size(); k++) {
          int two = data.get(i).get(k);
          if (j != k && one % two == 0) {
            q = one/two;
            break;
          }
        }
        if (q != 0) {
          break;
        }
      }
      checksum += q;
    }

    System.out.println(checksum);
  }
}
