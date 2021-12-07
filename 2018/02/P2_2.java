import java.util.*;
import java.io.*;

public class P2_2 {

  public static String[] closeEnough (String s, String t) {
    String[] ans = new String[2];
    ans[0] = "";
    int difference = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        difference++;
      }
      else {
        ans[1] += s.charAt(i);
      }
    }
    ans[0] = "" + difference;
    return ans;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNextLine()) {
      s += sc.nextLine() + " ";
    }

    String[] data = s.split(" ");

    String ans = "";
    for (int i = 0; i < data.length-1; i++) {
      for (int j = i+1; j < data.length; j++) {
        String[] info = closeEnough(data[i],data[j]);
        if (info[0].equals("1")) { //1 is true, else false.
          ans = info[1];
        }
      }
    }

    System.out.println(ans);
  }
}
