import java.util.*;
import java.io.*;

public class P4_2 {
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
        String[] row = new String[5];
        for (int j = 0; j < 5; j++) {
          row[j] = sc.next();
        }
        //System.out.println(Arrays.toString(row));
        box[i] = row;
        //System.out.println(Arrays.toString(box[i]));
        //box[i] = sc.nextLine().split(" ");
      }
      grids.add(box);
    }
    //System.out.println(Arrays.toString(grids.get(0)[0]));

    ArrayList<boolean[][]> checker = new ArrayList<boolean[][]>();
    for (int i = 0; i < grids.size(); i++) {
      boolean[][] box = new boolean[5][5];
      checker.add(box);
    }

    String[][] lastgrid = new String[5][5];
    boolean[][] lastchecker = new boolean[5][5];
    int lastCalled = 0;
    boolean done = false;

    for (int i = 0; i < called.length && !done; i++) {
      for (int j = 0; j < grids.size(); j++) {
        for (int r = 0; r < 5; r++) {
          for (int c = 0; c < 5; c++) {
            if (grids.get(j)[r][c].equals(called[i])) {
              checker.get(j)[r][c] = true;
            }
          }
        }
      }

      for (int j = 0; j < grids.size(); j++) {
        for (int r = 0; r < 5; r++) {
          if (checker.get(j)[r][0] && checker.get(j)[r][1] && checker.get(j)[r][2] && checker.get(j)[r][3] && checker.get(j)[r][4]) {

            if (grids.size() == 1) {
              lastgrid = grids.get(0);
              lastchecker = checker.get(0);
              lastCalled = Integer.parseInt(called[i]);
              done = true;
            }
            else {
              grids.remove(j);
              checker.remove(j);
              j--;
              break;
            }
          }
        }
      }

      for (int j = 0; j < grids.size(); j++) {
        for (int c = 0; c < 5; c++) {
          if (checker.get(j)[0][c] && checker.get(j)[1][c] && checker.get(j)[2][c] && checker.get(j)[3][c] && checker.get(j)[4][c]) {

            if (grids.size() == 1) {
              lastgrid = grids.get(0);
              lastchecker = checker.get(0);
              lastCalled = Integer.parseInt(called[i]);
              done = true;
            }
            else {
              grids.remove(j);
              checker.remove(j);
              j--;
              break;
            }
          }
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (!lastchecker[i][j]) {
          sum += Integer.parseInt(lastgrid[i][j]);
        }
      }
    }

    System.out.println(sum * lastCalled);

  }
}
