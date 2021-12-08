import java.util.*;
import java.io.*;

public class P2 {
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

    data[1] = 12;
    data[2] = 2;
    for (int i = 0; i < data.length; i+=4) {
      if (data[i] == 1) {
        int n = data[data[i+1]] + data[data[i+2]];
        data[data[i+3]] = n;
      }
      else if (data[i] == 2) {
        int n = data[data[i+1]] * data[data[i+2]];
        data[data[i+3]] = n;
      }
      else {
        break;
      }
    }

    System.out.println(data[0]);
  }
}
