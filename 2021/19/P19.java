import java.util.*;
import java.io.*;

public class P19 {

  public static void reset (ArrayList<ArrayList<int[]>> datac, ArrayList<ArrayList<int[]>> data) {
    datac = new ArrayList<ArrayList<int[]>>();
    for (int i = 0; i < data.size(); i++) {
      ArrayList<int[]> row = new ArrayList<int[]>();
      for (int j = 0; j < data.get(i).size(); j++) {
        int[] nums = new int[3];
        for (int k = 0; k < 3; k++) {
          nums[k] = data.get(i).get(j)[k];
        }
        row.add(nums);
      }
      datac.add(row);
    }
  }

  public static void main (String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String>();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }
    //System.out.println(data1);

    ArrayList<ArrayList<String>> data2 = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < data1.size(); i++) {
      if (data1.get(i).contains("scanner")) {
        i++;
        //System.out.println(i);
        ArrayList<String> row = new ArrayList<String>();
        while (i < data1.size() && data1.get(i).length() > 2) {
          row.add(data1.get(i));
          i++;
        }
        data2.add(row);
      }
    }

    ArrayList<ArrayList<int[]>> data = new ArrayList<ArrayList<int[]>>();
    ArrayList<ArrayList<int[]>> datac = new ArrayList<ArrayList<int[]>>();
    for (int i = 0; i < data2.size(); i++) {
      ArrayList<int[]> row = new ArrayList<int[]>();
      ArrayList<int[]> rowc = new ArrayList<int[]>();
      for (int j = 0; j < data2.get(i).size(); j++) {
        String[] s = data2.get(i).get(j).split(",");
        int[] nums = new int[3];
        int[] numsc = new int[3];
        for (int k = 0; k < 3; k++) {
          nums[k] = Integer.parseInt(s[k]);
          numsc[k] = Integer.parseInt(s[k]);
        }
        //System.out.println(Arrays.toString(nums));
        row.add(nums);
        rowc.add(numsc);
      }
      //System.out.println();
      data.add(row);
      datac.add(rowc);
    }

    int ans = 0;
    while (data.size() != 1) {
      for (int i = 0; i < data.get(0).size(); i++) {//beacon in 0
        int dx0 = data.get(0).get(i)[0];
        int dy0 = data.get(0).get(i)[1];
        int dz0 = data.get(0).get(i)[2];
        for (int j = 0; j < datac.get(0).size(); j++) {
          datac.get(0).get(j)[0] -= dx0;
          datac.get(0).get(j)[1] -= dy0;
          datac.get(0).get(j)[2] -= dz0;
        }
        for (int j = 1; j < data.size(); j++) {     //other scanners
          for (int k = 0; k < data.get(j).size(); k++) {//beacons in that scanner
            int dxj = data.get(j).get(k)[0];
            int dyj = data.get(j).get(k)[1];
            int dzj = data.get(j).get(k)[2];
            for (int l = 0; l < datac.get(j).size(); l++) {
              datac.get(j).get(l)[0] -= dxj;
              datac.get(j).get(l)[1] -= dyj;
              datac.get(j).get(l)[2] -= dzj;
            }
            compare(datac.get(0),datac.get(j));//what should this return??
            reset(datac,data);
          }
        }
      }
    }

    System.out.println(ans);
  }
}
