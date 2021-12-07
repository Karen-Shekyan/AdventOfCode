import java.util.*;
import java.io.*;

public class P8_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int codeChar = 0;
    int encodeChar = 0;

    while (sc.hasNext()) {
      String s = sc.next();
      codeChar += s.length();
      encodeChar += 2;
      System.out.println(s);
      System.out.println(encodeChar);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '\"') {
          encodeChar++;
        }
        if (s.charAt(i) == '\\') {
          encodeChar++;
        }
        encodeChar++;
      }
    }

    System.out.println(encodeChar - codeChar);
  }
}
