import java.util.*;
import java.io.*;

public class P13_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (!s.equals("")) {
        data1.add(s);
      }
    }

    ArrayList<String[]> data = new ArrayList<String[]> ();
    ArrayList<String> inst = new ArrayList<String> ();
    for (int i = 0; i < data1.size(); i++) {
      if (!data1.get(i).contains("fold")) {
        data.add(data1.get(i).split(","));
      }
      else {
        inst.add(data1.get(i));
      }
    }
    //System.out.println(inst);

    int mR = 0;
    int mC = 0;
    int[][] coor = new int[data.size()][2];
    for (int i = 0; i < coor.length; i++) {
      coor[i][0] = Integer.parseInt(data.get(i)[0]);
      coor[i][1] = Integer.parseInt(data.get(i)[1]);
    }

    for (int i = 0; i < coor.length; i++) {
      //System.out.println(Arrays.toString(coor[i]));
      if (coor[i][0] > mC) {
        mC = coor[i][0];
      }
      if (coor[i][1] > mR) {
        mR = coor[i][1];
      }
    }

    // if (mR%2 == 0) {
    //   mR++;
    // }
    // if (mC%2 == 0) {
    //   mC++;
    // }
    mR++;
    System.out.println(mR + " " + mC);

    ArrayList<ArrayList<Boolean>> grid = new ArrayList<ArrayList<Boolean>> ();
    for (int r = 0; r <= mR; r++) {
      ArrayList<Boolean> row = new ArrayList<Boolean> ();
      for (int c = 0; c <= mC; c++) {
        row.add(false);
        for (int i = 0; i < coor.length; i++) {
          if (coor[i][0] == c && coor[i][1] == r) {
            row.set(row.size()-1, true);
          }
        }
      }
      grid.add(row);
      //System.out.println(grid.get(r));
    }

    //System.out.println(grid.get(0).size());

    // for (int i = 0; i < inst.size(); i++) {
    //   for (int j = 0; j < inst.size()-1; j++) {
    //     String one = inst.get(j);
    //     String two = inst.get(j+1);
    //     if (two.contains("x") && !one.contains("x")) {
    //       inst.set(j,two);
    //       inst.set(j+1,one);
    //     }
    //   }
    // }

    for (int i = 0; i < inst.size(); i++) { //change 1 to size to go through all inst.
      int n = inst.get(i).indexOf("=");
      int fold = Integer.parseInt(inst.get(i).substring(n+1));
      System.out.println(fold);
      if (inst.get(i).contains("y")) {
        System.out.println(grid.size());
        //System.out.println("hi");
        int go = 0;
        if (grid.size()%2 == 0) {
          go = 1;
        }
        for (int r = grid.size()-1; r > fold; r--) {
          //System.out.println(r);
          for (int col = 0; col < grid.get(r).size(); col++) {
            if (grid.get(r).get(col)) {
              grid.get(go).set(col,true);
            }
          }
          grid.remove(r);
          go++;
        }
        grid.remove(fold);
      }

      else {
        System.out.println(grid.get(0).size());
        for (int r = 0; r < grid.size(); r++) {
          //System.out.println(r);
          int go = 0;
          if (grid.get(r).size()%2 == 0) {
            go = 1;
          }
          for (int col = grid.get(r).size()-1; col > fold; col--) {
            if (grid.get(r).get(col)) {
              grid.get(r).set(go,true);
            }
            grid.get(r).remove(col);
            go++;
          }
          grid.get(r).remove(grid.get(r).size()-1);
        }
      }
    }

    //int ans = 0;
    for (int i = 0; i < grid.size(); i++) {
      for (int j = 0; j < grid.get(i).size(); j++) {
        if (grid.get(i).get(j)) {
          //ans++;
          System.out.print("# ");
        }
        else {
          System.out.print("  ");
        }
      }
      System.out.println();
      //System.out.println(grid.get(i));
    }

    //System.out.println(grid.get(0).size());
    //System.out.println(ans);
  }
}
