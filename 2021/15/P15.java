import java.util.*;
import java.io.*;

public class P15 {

  public static int Dijkstra (int[][] grid, ArrayList<int[]> frontier, int[][] costs) {
    while (frontier.size() != 0) {
      int[] current = {10000000,-1,-1};
      int index = 0;
      for (int i = 0; i < frontier.size(); i++) {
        if (frontier.get(i)[0] < current[0]) {
          current = frontier.get(i);
          index = i;
        }
      }
      frontier.remove(index);
      //System.out.println(Arrays.toString(current));

      int r = current[1];
      int c = current[2];
      int newC = 0;
      if (r + 1 < grid.length) {
        newC = costs[r][c] + grid[r+1][c];
        if (newC < costs[r+1][c]) {
          costs[r+1][c] = newC;
          int[] node = {newC,r+1,c};
          frontier.add(node);
        }
      }
      if (r - 1 >= 0) {
        newC = costs[r][c] + grid[r-1][c];
        if (newC < costs[r-1][c]) {
          costs[r-1][c] = newC;
          int[] node = {newC,r-1,c};
          frontier.add(node);
        }
      }
      if (c + 1 < grid[0].length) {
        newC = costs[r][c] + grid[r][c+1];
        if (newC < costs[r][c+1]) {
          costs[r][c+1] = newC;
          int[] node = {newC,r,c+1};
          frontier.add(node);
        }
      }
      if (c - 1 >= 0) {
        newC = costs[r][c] + grid[r][c-1];
        if (newC < costs[r][c-1]) {
          costs[r][c-1] = newC;
          int[] node = {newC,r,c-1};
          frontier.add(node);
        }
      }
    }
    return costs[costs.length-1][costs[0].length-1];
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }

    int[][] grid = new int[data1.size()][data1.get(0).length()];
    for (int i = 0; i < data1.size(); i++) {
      for (int j = 0; j < data1.get(i).length(); j++) {
        grid[i][j] = Integer.parseInt(data1.get(i).substring(j,j+1));
      }
      //System.out.println(Arrays.toString(grid[i]));
    }

    ArrayList<int[]> frontier = new ArrayList<int[]>();
    int[] node1 = {grid[0][0],0,0};
    frontier.add(node1);
    // ArrayList<int[]> from = new ArrayList<int[]>;
    // from.add()
    int[][] costs = new int[grid.length][grid[0].length];
    for (int i = 0; i < costs.length; i++) {
      for (int j = 0; j < costs[i].length; j++) {
        if (!(i == 0 && j == 0)) {
          costs[i][j] = 10000000;
        }
      }
    }

    System.out.println(Dijkstra(grid, frontier, costs));
  }
}
