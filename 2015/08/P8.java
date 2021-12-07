import java.util.*;
import java.io.*;

public class P8 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int codeChar = 0;
    int stringChar = 0;

    while (sc.hasNext()) {
      String s = sc.next();
      codeChar += s.length();
      //System.out.println(s);
      //System.out.println(codeChar);
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '\"') {
          stringChar+=0;
        }
        else if (s.charAt(i) == '\\') {
          stringChar++;
          if (s.charAt(i+1) != 'x') {
            i++;
          }
          else {
            i+=3;
          }
        }
        else {
          stringChar++;
        }
      }
    }

    System.out.println(codeChar - stringChar);
  }
}
