import java.util.*;
import java.io.*;

public class P11_2 {
  public static boolean straight (int[] nums) {
    for (int i = 0; i < nums.length-2; i++) {
      if (nums[i] + 1 == nums[i+1] && nums[i] + 2 == nums[i+2]) {
        return true;
      }
    }
    return false;
  }

  public static boolean noIOL (int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 'i' || nums[i] == 'l' || nums[i] == 'o') {
        return false;
      }
    }
    return true;
  }

  public static boolean twoPairs (int[] nums){
    int pairs = 0;
    for (int i = 0; i < nums.length-1; i++) {
      if (nums[i] == nums[i+1]) {
        pairs++;
        i++;
      }
    }
    return (pairs >= 2);
  }

  public static void main(String[] args) throws IOException {
    char[] input = {'h','e','p','x','x','y','z','z'};
    int[] data = new int[8];
    for (int i = 0; i < data.length; i++) {
      data[i] = (int)input[i];
    }

    boolean done = false;
    while (!done) {
      data[7]++;
      if (data[7] > 122) {
        data[7] = 97;
        data[6]++;
        if (data[6] > 122) {
          data[6] = 97;
          data[5]++;
          if (data[5] > 122) {
            data[5] = 97;
            data[4]++;
            if (data[4] > 122) {
              data[4] = 97;
              data[3]++;
              if (data[3] > 122) {
                data[3] = 97;
                data[2]++;
                if (data[2] > 122) {
                  data[2] = 97;
                  data[1]++;
                  if (data[1] > 122) {
                    data[1] = 97;
                    data[0]++;
                  }
                }
              }
            }
          }
        }
      }

      done = straight(data) && noIOL(data) && twoPairs(data);
    }

    String ans = "";
    for (int i = 0; i < data.length; i++) {
      ans += (char)data[i];
    }
    System.out.println(ans);
  }
}
