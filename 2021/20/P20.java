import java.util.*;
import java.io.*;

public class P20 {

  public static void pad(ArrayList<ArrayList<String>> image) {
    String background = image.get(0).get(0);
    for (int i = 0; i < 3; i++) {
      ArrayList<String> paddingT = new ArrayList<String>();
      ArrayList<String> paddingB = new ArrayList<String>();
      for (int j = 0; j < image.get(0).size(); j++) {
        paddingT.add(background);
        paddingB.add(background);
      }
      image.add(0,paddingT);
      image.add(paddingB);
    }

    for (int i = 0; i < image.size(); i++) {
      for (int j = 0; j < 3; j++) {
        image.get(i).add(0,background);
        image.get(i).add(background);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    String key = sc.next();
    ArrayList<ArrayList<String>> image = new ArrayList<ArrayList<String>>();
    while (sc.hasNext()) {
      String s = sc.next();
      ArrayList<String> row = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++) {
        row.add(""+s.charAt(i));
      }
      //System.out.println(row);
      image.add(row);
    }

    for (int i = 0; i < 3; i++) {
      ArrayList<String> paddingT = new ArrayList<String>();
      ArrayList<String> paddingB = new ArrayList<String>();
      for (int j = 0; j < image.get(0).size(); j++) {
        paddingT.add(".");
        paddingB.add(".");
      }
      image.add(0,paddingT);
      image.add(paddingB);
    }

    for (int i = 0; i < image.size(); i++) {
      for (int j = 0; j < 3; j++) {
        image.get(i).add(0,".");
        image.get(i).add(".");
      }
    }

    int steps = 0;
    while (steps < 50) {
      System.out.println(steps);
      ArrayList<ArrayList<String>> newImage = new ArrayList<ArrayList<String>>();
      for (int r = 1; r < image.size()-1; r++) {
        ArrayList<String> newRow = new ArrayList<String>();
        for (int c = 1; c < image.get(0).size()-1; c++) {
          String binary = "";
          for (int ri = -1; ri <= 1; ri++) {
            for (int ci = -1; ci <= 1; ci++) {
              if (image.get(r+ri).get(c+ci).equals("#")) {
                binary += "1";
              }
              else {
                binary += "0";
              }
            }
          }
          int index = Integer.parseInt(binary,2);
          newRow.add(""+key.charAt(index));
        }
        newImage.add(newRow);
      }
      image = newImage;
      pad(image);
      steps++;
    }

    int ans = 0;
    for (int i = 0; i < image.size(); i++) {
      for (int j = 0 ; j < image.get(0).size(); j++) {
        if (image.get(i).get(j).equals("#")) {
          ans++;
        }
      }
    }

    System.out.println(ans);
  }
}
