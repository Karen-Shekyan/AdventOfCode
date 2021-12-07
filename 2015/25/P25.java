import java.util.*;
import java.io.*;

public class P25 {
  public static void main(String[] args) throws IOException {
    int r = 2978;
    int c = 3083;

    int start = 0;
    for (int i = 1; i <= c; i++) {
      start += i;
    }

    int p = start;
    for (int i = 0; i < r-1; i++) {
      p += c + i;
    }

    long ans = 20151125;
    for (int i = 1; i < p; i++) {
      ans *= 252533;
      ans %= 33554393;
    }

    System.out.println(ans);
  }
}
