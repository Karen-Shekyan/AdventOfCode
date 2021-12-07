import java.util.*;
import java.io.*;

public class P4 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String[] called = sc.nextLine().split(",");
    ArrayList<String[][]> grids = new ArrayList<String[][]>();
    //int grid = 0;
    while (sc.hasNextLine()) {
      sc.nextLine();
      String[][] box = new String[5][5];
      for (int i = 0; i < 5; i++) {
        box[i] = sc.nextLine().split(" ");
      }
      grids.add(box);
    }
    //System.out.println(grids);

    boolean[][][] checker = new boolean[grids.size()][5][5];
    boolean done = false;
    int wnum = 0;
    int lastCalled = 0;

    for (int i = 0; i < called.length && !done; i++) {
      for (int j = 0; j < grids.size(); j++) {
        for (int r = 0; r < 5; r++) {
          for (int c = 0; c < 5; c++) {
            if (called[i].equals(grids.get(j)[r][c])) {
              checker[j][r][c] = true;
            }
          }
        }
      }

      for (int j = 0; j < grids.size() && !done; j++) {
        for (int r = 0; r < 5 && !done; r++) {
          if (checker[j][r][0] && checker[j][r][1] && checker[j][r][2] && checker[j][r][3] && checker[j][r][4]) {
            done = true;
            wnum = j;
            lastCalled = Integer.parseInt(called[i]);
          }
        }

        for (int c = 0; c < 5 && !done; c++) {
          if (checker[j][0][c] && checker[j][1][c] && checker[j][2][c] && checker[j][3][c] && checker[j][4][c]) {
            done = true;
            wnum = j;
            lastCalled = Integer.parseInt(called[i]);
          }
        }
      }
    }
    //System.out.println(Arrays.toString(checker[1][0]));

    int sum = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (!checker[wnum][i][j]) {
          sum += Integer.parseInt(grids.get(wnum)[i][j]);
        }
      }
    }

    System.out.println(sum*lastCalled);
  }
}
