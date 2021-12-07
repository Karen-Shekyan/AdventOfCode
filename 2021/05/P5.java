import java.util.*;
import java.io.*;

public class P5 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String[][][] data1 = new String[500][2][2];
    int line = 0;

    while (sc.hasNext()) {
      String coor1 = sc.next();
      sc.next();
      String coor2 = sc.next();
      data1[line][0] = coor1.split(",");
      data1[line][1] = coor2.split(",");
      line++;
    }

    int[][][] data = new int[data1.length][2][2];
    for (int i = 0; i < data1.length; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) {
          //System.out.println(data1[i][j][k]);
          if (data1[i][j][k] != null) {
            data[i][j][k] = Integer.parseInt(data1[i][j][k]);
          }
        }
      }
    }
    //System.out.println(data[2][1][0]);

    int[][] grid = new int[1000][1000];
    for (int i = 0; i < data.length; i++) {
      if (data[i][0][0] == data[i][1][0]) {//COLUMNS AGREE
        int c = data[i][0][0];
        int start = 0;
        int end = 0;
        if (data[i][0][1] < data[i][1][1]) {
          start = data[i][0][1];
          end = data[i][1][1];
        }
        else {
          start = data[i][1][1];
          end = data[i][0][1];
        }
        for (int j = start; j <= end; j++) {
          grid[j][c]++;
        }
      }
      else if (data[i][0][1] == data[i][1][1]) {//ROWS AGREE
        int r = data[i][0][1];
        int start = 0;
        int end = 0;
        if (data[i][0][0] < data[i][1][0]) {
          start = data[i][0][0];
          end = data[i][1][0];
        }
        else {
          start = data[i][1][0];
          end = data[i][0][0];
        }
        for (int j = start; j <= end; j++) {
          grid[r][j]++;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        if (grid[i][j] >= 2) {
          ans++;
        }
      }
    }
    // for (int i = 0; i < grid.length; i++) {
    //   System.out.println(Arrays.toString(grid[i]));
    // }
    System.out.println(ans);
  }
}
