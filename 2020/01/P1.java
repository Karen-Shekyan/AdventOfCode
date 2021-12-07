import java.util.*;
import java.io.*;

public class P1 {
  public static void main(String[] args) throws IOException{
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data = new ArrayList<String>();
    while (sc.hasNext()) {
      data.add(sc.next());
    }

    int a = 0;
    int b = 0;
    boolean done = false;
    for (int i = 0; i < data.size()-1 && !done; i++) {
      for (int j = i+1; j < data.size() && !done; j++) {
        if (Integer.parseInt(data.get(i)) + Integer.parseInt(data.get(j)) == 2020) {
          done = true;
          a = Integer.parseInt(data.get(i));
          b = Integer.parseInt(data.get(j));
        }
      }
    }

    System.out.println(a*b);
  }
}
