import java.util.*;
import java.io.*;

public class Wrapper {

  public static int findSA (int[] sides) {
    int ans = 0;
    for (int i = 0; i < sides.length-1; i++) {
      for (int j = i+1; j < sides.length; j++) {
        ans += sides[i] * sides[j];
      }
    }
    ans *= 2;

    for (int i = 0; i < sides.length; i++) {
      for (int j = 0; j < sides.length-1; j++) {
        if (sides[j] > sides[j+1]) {
          int temp = sides[j];
          sides[j] = sides[j+1];
          sides[j+1] = temp;
        }
      }
    }

    ans += sides[0]*sides[1];
    return ans;
  }

  public static int findRibbon (int[] sides) {
    int ans = sides[0]*sides[1]*sides[2];
    int p1 = sides[0]*2 + sides[1]*2;
    int p2 = sides[2]*2 + sides[1]*2;
    int p3 = sides[0]*2 + sides[2]*2;
    if (p1 <= p2 && p1 <= p3) {
      ans += p1;
    }
    else if (p2 <= p1 && p2 <= p3) {
      ans += p2;
    }
    else if (p3 <= p2 && p3 <= p1) {
      ans += p3;
    }
    return ans;
  }

  public static void main(String[] args) {

    try {
      File f = new File(args[0]);
      Scanner input = new Scanner(f);

      int surface = 0;
      int ribbon = 0;

      while (input.hasNextLine()) {
        String[] box = input.nextLine().split("x");
        int[] sides = new int[box.length];
        for (int i = 0; i < box.length; i++) {
          sides[i] = Integer.parseInt(box[i]);
        }
        surface += findSA(sides);
        ribbon += findRibbon(sides);
      }

      if (args[1].equals("1")) {
        System.out.println(surface);
      }
      if (args[1].equals("2")) {
        System.out.println(ribbon);
      }
    }
    catch (FileNotFoundException ex) {

    }

  }
}
