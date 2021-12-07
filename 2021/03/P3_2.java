import java.util.*;
import java.io.*;

public class P3_2 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data = new ArrayList<String> ();
    ArrayList<String> datac = new ArrayList<String> ();
    ArrayList<String> dataC = new ArrayList<String> ();

    while (sc.hasNext()) {
      data.add(sc.next());
    }

    int[] ones = new int[data.get(0).length()];
    for (int i = 0; i < data.size(); i++) {
      for (int j = 0; j < ones.length; j++) {
        if (data.get(i).charAt(j) == '1') {
          ones[j]++;
        }
      }
      datac.add(data.get(i));
      dataC.add(data.get(i));
    }

    int[] onesc = new int[ones.length];
    int[] onesC = new int[ones.length];
    for (int i = 0; i < ones.length; i++) {
      onesc[i] = ones[i];
      onesC[i] = ones[i];
    }

    //System.out.println(Arrays.toString(ones));

    int digit = 0;
    while (datac.size() != 1) {
      for (int i = 0; i < datac.size(); i++) {
        String s = datac.get(i);
        int[] removal = new int[ones.length];
        if ((s.charAt(digit) == '1' && onesc[digit] < datac.size()-onesc[digit]) || (s.charAt(digit) == '0' && onesc[digit] >= datac.size()-onesc[digit])) {
          for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
              removal[j]++;
              //System.out.println(onesc[j]);
            }
          }
          if (datac.size() != 1) {
            datac.remove(i);
          }
          else {
            break;
          }
          i--;
        }
        for (int j = 0; j < ones.length; j++) {
          onesc[j] -= removal[j];
        }
      }
      // System.out.println(datac.size());
      // System.out.println(Arrays.toString(onesc));
      digit++;
    }
    //System.out.println(digit);
    //System.out.println(datac);


    System.out.println(dataC);
    System.out.println(Arrays.toString(onesC));
    digit = 0;
    while (dataC.size() != 1) {
      int[] removal = new int[ones.length];
      int size = dataC.size();
      for (int i = 0; i < dataC.size(); i++) {
        String s = dataC.get(i);
        if ((s.charAt(digit) == '1' && onesC[digit] >= size-onesC[digit]) || (s.charAt(digit) == '0' && onesC[digit] < size-onesC[digit])) {
          System.out.println(dataC.get(i) + " " + digit);
          for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
              removal[j]++;
              //onesC[j]--;
              System.out.println(j + " " + onesC[j]);
            }
          }
          if (dataC.size() != 1) {
            dataC.remove(i);
          }
          else {
            break;
          }
          i--;
        }
      }
      for (int j = 0; j < ones.length; j++) {
        onesC[j] -= removal[j];
      }
      System.out.println(dataC);
      System.out.println(Arrays.toString(onesC));
      digit++;
    }

    //System.out.println(digit);
    //System.out.println(Arrays.toString(ones));
    System.out.println(datac);
    System.out.println(dataC);
    String as = datac.get(0);
    String bs = dataC.get(0);
    int a = 0;
    int b = 0;

    for (int i = 0; i < ones.length; i++) {
      if (as.charAt(i) == '1') {
        a += (int)Math.pow(2,ones.length-1-i);
      }
      if (bs.charAt(i) == '1') {
        b += (int)Math.pow(2,ones.length-1-i);
      }
    }

    System.out.println(a + " " + b);
    System.out.println(a*b);
  }
}
