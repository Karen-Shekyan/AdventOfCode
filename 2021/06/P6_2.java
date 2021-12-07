import java.util.*;
import java.io.*;

public class P6_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);
    String s = "";
    while (sc.hasNext()) {
      s+=sc.next();
    }

    String[] data1 = s.split(",");
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < data1.length; i++) {
      data.add(Integer.parseInt(data1[i]));
    }

    //int ans = data.size();
    long[] time = new long[9];
    for (int i = 0; i < data.size(); i++) {
      time[data.get(i)]++;
    }

    //System.out.println(Arrays.toString(time));
    int day = 0;
    while (day < 256) {
      long temp = time[0];
      time[0] = time[1];
      time[1] = time[2];
      time[2] = time[3];
      time[3] = time[4];
      time[4] = time[5];
      time[5] = time[6];
      time[6] = time[7];
      time[7] = time[8];
      time[8] = temp;
      time[6] += temp;
      day++;
      if (day == 18) {
        System.out.println(Arrays.toString(time));
      }
    }

    long ans = 0;
    for (int i = 0; i < 9; i++) {
      ans += time[i];
    }
    System.out.println(ans);

    // int day = 0;
    // while (day < 256) {
    //   int newFish = 0;
    //   for (int i = 0; i < data.size(); i++) {
    //     data.set(i, data.get(i)-1);
    //     if (data.get(i) < 0) {
    //       data.set(i, 6);
    //       newFish++;
    //     }
    //   }
    //   for (int i = 0; i < newFish; i++) {
    //     data.add(8);
    //   }
    //   day++;
    //   System.out.println(day);
    // }
    //
    //System.out.println(data.size());
  }
}
