#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./01_in.txt", "r");

  char *input = malloc(512);

  int max1 = 0;
  int max2 = 0;
  int max3 = 0;
  int sum = 0;

  while (fgets(input, 512, file)) {
    if (strcmp(input, "\n") == 0) {//newline
      if (sum > max1) {
        max3 = max2;
        max2 = max1;
        max1 = sum;
      } else if (sum > max2) {
        max3 = max2;
        max2 = sum;
      } else if (sum > max3) {
        max3 = sum;
      }

      sum = 0;
    } else {
      int x = atoi(input);
      sum += x;
    }
  }

  printf("%d\n", max1 + max2 + max3);

  return 0;
}
