import java.util.*;
import java.io.*;

public class P6_2 {
  public static void main(String[] args) throws IOException{
    File input = new File (args[0]);
    Scanner s = new Scanner (input);

    int[][]grid = new int[1000][1000];
    while (s.hasNextLine()) {
      String l = s.nextLine();
      if (l.contains("toggle")) {
        String coor1 = l.substring(7,l.indexOf("through")-1);
        String coor2 = l.substring(l.indexOf("through")+8);
        String[] c1 = coor1.split(",");
        String[] c2 = coor2.split(",");
        int x1 = Integer.parseInt(c1[0]);
        int y1 = Integer.parseInt(c1[1]);
        int x2 = Integer.parseInt(c2[0]);
        int y2 = Integer.parseInt(c2[1]);
        for (int i = y1; i <= y2; i++) {
          for (int j = x1; j <= x2; j++) {
            grid[i][j] += 2;
          }
        }
      }
      else if (l.contains("turn on")) {
        String coor1 = l.substring(8,l.indexOf("through")-1);
        String coor2 = l.substring(l.indexOf("through")+8);
        String[] c1 = coor1.split(",");
        String[] c2 = coor2.split(",");
        int x1 = Integer.parseInt(c1[0]);
        int y1 = Integer.parseInt(c1[1]);
        int x2 = Integer.parseInt(c2[0]);
        int y2 = Integer.parseInt(c2[1]);
        for (int i = y1; i <= y2; i++) {
          for (int j = x1; j <= x2; j++) {
            grid[i][j]++;
          }
        }
      }
      else {
        String coor1 = l.substring(9,l.indexOf("through")-1);
        String coor2 = l.substring(l.indexOf("through")+8);
        String[] c1 = coor1.split(",");
        String[] c2 = coor2.split(",");
        int x1 = Integer.parseInt(c1[0]);
        int y1 = Integer.parseInt(c1[1]);
        int x2 = Integer.parseInt(c2[0]);
        int y2 = Integer.parseInt(c2[1]);
        for (int i = y1; i <= y2; i++) {
          for (int j = x1; j <= x2; j++) {
            grid[i][j]--;
            if (grid[i][j] < 0) {
              grid[i][j] = 0;
            }
          }
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        ans += grid[i][j];
      }
    }
    System.out.println(ans);
  }
}
