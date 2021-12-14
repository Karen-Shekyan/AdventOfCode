import java.util.*;
import java.io.*;

public class P1_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNext()) {
      s += sc.next();
    }

    String[] data = s.split(",");

    int[][] grid = new int[1000][1000];
    int x = 500;
    int y = 500;
    int ans = 0;
    boolean done = false;
    int d = 0; //0 for up, 1 for right, 2 for down, 3 for left
    for (int i = 0; i < data.length && !done; i++) {
      //turn
      if (data[i].contains("R")) {
        d++;
        if (d == 4) {
          d = 0;
        }
      }
      else {
        d--;
        if (d == -1) {
          d = 3;
        }
      }
      //move
      int distance = Integer.parseInt(data[i].substring(1));
      int r = y;
      int c = x;
      if (d == 2) {
        for (int j = 0; j < distance; j++) {
          r++;
          // if (r == grid.length) {
          //   r = 0;
          // }
          if (grid[r][x] == 1) {
            ans = Math.abs(500-r) + Math.abs(500-x);
            done = true;
            break;
          }
          grid[r][x] = 1;
        }
        y += distance;
      }
      if (d == 1) {
        for (int j = 0; j < distance; j++) {
          c++;
          // if (c == grid.length) {
          //   c = 0;
          // }
          if (grid[y][c] == 1) {
            ans = Math.abs(500-y) + Math.abs(500-c);
            done = true;
            break;
          }
          grid[y][c] = 1;
        }
        x += distance;
      }
      if (d == 0) {
        for (int j = 0; j > -1*distance; j--) {
          r--;
          // if (r == -1) {
          //   r = 999;
          // }
          if (grid[r][x] == 1) {
            ans = Math.abs(500-r) + Math.abs(500-x);
            done = true;
            break;
          }
          grid[r][x] = 1;
        }
        y -= distance;
      }
      if (d == 3) {
        for (int j = 0; j > -1*distance; j--) {
          c--;
          // if (c == -1) {
          //   c = 999;
          // }
          if (grid[y][c] == 1) {
            ans = Math.abs(500-y) + Math.abs(500-c);
            done = true;
            break;
          }
          grid[y][c] = 1;
        }
        x -= distance;
      }
      grid[y][x] = 1;
      //System.out.println(y + " " + x);
    }

    // for (int i = 490; i < 515; i++) {
    //   for (int j = 497; j < 525; j++) {
    //     System.out.print(grid[i][j]);
    //   }
    //   System.out.println();
    // }
    System.out.println(ans);
  }
}
