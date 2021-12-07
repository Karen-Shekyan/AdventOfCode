import java.util.*;
import java.io.*;

public class P6 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);
    String s = "";
    while (sc.hasNext()) {
      s+=sc.next();
    }

    String[] data1 = s.split(",");
    ArrayList<Integer> data = new ArrayList<Integer>();
    for (int i = 0; i < data1.length; i++) {
      data.add(Integer.parseInt(data1[i]));
    }

    int day = 0;
    while (day < 80) {
      int newFish = 0;
      for (int i = 0; i < data.size(); i++) {
        data.set(i, data.get(i)-1);
        if (data.get(i) < 0) {
          data.set(i, 6);
          newFish++;
        }
      }
      for (int i = 0; i < newFish; i++) {
        data.add(8);
      }
      day++;
      //System.out.println(day);
    }

    System.out.println(data.size());
  }
}
