import java.util.*;
import java.io.*;

public class P14_2 {
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

    ArrayList<String> pairs = new ArrayList<String> ();
    for (int i = 0; i < data.size(); i++) {
      pairs.add(data.get(i)[0]);
    }
    //System.out.println(pairs);

    long[] countPairs = new long[pairs.size()];
    for (int i = 0; i < s.length()-1; i++) {
      String p = s.substring(i,i+2);
      for (int j = 0; j < pairs.size(); j++) {
        if (p.equals(pairs.get(j))) {
          countPairs[j]++;
        }
      }
    }

    //System.out.println(Arrays.toString(countPairs));

    ArrayList<String> elements = new ArrayList<String> ();
    for (int i = 0; i < data.size(); i++) {
      if (!elements.contains(data.get(i)[1])) {
        elements.add(data.get(i)[1]);
      }
    }
    //System.out.println(elements); //++++++++++

    long[] letters = new long[elements.size()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < elements.size(); j++) {
        if (s.charAt(i) == elements.get(j).charAt(0)) {
          letters[j]++;
        }
      }
    }
    //System.out.println(Arrays.toString(letters)); //++++++++++

    int step = 0;
    while (step < 40) {
      long[] cloneCount = new long[countPairs.length];
      for (int k = 0; k < countPairs.length; k++) {
        cloneCount[k] = countPairs[k];
      }
      for (int i = 0; i < countPairs.length; i++) {

        //System.out.println(Arrays.toString(cloneCount));

        if (cloneCount[i] > 0) {
          long num = cloneCount[i];
          //System.out.println(num);
          countPairs[i] -= num;
          String c = "";
          for (int j = 0; j < data.size(); j++) {
            if (data.get(j)[0].equals(pairs.get(i))) {
              c = data.get(j)[1];
            }
          }

          for (int k = 0; k < elements.size(); k++) {
            if (elements.get(k).equals(c)) {
              letters[k] += num;
            }
          }

          String n1 = pairs.get(i).substring(0,1) + c;
          String n2 = c + pairs.get(i).substring(1);
          for (int j = 0; j < pairs.size(); j++) {
            if (pairs.get(j).equals(n1)) {
              countPairs[j] += num;
            }
            if (pairs.get(j).equals(n2)) {
              countPairs[j] += num;
            }
          }

        }
      }
      step++;
    }

    //System.out.println(Arrays.toString(letters));
    Arrays.sort(letters);

    System.out.println(letters[letters.length-1] - letters[0]);
  }
}
