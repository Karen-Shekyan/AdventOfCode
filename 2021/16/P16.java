import java.util.*;
import java.io.*;

public class P16 {

  public static int vSum = 0;
  public static int i = 0;

  public static int op (String m) {
    //System.out.println(vSum + " " + i);
    vSum += Integer.parseInt(m.substring(i,i+3),2);
    i += 3;
    int type = Integer.parseInt(m.substring(i,i+3),2);
    i += 3;
    if (type != 4) {
      if (m.charAt(i) == '1') {
        i++;
        int l = Integer.parseInt(m.substring(i,i+11),2);
        i += 11;
        int counter = 0;
        while (counter < l) {
          op(m);
          counter++;
          //System.out.println(l);
        }
      }
      else {
        i++;
        int l = Integer.parseInt(m.substring(i,i+15),2);
        i += 15;
        int end = i + l;
        //System.out.println(end);
        while (i < end) {
          op(m);
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
    }
    return 0;
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

    op(m);
    //System.out.println(m.length());
    System.out.println(vSum);
  }
}
