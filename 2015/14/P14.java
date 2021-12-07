import java.util.*;
import java.io.*;

public class P14 {
  public static void main(String[] args) throws IOException {
    File f = new File (args[0]);
    Scanner sc = new Scanner (f);

    int[][] data = new int[9][3]; //ROWS are hard coded.
    int line = 0;
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      String[] words = s.split(" ");
      data[line][0] = Integer.parseInt(words[3]);
      data[line][1] = Integer.parseInt(words[6]);
      data[line][2] = Integer.parseInt(words[13]);
      //System.out.println(Arrays.toString(data[line]));
      line++;
    }

    int[][] race = new int[9][3]; //First index is hard coded.
    //first int in row is the distance. second is internal clock. third is state:
    //0 is running, 1 is resting.
    for (int i = 0; i < race.length; i++) {
      race[i][1] = data[i][1];
    }
    int second = 0;
    while (second <= 2503) { //sample seconds are 1000. file are 2503.
      for (int i = 0; i < race.length; i++) {
        race[i][1]--;
        if (race[i][1] < 0) {
          if (race[i][2] == 0) {
            race[i][2] = 1;
            race[i][1] = data[i][2];
            //race[i][0]+=data[i][0];
            //System.out.println(i);
          }
          else if (race[i][2] == 1) {
            race[i][2] = 0;
            race[i][1] = data[i][1];
          }
        }
        else if (race[i][2] == 0) { //might be just an if statement if they stop resting and run on the same turn.
          race[i][0] += data[i][0];
        }
        System.out.println(Arrays.toString(race[i]));
      }
      second++;
    }

    int ans = 0;
    for (int i = 0; i < race.length; i++) {
      if (race[i][0] > ans) {
        ans = race[i][0];
      }
    }

    System.out.println(ans);
  }
}
