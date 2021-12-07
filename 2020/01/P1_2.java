import java.util.*;
import java.io.*;

public class P1_2 {
  public static void main(String[] args) throws IOException{
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data = new ArrayList<String>();
    while (sc.hasNext()) {
      data.add(sc.next());
    }

    int a = 0;
    int b = 0;
    int c = 0;
    boolean done = false;
    for (int i = 0; i < data.size()-2 && !done; i++) {
      for (int j = i+1; j < data.size()-1 && !done; j++) {
        for (int k = j+1; k < data.size() && !done; k++) {
          if (Integer.parseInt(data.get(i)) + Integer.parseInt(data.get(j)) + Integer.parseInt(data.get(k)) == 2020) {
            done = true;
            a = Integer.parseInt(data.get(i));
            b = Integer.parseInt(data.get(j));
            c = Integer.parseInt(data.get(k));
          }
        }
      }
    }

    System.out.println(a*b*c);
  }
}
