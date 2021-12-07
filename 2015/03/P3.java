import java.util.*;
import java.io.*;

public class P3 {

  public static void main(String[] args) throws IOException{

    File f = new File (args[0]);
    Scanner input = new Scanner (f);

    String s = input.next();
    int x = 0;
    int y = 0;
    int[][] grid = new int[8192][8192];
    int ans = 1;
    grid[0][0] = 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '^') {
        x--;
        if (x < 0) {
          x = 8191;
        }
      }
      if (s.charAt(i) == 'v') {
        x++;
        if (x > 8191) {
          x = 0;
        }
      }
      if (s.charAt(i) == '<') {
        y--;
        if (y < 0) {
          y = 8191;
        }
      }
      if (s.charAt(i) == '>') {
        y++;
        if (y > 8191) {
          y = 0;
        }
      }
      if (grid[x][y] == 0) {
        ans++;
        grid[x][y]++;
      }
    }

    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    int ans2 = 1;
    int[][] grid2 = new int[8192][8192];
    grid2[0][0] = 1;
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        if (s.charAt(i) == '^') {
          x1--;
          if (x1 < 0) {
            x1 = 8191;
          }
        }
        if (s.charAt(i) == 'v') {
          x1++;
          if (x1 > 8191) {
            x1 = 0;
          }
        }
        if (s.charAt(i) == '<') {
          y1--;
          if (y1 < 0) {
            y1 = 8191;
          }
        }
        if (s.charAt(i) == '>') {
          y1++;
          if (y1 > 8191) {
            y1 = 0;
          }
        }
        if (grid2[x1][y1] == 0) {
          ans2++;
          grid2[x1][y1]++;
        }
      }
      else {
        if (s.charAt(i) == '^') {
          x2--;
          if (x2 < 0) {
            x2 = 8191;
          }
        }
        if (s.charAt(i) == 'v') {
          x2++;
          if (x2 > 8191) {
            x2 = 0;
          }
        }
        if (s.charAt(i) == '<') {
          y2--;
          if (y2 < 0) {
            y2 = 8191;
          }
        }
        if (s.charAt(i) == '>') {
          y2++;
          if (y2 > 8191) {
            y2 = 0;
          }
        }
        if (grid2[x2][y2] == 0) {
          ans2++;
          grid2[x2][y2]++;
        }
      }
    }

    System.out.println(ans);
    System.out.println(ans2);
  }
}
