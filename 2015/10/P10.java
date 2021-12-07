import java.util.*;
import java.io.*;

public class P10 {
  public static void main(String[] args) throws IOException {
    String s = "3113322113";
    String newS = "";
    char stored = ' ';
    int seen = 0;

    for (int k = 0; k < 50; k++) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == stored) {
          seen++;
          //System.out.println("hi " + i);
        }
        else {
          //System.out.println(newS);
          newS = newS + seen + stored;
          stored = s.charAt(i);
          seen = 1;
        }
      }
      newS = newS + seen + stored;
      s = newS;
      //System.out.println(s);
      newS = "";
      seen = 0;
      System.out.println(k);
    }

    s = s.substring(s.indexOf(" ")+1);
    //System.out.println(s);
    System.out.println(s.length());
  }
}
