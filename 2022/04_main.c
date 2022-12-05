#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

int comp(const void *a,const void *b) {
  int *x = (int *) a;
  int *y = (int *) b;
  return *x - *y;
}

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./04_in.txt", "r");

  char *input = malloc(512);

  int pairs = 0;
  while (fgets(input, 512, file)) {
    char *in = input;
    char *first = strsep(&in, ",");
    char *second = strsep(&in, ",");

    int fLower = atoi(strsep(&first, "-"));
    int fUpper = atoi(strsep(&first, "-"));

    int sLower = atoi(strsep(&second, "-"));
    int sUpper = atoi(strsep(&second, "-"));

    // P2
    int result = 0;

    int sorted[4];
    int fFirst[4];
    int sFirst[4];
    sorted[0] = fLower;
    sorted[1] = fUpper;
    sorted[2] = sLower;
    sorted[3] = sUpper;
    qsort(sorted, 4, sizeof(int), comp);

    fFirst[0] = fLower;
    fFirst[1] = fUpper;
    fFirst[2] = sLower;
    fFirst[3] = sUpper;

    sFirst[0] = sLower;
    sFirst[1] = sUpper;
    sFirst[2] = fLower;
    sFirst[3] = fUpper;

    int i;

    for (i = 0; i < 4; i++) {
      if (sorted[i] != fFirst[i]) {
        result++;
        break;
      }
    }

    for (i = 0; i < 4; i++) {
      if (sorted[i] != sFirst[i]) {
        result++;
        break;
      }
    }

    if (fUpper == sLower || sUpper == fLower) {
      result = 2;
    }

    if (result == 2) {
      pairs++;
    }

    // P1
    // if (fLower <= sLower && fUpper >=sUpper) {
    //   pairs++;
    // } else if (fLower >= sLower && fUpper <=sUpper) {
    //   pairs++;
    // }
  }

  printf("%d\n", pairs);
}
