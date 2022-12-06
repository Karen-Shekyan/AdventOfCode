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

void debugPrint(char arr[], int len) {
  int i;
  for (i = 0; i < len; i++) {
    printf("%c", arr[i]);
  }
  printf("\n");
}

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./06_in.txt", "r");

  char *input = malloc(4096);

  while (fgets(input, 4096, file)) {
    char *in = input;
    int len = strlen(in);

    // P2
    char lastFourteen[14];
    int i, j, k;
    for (i = 0; i < 14; i++) {
      lastFourteen[i] = in[i];
    }

    for (i = 14; i < len; i++) {
      for (j = 0; j < 13; j++) {
        lastFourteen[j] = lastFourteen[j+1];
      }
      lastFourteen[13] = in[i];

      int diff = 1;
      for (j = 0; j < 13; j++) {
        for (k = j+1; k < 14; k++) {
          if (lastFourteen[j] == lastFourteen[k]) {
            diff = 0;
          }
        }
      }

      if (diff) {
        printf("%d\n", i + 1);
        return 0;
      }
    }

    // P1
    // char lastFour[4];
    // lastFour[0] = in[0]; //oldest
    // lastFour[1] = in[1];
    // lastFour[2] = in[2];
    // lastFour[3] = in[3]; //newest
    // int i, j, k;
    // for (i = 4; i < len; i++) {
    //   // printf("\n\n%c %c %c %c\n", in[i], in[i+1], in[i+2], in[i+3]);
    //   for (j = 0; j < 3; j++) {
    //     lastFour[j] = lastFour[j+1];
    //   }
    //   lastFour[3] = in[i];
    //
    //   int diff = 1;
    //   for (j = 0; j < 3; j++) {
    //     for (k = j+1; k < 4; k++) {
    //       // printf("%c %c, ", lastFour[j], lastFour[k]);
    //       if (lastFour[j] == lastFour[k]) {
    //         diff = 0;
    //       }
    //     }
    //   }
    //
    //   if (diff) {
    //     printf("%d\n", i + 1);
    //     return 0;
    //   }
    // }
  }

  return 0;
}
