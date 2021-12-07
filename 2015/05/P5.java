import java.util.*;
import java.io.*;

public class P5 {

  public static void main(String[] args) throws IOException{

    File f = new File (args[0]);
    Scanner input = new Scanner (f);

    int nice1 = 0;
    int nice2 = 0;
    while (input.hasNext()) {
      String s = input.next();
      if (!(s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy"))) {
        int vowels = 0;
        boolean doublel = false;
        for (int i = 0; i < s.length()-1; i++) {
          if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
            vowels++;
          }
          if (s.charAt(i) == s.charAt(i+1)) {
            doublel = true;
          }
        }
        if (s.charAt(s.length()-1) == 'a' || s.charAt(s.length()-1) == 'e' || s.charAt(s.length()-1) == 'i' || s.charAt(s.length()-1) == 'o' || s.charAt(s.length()-1) == 'u') {
          vowels++;
        }
        if (doublel && vowels >= 3) {
          nice1++;
        }
      }

      boolean pair = false;
      boolean tri = false;
      for (int j = 0; j < s.length()-2; j++) {
        String sub = s.substring(j, j+2);
        if (s.substring(0,j).contains(sub) || s.substring(j+2).contains(sub)) {
          pair = true;
        }
        if (s.charAt(j) == s.charAt(j+2)) {
          tri = true;
        }
      }
      if (pair && tri) {
        nice2++;
      }
    }

    System.out.println(nice1);
    System.out.println(nice2);
  }
}
