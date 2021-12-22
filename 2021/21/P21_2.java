import java.util.*;
import java.io.*;

public class P21_2 {

  public static long universes (int pos, int score) {
    //System.out.println(score);
    if (score >= 21) {
      return 1;
    }
    long ans = 0;
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        for (int k = 1; k <= 3; k++) {
          int inc = i + j + k;
          int newP = incPos(pos,inc);
          int newS = score + newP;
          System.out.println(ans);
          ans += universes(newP,newS);
        }
      }
    }
    return ans;
  }

  public static int incPos (int pos, int inc) {
    int ans = pos + inc;
    if (ans > 10) {
      ans %= 10;
    }
    if (ans == 0) {
      ans = 10;
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

    int[] pos = new int[2];
    pos[0] = Integer.parseInt(data1.get(0).substring(28));
    pos[1] = Integer.parseInt(data1.get(1).substring(28));
    int[] scores = new int[2];

    System.out.println(universes(pos[0],scores[0]));
    System.out.println(universes(pos[1],scores[1]));
  }
}
