import java.util.*;
import java.io.*;

public class P2 {

  public static boolean hasTwo (String s) {
    int count = 0;
    for (int i = 0; i < s.length()-1; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          count++;
          //System.out.println(s.charAt(i));
        }
      }
      if (count == 2) {
        return true;
      }
      count = 0;
    }
    return false;
  }

  public static boolean hasThree (String s) {
    int count = 0;
    for (int i = 0; i < s.length()-1; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          count++;
        }
      }
      if (count == 3) {
        return true;
      }
      count = 0;
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = "";
    while (sc.hasNextLine()) {
      s += sc.nextLine() + " ";
    }

    String[] data = s.split(" ");

    int two = 0;
    int three = 0;
    for (int i = 0; i < data.length; i++) {
      if (hasTwo(data[i])) {
        two++;
      }
      if (hasThree(data[i])) {
        three++;
      }
      //System.out.println(two);
      //System.out.println(three);
    }

    System.out.println(two*three);
  }
}
