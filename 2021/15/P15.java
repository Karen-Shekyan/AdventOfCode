import java.util.*;
import java.io.*;

public class P15 {

  public static int Dijkstra () {

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

    PriorityQueue frontier = new PriorityQueue();

    System.out.println(Dijkstra());
  }
}
