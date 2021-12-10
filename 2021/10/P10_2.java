import java.util.*;
import java.io.*;

public class P10_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data.add(sc.nextLine());
    }

    //int ans = 0;
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
          data.remove(i);
          i--;
          //System.out.println(data);
          break;
        }
      }
    }

    long[] ans = new long[data.size()];
    for (int i = 0; i < data.size(); i++) {
      String s = data.get(i);
      long score = 0;
      ArrayList<Character> need = new ArrayList<Character> ();

      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '(') {
          need.add(')');
        }
        else if (s.charAt(j) == '[') {
          need.add(']');
        }
        else if (s.charAt(j) == '{') {
          need.add('}');
        }
        else if (s.charAt(j) == '<') {
          need.add('>');
        }

        else if (s.charAt(j) == ')') {
          need.remove(need.size()-1);
        }
        else if (s.charAt(j) == ']') {
          need.remove(need.size()-1);
        }
        else if (s.charAt(j) == '}') {
          need.remove(need.size()-1);
        }
        else if (s.charAt(j) == '>') {
          need.remove(need.size()-1);
        }
      }
      //System.out.println(need);
      for (int j = need.size()-1; j >= 0; j--) {
        if (need.get(j) == ')') {
          score = score * 5 + 1;
        }
        if (need.get(j) == ']') {
          score = score * 5 + 2;
        }
        if (need.get(j) == '}') {
          score = score * 5 + 3;
        }
        if (need.get(j) == '>') {
          score = score * 5 + 4;
        }
      }
      //System.out.println(score);
      ans[i] = score;
      score = 0;
    }

    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans.length-1; j++) {
        if (ans[j] > ans[j+1]) {
          long temp = ans[j];
          ans[j] = ans[j+1];
          ans[j+1] = temp;
        }
      }
    }

    System.out.println(ans[ans.length/2]);
  }
}
