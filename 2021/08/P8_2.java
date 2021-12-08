import java.util.*;
import java.io.*;

public class P8_2 {

  public static int sharedWithFour (String s, String four) {
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      if (four.contains(""+s.charAt(i))) {
        ans++;
      }
    }
    return ans;
  }


  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    ArrayList<String> data1 = new ArrayList<String> ();
    while (sc.hasNextLine()) {
      data1.add(sc.nextLine());
    }
    String[][][] data = new String[data1.size()][2][];
    for (int i = 0; i < data.length; i++) {
      String s = data1.get(i);
      String in = s.substring(0,s.indexOf("|"));
      String out = s.substring(s.indexOf("|")+2);
      data[i][0] = in.split(" ");
      data[i][1] = out.split(" ");
    }

    long ans = 0;

    for (int i = 0; i < data.length; i++) {
      String[] key = new String[4];
      //string that is 1, 7, 3, and 4
      for (int j = 0; j < data[i][0].length; j++) {
        for (int k = 0; k < data[i][0].length-1;k++) {
          if (data[i][0][k].length() > data[i][0][k+1].length()) {
            String temp = data[i][0][k];
            data[i][0][k] = data[i][0][k+1];
            data[i][0][k+1] = temp;
          }
        }
      }
      //now ordered as [1,7,4,(2|3|5),(0|6|9),8]
      String r1 = "";
      String r2 = "";
      key[0] = data[i][0][0];
      key[1] = data[i][0][1];
      key[3] = data[i][0][2];
      for (int j = 0; j < data[i][0][0].length(); j++) {
        if (data[i][0][1].contains(""+data[i][0][0].charAt(j)) && r1.equals("")) {
          r1 = ""+data[i][0][0].charAt(j);
        }
        else if (data[i][0][1].contains(""+data[i][0][0].charAt(j))) {
          r2 = ""+data[i][0][0].charAt(j);
        }
      }

      for (int j = 3; j < 6; j++) {
        if (data[i][0][j].contains(r1) && data[i][0][j].contains(r2)) {
          key[2] = data[i][0][j];
        }
      }
      //System.out.println(Arrays.toString(key));

      String num = "";
      for (int j = 0; j < data[i][1].length; j++) {
        String code = data[i][1][j];
        if (code.length() == 2) {
          num += "1";
        }
        if (code.length() == 3) {
          num += "7";
        }
        if (code.length() == 4) {
          num += "4";
        }
        if (code.length() == 5) {//check 3, else check 2
          if (code.contains(key[0].substring(1)) && code.contains(key[0].substring(0,1))) {
            num += "3";
          }
          else if (sharedWithFour(code, key[3]) == 2) {
            num += "2";
          }
          else {
            num += "5";
          }
        }
        if (code.length() == 6) {//check 9, else check 6
          if (!(code.contains(key[0].substring(1)) && code.contains(key[0].substring(0,1)))) {
            num += "6";
          }
          else if (sharedWithFour(code, key[3]) == 4) {
            num += "9";
          }
          else {
            num += "0";
          }
        }
        if (code.length() == 7) {
          num += "8";
        }
      }
      ans += Integer.parseInt(num);
      System.out.println(num);
    }

    System.out.println(ans);
  }
}
