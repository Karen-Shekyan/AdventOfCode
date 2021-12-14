import java.util.*;
import java.io.*;

public class P14 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String s = sc.nextLine();
    sc.nextLine();
    ArrayList<String[]> data = new ArrayList<String[]> ();
    int count = 0;
    while (sc.hasNextLine()) {
      String st = sc.nextLine();
      data.add(st.split(" -> "));
      // System.out.println(Arrays.toString(data.get(count)));
      // count++;
    }

    ArrayList<Character> poly = new ArrayList<Character> ();
    for (int i = 0; i < s.length(); i++) {
      poly.add(s.charAt(i));
    }
    //System.out.println(poly);

    int step = 0;
    while (step < 10) {
      for (int i = 0; i < poly.size()-1; i+=2) {
        String pair = "";
        pair += poly.get(i) + "" + poly.get(i+1);
        for (int j = 0; j < data.size(); j++) {
          //System.out.println(pair);
          if (pair.equals(data.get(j)[0])) {
            poly.add(i+1,data.get(j)[1].charAt(0));
          }
        }
      }
      step++;
    }
    //System.out.println(poly.size());

    int max = 0;
    int min = 1000000;
    ArrayList<Character> elements = new ArrayList<Character> ();
    for (int i = 0; i < poly.size(); i++) {
      if (!elements.contains(poly.get(i))) {
        elements.add(poly.get(i));
      }
    }
    //System.out.println(elements);
    for (int i = 0; i < elements.size(); i++) {
      int n = 0;
      for (int j = 0; j < poly.size(); j++) {
        if (poly.get(j) == elements.get(i)) {
          n++;
        }
      }
      if (n > max) {
        max = n;
      }
      if (n < min) {
        min = n;
      }
    }

    System.out.println(max - min);

  }
}
