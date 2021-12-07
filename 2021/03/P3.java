import java.util.*;
import java.io.*;

public class P3 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int gamma = 0;
    int epsilon = 0;
    int[] ones = new int[12];
    int numbers = 0;
    //boolean[] digit = new boolean[12];
    while (sc.hasNext()) {
      String s = sc.next();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '1') {
          ones[i] += 1;
        }
      }
      numbers++;
    }
    //System.out.println(Arrays.toString(ones));

    for (int i = 11; i >= 0; i--) {
      if (ones[i] > numbers/2) {
        gamma += (int)Math.pow(2,11-i);
      }
      else {
        epsilon += (int)Math.pow(2,11-i);
      }
    }

    System.out.println(gamma*epsilon);
  }
}
