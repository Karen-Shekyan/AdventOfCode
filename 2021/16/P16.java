import java.util.*;
import java.io.*;

public class P16 {

  public static String[] op0 (String m, String vSum) {
    int l = Integer.parseInt(m.substring(0,15),2);//recusion. think about what to do
    m = m.substring(15);                          //with that.
    int v = Integer.parseInt(m.substring(0,3),2);
    m = m.substring(3);
    int newV = v + Integer.parseInt(vSum);
    vSum = newV;
    int t = Integer.parseInt(m.substring(0,3),2);
    m = m.substring(0,3);

  }

  public static String[] op1 (String m, String vSum) {
    int l = Integer.parseInt(m.substring(0,11),2);
    m = m.substring(11);
  }

  public static String[] lit (String m, String ans) {
    if (m.charAt(0) == '0') {
      String group = m.substring(1,5);
      int d = Integer.parseInt(group,2);
      ans += d;
      m = m.substring(5);
      while (m.charAt(0) == '0') {
        m.substring(1);
      }
      String[] arr = {m, ans};
      return arr;
    }
    else {
      String group = m.substring(1,5);
      m = m.substring(5);
      int d = Integer.parseInt(group,2);
      ans += d;
      return lit(m,ans);
    }
  }

  public static int versionSum(String m) {
    int vSum = 0;
    while (m.length() != 0) {
      String v = m.substring(0,3);
      vSum += Integer.parseInt(v,2);
      m = m.substring(3);
      String t = m.substring(0,3);
      int type = Integer.parseInt(t,2);
      m = m.substring(3);
      if (type != 4) {
        int i = Integer.parseInt(m.substring(0,1));
        m = m.substring(1);
        if (i == 0) {
          String tempV = "" + vSum;
          String[] data = op0(m,tempV);
          m = data[0];
          vSum = Integer.parseInt(data[1]);
        }
        else {
          String tempV = "" + vSum;
          String[] data = op1(m,tempV);
          m = data[0];
          vSum = Integer.parseInt(data[1]);
        }
      }
      else {
        String[] data = lit(m,"");
        m = data[0];
      }
    }
    return vSum;
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

    System.out.println(versionSum(m));
  }
}
