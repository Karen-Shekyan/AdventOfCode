import java.util.*;
import java.io.*;

public class P18_2 {

  public static boolean explode (ArrayList<String> c) {
    int nested = 0;
    for (int i = 0; i < c.size(); i++) {
      if (c.get(i).equals("[")) {
        nested++;
      }
      if (c.get(i).equals("]")) {
        nested--;
      }
      if (nested > 4) {
        int n1 = Integer.parseInt(c.get(i+1));
        int n2 = Integer.parseInt(c.get(i+3));
        for (int j = 0; j < 4; j++) {
          c.remove(i);
        }
        c.set(i,"0");
        for (int j = i-1; j > 0; j--) {
          if (!c.get(j).equals("[") && !c.get(j).equals("]") && !c.get(j).equals(",")) {
            int num = Integer.parseInt(c.get(j));
            num += n1;
            c.set(j,""+num);
            break;
          }
        }
        for (int j = i+1; j < c.size(); j++) {
          if (!c.get(j).equals("[") && !c.get(j).equals("]") && !c.get(j).equals(",")) {
            int num = Integer.parseInt(c.get(j));
            num += n2;
            c.set(j,""+num);
            break;
          }
        }
        return true;
      }
    }
    return false;
  }

  public static boolean split (ArrayList<String> c) {
    for (int i = 0; i < c.size(); i++) {
      if (!c.get(i).equals("[") && !c.get(i).equals("]") && !c.get(i).equals(",")) {
        int n = Integer.parseInt(c.get(i));
        if (n >= 10) {
          int up = n/2;
          if (n % 2 == 1) {
            up++;
          }
          c.remove(i);
          c.add(i,"]");
          c.add(i,"" + up);
          c.add(i,",");
          c.add(i,"" + n/2);
          c.add(i,"[");
          return true;
        }
      }
    }
    return false;
  }

  public static ArrayList<String> reduce (ArrayList<String> c) {
    boolean check = true;
    while (check) {
      check = explode(c);
      if (!check) {
        check = split(c);
      }
    }
    return c;
  }

  public static int magnitude (ArrayList<String> sum) {
    while (sum.size() != 1) {
      for (int i = 0; i < sum.size(); i++) {
        if (sum.get(i).equals("]")) {
          sum.remove(i);
          int two = Integer.parseInt(sum.remove(i-1));
          sum.remove(i-2);
          int three = Integer.parseInt(sum.remove(i-3));
          String s = "";
          s += (two * 2 + three * 3);
          sum.set(i-4,s);
          break;
        }
      }
    }
    return Integer.parseInt(sum.get(0));
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    while (sc.hasNext()) {
      String s = sc.next();
      ArrayList<String> row = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++) {
        row.add("" + s.charAt(i));
      }
      data.add(row);
    }

    int max = 0;
    for (int i = 0; i < data.size(); i++) {
      for (int j = 0; j < data.size(); j++) {
        if (i != j) {
          ArrayList<String> snail1 = data.get(i);
          ArrayList<String> snail2 = data.get(j);
          ArrayList<String> snailnew = new ArrayList<String>();
          snailnew.add("[");
          for (int k = 0; k < snail1.size(); k++) {
            snailnew.add(snail1.get(k));
          }
          snailnew.add(",");
          for (int k = 0; k < snail2.size(); k++) {
            snailnew.add(snail2.get(k));
          }
          snailnew.add("]");
          snailnew = reduce(snailnew);
          int n = magnitude(snailnew);
          if (n > max) {
            max = n;
          }
        }
      }
    }

    System.out.println(max);

  }
}
