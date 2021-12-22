import java.util.*;
import java.io.*;

public class P21 {

  public static int incRoll (int roll) {
    int ans = roll+1;
    if (ans > 100) {
      ans = 1;
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
    //System.out.println(Arrays.toString(pos));

    int turns = 0;
    int nextRoll = 1;
    long[] scores = new long[2];
    while (scores[0] < 1000 && scores[1] < 1000) {

      turns+=1;
      // System.out.println("Turns " + turns);
      // System.out.println(Arrays.toString(scores));
      // System.out.println(Arrays.toString(pos));
      int one = nextRoll;
      int two = incRoll(one);
      int three = incRoll(two);
      int four = incRoll(three);
      int five = incRoll(four);
      int six = incRoll(five);
      nextRoll = incRoll(six);

      pos[0] = incPos(pos[0], one+two+three);
      scores[0] += pos[0];
      if (scores[0] >= 1000) {
        break;
      }

      turns+=1;
      // System.out.println("Turns " + turns);
      // System.out.println(Arrays.toString(scores));
      // System.out.println(Arrays.toString(pos));
      pos[1] = incPos(pos[1], four+five+six);
      scores[1] += pos[1];
    }

    if (scores[0] < scores[1]) {
      System.out.println(scores[0]*turns*3);
    }
    else {
      System.out.println(scores[1]*turns*3);
    }
  }
}
