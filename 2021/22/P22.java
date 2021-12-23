import java.util.*;
import java.io.*;

public class P22 {

  public static long[] findOverlap (long[] c, long[] o) {
    long[] ans = new long[7];
    boolean ox = false;
    boolean oy = false;
    boolean oz = false;
    if (o[0] == 0) {
      ans[0] = 1;
    }
    for (int i = 1; i < c.length; i++) {
      ans[i] = c[i];
    }
//x
    if (o[1] >= c[1] && o[1] <= c[2]) {
      ox = true;
      ans[1] = o[1];
    }
    if (o[2] >= c[1] && o[2] <= c[2]) {
      ox = true;
      ans[2] = o[2];
    }
    if (o[1] < c[1] && o[2] > c[2]) {
      ox = true;
    }
//y
    if (o[3] >= c[3] && o[3] <= c[4]) {
      oy = true;
      ans[3] = o[3];
    }
    if (o[4] >= c[3] && o[4] <= c[4]) {
      oy = true;
      ans[4] = o[4];
    }
    if (o[3] < c[3] && o[4] > c[4]) {
      oy = true;
    }
//z
    if (o[5] >= c[5] && o[5] <= c[6]) {
      oz = true;
      ans[5] = o[5];
    }
    if (o[6] >= c[5] && o[6] <= c[6]) {
      oz = true;
      ans[6] = o[6];
    }
    if (o[5] < c[5] && o[6] > c[6]) {
      oz = true;
    }

    if (!(ox && oy && oz)) {
      ans[0] = -1;
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

    ArrayList<long[]> data = new ArrayList<long[]>();//[on/off,x1,x2,y1,y2,z1,z2]
    for (int i = 0; i < data1.size(); i++) {
      long[] row = new long[7];
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
    //Collections.reverse(data);
//start and end in every dimension is in order (start <= end);
    ArrayList<long[]> volumes = new ArrayList<long[]>();
    volumes.add(data.get(0));
    for (int i = 1; i < data.size(); i++) {
      ArrayList<long[]> newO = new ArrayList<long[]>();
      long[] cuboid = data.get(i);
      for (int j = 0; j < volumes.size(); j++) {
        long[] other = volumes.get(j);
        long[] overlap = findOverlap(cuboid,other);
        if (overlap[0] != -1) {
          newO.add(overlap);
        }
      }
      for (int j = 0; j < newO.size(); j++) {
        volumes.add(newO.get(j));
      }
      if (cuboid[0] == 1) {
        volumes.add(cuboid);
      }
    }
    // for (int i = 0; i < volumes.size(); i++) {
    //   System.out.println(Arrays.toString(volumes.get(i)));
    // }

    long ans = 0;
    for (int i = 0; i < volumes.size(); i++) {
      long[] cube = volumes.get(i);
      long x = cube[2] - cube[1] + 1;
      long y = cube[4] - cube[3] + 1;
      long z = cube[6] - cube[5] + 1;
      if (cube[0] == 1) {
        ans += x*y*z;
      }
      else {
        ans -= x*y*z;
      }
      //System.out.println(ans);
    }

    System.out.println(ans);
  }
}
