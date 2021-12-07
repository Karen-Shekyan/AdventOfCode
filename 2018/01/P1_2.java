import java.util.*;
import java.io.*;

public class P1_2 {

  public static boolean beenHere (int n, ArrayList<Integer> data) {
    for (int i = 0; i < data.size(); i++) {
      if (n == data.get(i)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int ans = 0;
    //int REALans = 0;
    ArrayList<String> data = new ArrayList<String> ();
    ArrayList<Integer> seen = new ArrayList<Integer> ();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      data.add(s);
    }

    int pos = 0;
    while (!beenHere(ans, seen)) {
      if (pos >= data.size()) {
        pos = 0;
      }
      seen.add(ans);
      if (data.get(pos).contains("+")) {
        ans += Integer.parseInt(data.get(pos).substring(1));
      }
      else {
        ans-= Integer.parseInt(data.get(pos).substring(1));
      }
      pos++;
      //System.out.println(ans);
    }

    System.out.println(ans);
  }
}
