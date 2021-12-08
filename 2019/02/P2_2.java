import java.util.*;
import java.io.*;

public class P2_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);
    String s = "";
    while (sc.hasNext()) {
      s += sc.next();
    }

    String[] data1 = s.split(",");
    int[] data = new int[data1.length];
    for (int i = 0; i < data.length; i++) {
      data[i] = Integer.parseInt(data1[i]);
    }

    int ans = 0;
    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        int[] datac = Arrays.copyOf(data, data.length);
        datac[1] = noun;
        datac[2] = verb;
        for (int i = 0; i < datac.length; i+=4) {
          if (datac[i] == 1) {
            int n = datac[datac[i+1]] + datac[datac[i+2]];
            datac[datac[i+3]] = n;
          }
          else if (datac[i] == 2) {
            int n = datac[datac[i+1]] * datac[datac[i+2]];
            datac[datac[i+3]] = n;
          }
          else {
            break;
          }
        }
        if (datac[0] == 19690720) {
          ans = 100 * noun + verb;
          break;
        }
      }
    }

    System.out.println(ans);
  }
}
