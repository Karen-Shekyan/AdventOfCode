import java.util.*;
import java.io.*;

public class P11_2 {

  public static int resolveFlashes (int[][] data) {
    boolean[][] flashed = new boolean[10][10];
    int ans = 0;
    for (int i = 0; i < 100; i++) {
      for (int r = 0; r < 10; r++) {
        for (int c = 0; c < 10; c++) {
          //System.out.println(r + " " + c);
          if (data[r][c] > 9) {
            //System.out.println("hi");
            if (r+1 < 10 && !flashed[r+1][c]) {
              data[r+1][c]++;
            }
            if (r-1 >= 0 && !flashed[r-1][c]) {
              data[r-1][c]++;
            }
            if (c+1 < 10 && !flashed[r][c+1]) {
              data[r][c+1]++;
            }
            if (c-1 >= 0 && !flashed[r][c-1]) {
              data[r][c-1]++;
            }
            if (c+1 < 10 && r+1 < 10 && !flashed[r+1][c+1]) {
              data[r+1][c+1]++;
            }
            if (r+1 < 10 && c-1 >= 0 && !flashed[r+1][c-1]) {
              data[r+1][c-1]++;
            }
            if (r-1 >= 0 && c+1 < 10 && !flashed[r-1][c+1]) {
              data[r-1][c+1]++;
            }
            if (r-1 >= 0 && c-1 >= 0 && !flashed[r-1][c-1]) {
              data[r-1][c-1]++;
            }
            //System.out.println("hi");
            ans++;
            //System.out.println(ans);
            data[r][c] = 0;
            flashed[r][c] = true;
          }
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int[][] data = new int[10][10];
    int line = 0;
    while (sc.hasNext()) {
      String s = sc.next();
      for (int i = 0; i < s.length(); i++) {
        data[line][i] = Integer.parseInt(s.substring(i,i+1));
      }
      line++;
    }

    //int ans = 0;
    int steps = 0;
    while (steps < 10000) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          data[i][j]++;
        }
      }
      //System.out.println(Arrays.toString(data[0]));
      if (resolveFlashes(data) == 100) {
        break;
      }
      steps++;
    }

    System.out.println(steps+1);
  }
}
