import java.util.*;
import java.io.*;

public class P16_2 {

  public static int vSum = 0;
  public static int i = 0;

  public static long op (String m) {
    //System.out.println(vSum + " " + i);
    ArrayList<Long> p = new ArrayList<Long>();
    vSum += Integer.parseInt(m.substring(i,i+3),2);
    i += 3;
    int type = Integer.parseInt(m.substring(i,i+3),2);
    i += 3;
    if (type != 4) {
      if (m.charAt(i) == '1') {
        i++;
        long l = Long.parseLong(m.substring(i,i+11),2);
        i += 11;
        long counter = 0;
        while (counter < l) {
          p.add(op(m));
          counter++;
          //System.out.println(l);
        }
      }
      else {
        i++;
        long l = Long.parseLong(m.substring(i,i+15),2);
        i += 15;
        long end = i + l;
        //System.out.println(end);
        while (i < end) {
          p.add(op(m));
        }
      }
    }
    else {
      String n = "";
      while (m.charAt(i) != '0') {
        i++;
        n += m.substring(i,i+4);
        i += 4;
      }
      i++;
      n += m.substring(i,i+4);
      i += 4;
      return Long.parseLong(n,2);
    }
    // System.out.println(p);
    // System.out.println(type);
    if (type == 0) {
      long ans = p.get(0);
      for (int k = 1; k < p.size(); k++) {
        ans += p.get(k);
      }
      //System.out.println(ans);
      return ans;
    }

    if (type == 1) {
      long ans = p.get(0);
      for (int k = 1; k < p.size(); k++) {
        ans *= p.get(k);
      }
      return ans;
    }

    if (type == 2) {
      long ans = p.get(0);
      for (int k = 0; k < p.size(); k++) {
        if (p.get(k) < ans) {
          ans = p.get(k);
        }
      }
      return ans;
    }

    if (type == 3) {
      long ans = p.get(0);
      for (int k = 0; k < p.size(); k++) {
        if (p.get(k) > ans) {
          ans = p.get(k);
        }
      }
      return ans;
    }

    if (type == 5) {
      if (p.get(0) > p.get(1)) {
        return 1L;
      }
      else {
        return 0L;
      }
    }

    if (type == 6) {
      if (p.get(0) < p.get(1)) {
        return 1L;
      }
      else {
        return 0L;
      }
    }

    if (type == 7) {
      if (p.get(0).equals(p.get(1))) {
        return 1L;
      }
      else {
        return 0L;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = sc.next();
    String m = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        m += "0000";
      }
      if (s.charAt(i) == '1') {
        m += "0001";
      }
      if (s.charAt(i) == '2') {
        m += "0010";
      }
      if (s.charAt(i) == '3') {
        m += "0011";
      }
      if (s.charAt(i) == '4') {
        m += "0100";
      }
      if (s.charAt(i) == '5') {
        m += "0101";
      }
      if (s.charAt(i) == '6') {
        m += "0110";
      }
      if (s.charAt(i) == '7') {
        m += "0111";
      }
      if (s.charAt(i) == '8') {
        m += "1000";
      }
      if (s.charAt(i) == '9') {
        m += "1001";
      }
      if (s.charAt(i) == 'A') {
        m += "1010";
      }
      if (s.charAt(i) == 'B') {
        m += "1011";
      }
      if (s.charAt(i) == 'C') {
        m += "1100";
      }
      if (s.charAt(i) == 'D') {
        m += "1101";
      }
      if (s.charAt(i) == 'E') {
        m += "1110";
      }
      if (s.charAt(i) == 'F') {
        m += "1111";
      }
    }

    System.out.println(op(m));
    //System.out.println(m.length() + " " + i);
  }
}
