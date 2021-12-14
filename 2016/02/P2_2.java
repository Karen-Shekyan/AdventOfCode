import java.util.*;
import java.io.*;

public class P2_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String[] data = new String[5];
    int c1 = 0;
    while (sc.hasNextLine()) {
      data[c1] = sc.nextLine();
      c1++;
    }

    //System.out.println(Arrays.toString(data));

    int[][] grid = new int[5][5];
    for (int i = 0; i < 3; i++) {
      grid[i][0] = i*3 + 1;
      grid[i][1] = i*3 + 2;
      grid[i][2] = i*3 + 3;
    }
    // for (int i = 0; i < 3; i++) {
    //   System.out.println(Arrays.toString(grid[i]));
    // }

    int r = 1;
    int c = 1;
    String ans = "";
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length(); j++) {
        if (data[i].charAt(j) == 'R') {
          if (c + 1 < 3) {
            c++;
          }
        }
        if (data[i].charAt(j) == 'L') {
          if (c - 1 > -1) {
            c--;
          }
        }
        if (data[i].charAt(j) == 'U') {
          if (r - 1 > -1) {
            r--;
          }
        }
        if (data[i].charAt(j) == 'D') {
          if (r + 1 < 3) {
            r++;
          }
        }
        //System.out.println(r + " " + c);
      }
      ans += grid[r][c];
    }

    System.out.println(ans);
  }
}
