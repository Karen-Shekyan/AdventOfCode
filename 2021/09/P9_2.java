import java.util.*;
import java.io.*;

public class P9_2 {

  public static int findBasin (int r, int c, int[][] grid, int depth) {
    if (c+1 >= grid[r].length || grid[r][c+1] == 9) {
      if (c-1 < 0 || grid[r][c-1] == 9) {
        if (r+1 >= grid.length || grid[r+1][c] == 9) {
          if (r-1 < 0 || grid[r-1][c] == 9) {
            grid[r][c] = 9;
            return 1;
          }
        }
      }
    }

    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    if (c+1 < grid[r].length && grid[r][c+1] != 9) {
      grid[r][c] = 9;
      one = findBasin(r, c+1, grid, depth++);
    }
    if (c-1 >= 0 && grid[r][c-1] != 9) {
      grid[r][c] = 9;
      two = findBasin(r, c-1, grid, depth++);
    }
    if (r+1 < grid.length && grid[r+1][c] != 9) {
      grid[r][c] = 9;
      three = findBasin(r+1, c, grid, depth++);
    }
    if (r-1 >= 0 && grid[r-1][c] != 9) {
      grid[r][c] = 9;
      four = findBasin(r-1, c, grid, depth++);
    }
    //System.out.println(one+" "+two+" "+three+" "+four);
    return (one + two + three + four + 1);

  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);


    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }

    int[][] data = new int[data1.size()][data1.get(0).length()];
    for (int i = 0; i < data1.size(); i++) {
      for (int j = 0; j < data1.get(i).length(); j++) {
        String s = "" + data1.get(i).charAt(j);
        data[i][j] = Integer.parseInt(s);
      }
    }

    //int ans = 0;
    int first = 0;
    int second = 0;
    int third = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        boolean up = true;
        boolean left = true;
        boolean down = true;
        boolean right = true;

        if (i-1 >= 0) {
          if (!(data[i-1][j] > data[i][j])) {
            up = false;
          }
        }
        if (j-1 >= 0) {
          if (!(data[i][j-1] > data[i][j])) {
            left = false;
          }
        }
        if (i+1 < data.length) {
          if (!(data[i+1][j] > data[i][j])) {
            down = false;
          }
        }
        if (j+1 < data[i].length) {
          if (!(data[i][j+1] > data[i][j])) {
            right = false;
            //System.out.println(data[i][j]);
          }
        }

        if (up && left && down && right) {
          //System.out.println(i + " " + j);
          int x = findBasin(i, j, data, 0);
          //System.out.println(x);
          if (x > third) {
            third = x;
            //System.out.println(third);
            if (third > second) {
              int temp = third;
              third = second;
              second = temp;
              if (second > first) {
                int temp1 = second;
                second = first;
                first = temp1;
              }
            }
          }
          //System.out.println(first + " " + second + " " + third);
        }


      }
    }

    System.out.println(first * second * third);
  }
}
