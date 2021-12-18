import java.util.*;
import java.io.*;

public class P18 {

  public static ArrayList<Character> reduce (ArrayList<Character> c) {
    int nested = 0;
    for (int i = 0; i < c.size()-1; i++) {
      if (Character.isDigit(c.get(i)) && Character.isDigit(c.get(i+1))) {//10 is not a char
        String num = "";
        num += c.get(i);
        num += c.get(i+1);
        int n = Integer.parseInt(num);
        c.remove(i);
        c.remove(i);
        c.add(i,'[');
        String temp = "";
        temp += n/2;
        c.add(i+1,temp.charAt(0));
        c.add(i+2,',');
        if (n % 2 == 1) {
          temp = "";
          temp += n/2+1;
        }
        c.add(i+3,temp.charAt(0));
        c.add(i+4,']');
        i = 0;
        nested = 0;
      }
      if (c.get(i) == '[') {
        nested++;
      }
      if (c.get(i) == ']') {
        nested--;
      }
      if (nested > 4) {
        String tempN1 = "";
        String tempN2 = "";
        tempN1 += c.get(i+1);
        tempN2 += c.get(i+3);
        int left = Integer.parseInt(tempN1);
        int right = Integer.parseInt(tempN2);
        for (int j = i-1; j >= 0; j--) {
          if (Character.isDigit(c.get(j))) {
            String tS = "" + c.get(j);
            int old = Integer.parseInt(tS);
            int x = old + left;
            String newS = "" + x;
            if (newS.length() == 2) {

            }
            else {
              
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<ArrayList<Character>> data = new ArrayList<ArrayList<Character>>();
    while (sc.hasNext()) {
      String s = sc.next();
      ArrayList<Character> row = new ArrayList<Character>();
      for (int i = 0; i < s.length(); i++) {
        row.add(s.charAt(i));
      }
      data.add(row);
    }
    //System.out.println(data);

    for (int i = 0; i < data.size(); i++) {
      data.set(i,reduce(data.get(i)));
    }

  }
}
