import java.util.*;
import java.io.*;

public class P22 {

  public static int[] findOverlap (int[] c, int[] o) {
    int[] ans = new int[6];
    boolean ox = false;
    boolean oy = false;
    boolean oz = false;
    for (int i = 1; i < c.length; i++) {
      ans[i-1] = c[i];
    }
//x
    if (o[1] >= c[1] && o[1] <= c[2]) {
      ox = true;
      ans[0] = o[1];
    }
    if (o[2] >= c[1] && o[2] <= c[2]) {
      ox = true;
      ans[1] = o[2];
    }
//y
    if (o[3] >= c[3] && o[1] <= c[4]) {
      oy = true;
      ans[2] = o[3];
    }
    if (o[4] >= c[3] && o[2] <= c[4]) {
      oy = true;
      ans[3] = o[4];
    }
//z
    if (o[5] >= c[5] && o[1] <= c[6]) {
      oz = true;
      ans[4] = o[5];
    }
    if (o[6] >= c[5] && o[2] <= c[6]) {
      oz = true;
      ans[5] = o[6];
    }

    if (!(ox && oy && oz)) {
      ans[0] = -2147483648;
    }
    return ans;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String>();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }

    ArrayList<int[]> data = new ArrayList<int[]>();//[on/off,x1,x2,y1,y2,z1,z2]
    for (int i = 0; i < data1.size(); i++) {
      int[] row = new int[7];
      String s = data1.get(i);
      if (s.contains("on")) {
        row[0] = 1;
      }

      row[1] = Integer.parseInt(s.substring(s.indexOf("=")+1,s.indexOf("..")));
      row[2] = Integer.parseInt(s.substring(s.indexOf("..")+2,s.indexOf(",")));
      s = s.substring(s.indexOf(",")+1);
      row[3] = Integer.parseInt(s.substring(s.indexOf("=")+1,s.indexOf("..")));
      row[4] = Integer.parseInt(s.substring(s.indexOf("..")+2,s.indexOf(",")));
      s = s.substring(s.indexOf(",")+1);
      row[5] = Integer.parseInt(s.substring(s.indexOf("=")+1,s.indexOf("..")));
      row[6] = Integer.parseInt(s.substring(s.indexOf("..")+2));
      data.add(row);
    }

//start and end in every dimension is in order (start <= end);
    ArrayList<ArrayList<int[]>> volumes = new ArrayList<ArrayList<int[]>>();
    for (int i = 0; i < data.size(); i++) {
      int[] cuboid = data.get(i);
      if (cuboid[0] == 1) {
        ArrayList<int[]> overlaps = new ArrayList<int[]>();//[add,sub,...]
        overlaps.add(cuboid);
        for (int j = i+1; j < data.size(); j++) {
          int[] overlap;
          overlap = findOverlap(cuboid,data.get(j));
          if (overlap[0] != -2147483648) {
            overlaps.add(overlap);
          }
        }
        volumes.add(overlaps);
      }
    }
//first array in every element in volumes has len 7. all others in that element
//have len 6. first element has a 1 or 0 in pos 0 for on/off.
    int ans = 0;
    for (int i = 0; i < volumes.size(); i++) {
      int x = volumes.get(i).get(0)[2] - volumes.get(i).get(0)[1];
      int y = volumes.get(i).get(0)[4] - volumes.get(i).get(0)[3];
      int z = volumes.get(i).get(0)[6] - volumes.get(i).get(0)[5];
      int volume = x*y*z;
      for (int j = 1; j < volumes.get(i).size(); j++) {
        int mx = volumes.get(i).get(j)[2] - volumes.get(i).get(j)[1];
        int my = volumes.get(i).get(j)[2] - volumes.get(i).get(j)[1];
        int mz = volumes.get(i).get(j)[2] - volumes.get(i).get(j)[1];
        int mvolume = mx*my*mz;
        volume -= mvolume;
      }
      ans += volume;
    }

    System.out.println(ans);
  }
}
