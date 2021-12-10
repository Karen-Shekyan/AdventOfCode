import java.util.*;
import java.io.*;

public class P10 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data.add(sc.nextLine());
    }

    int ans = 0;
    ArrayList<Character> expected = new ArrayList<Character> ();
    for (int i = 0; i < data.size(); i++) {
      String s = data.get(i);
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '(') {
          expected.add(')');
        }
        else if (s.charAt(j) == '[') {
          expected.add(']');
        }
        else if (s.charAt(j) == '{') {
          expected.add('}');
        }
        else if (s.charAt(j) == '<') {
          expected.add('>');
        }


        else if (s.charAt(j) == expected.get(expected.size()-1)) {
          expected.remove(expected.size()-1);
        }

        else {
          if (s.charAt(j) == ')') {
            ans += 3;
          }
          if (s.charAt(j) == ']') {
            ans += 57;
          }
          if (s.charAt(j) == '}') {
            ans += 1197;
          }
          if (s.charAt(j) == '>') {
            ans += 25137;
          }
          //System.out.println(s.charAt(j) + " " + i);
          break;
        }
      }
    }

    System.out.println(ans);
  }
}
