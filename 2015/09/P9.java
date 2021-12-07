import java.util.*;
import java.io.*;

public class P9 {
  public static void main(String[] args) throws IOException{
    File in = new File (args[0]);
    Scanner sc = new Scanner (in);

    String[][] data = new String[28][];
    int c = 0;
    while (sc.hasNextLine()) {
      data[c] = sc.nextLine().split(" ");
      c++;
    }

    int[][] distances = new int[8][8];
    int n = 0;
    for (int i = 0; i < distances.length; i++) {
      for (int j = 0; j < distances[i].length; j++) {
        if (j <= i) {
          distances[i][j] = distances[j][i];
        }
        else {
          distances[i][j] = Integer.parseInt(data[n][4]);
          n++;
        }
      }
    }

    int ans = 0;
    // for (int i = 0; i < 8; i++) {
    //   System.out.println(Arrays.toString(distances[i]));
    // }
    

    System.out.println(ans);
  }
}
