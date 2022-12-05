#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./03_in.txt", "r");

  char *input = malloc(512);

  int sum = 0;
  while (fgets(input, 512, file)) {
    // P1
    // int len = 0;
    // int i = 0;
    // while (input[i] != '\n') {
    //   len++;
    //   i++;
    // }
    //
    // char duplicate;
    // int j;
    // int done = 0;
    // for (i = 0; !done && i < len/2; i++) {
    //   char first = input[i];
    //   for (j = len/2; !done && j < len; j++) {
    //     char second = input[j];
    //     if (first == second) {
    //       duplicate = first;
    //       done = 1;
    //     }
    //   }
    // }

    // P2
    char *bag1 = malloc(512);
    strcpy (bag1, input);

    fgets(input, 512, file);
    char *bag2 = malloc(512);
    strcpy (bag2, input);

    fgets(input, 512, file);
    char *bag3 = malloc(512);
    strcpy (bag3, input);

    char duplicate;
    int done = 0;
    int i, j, k;
    for (i = 0; !done && bag1[i] != '\n'; i++) {
      char first = bag1[i];
      for (j = 0; !done && bag2[j] != '\n'; j++) {
        char second = bag2[j];
        for (k = 0; !done && bag3[k] != '\n'; k++) {
          char third = bag3[k];
          if (first == second && first == third) {
            duplicate = first;
            done = 1;
          }
        }
      }
    }

    int value = 0;
    if ((int)duplicate <= 90) {
      value = (int)duplicate - 38;
    } else {
      value = (int) duplicate - 96;
    }

    // printf("%s\n%s\n%s\n\n", bag1, bag2, bag3);

    // printf("%s\n", input);
    // printf("%c %d\n", duplicate, value);
    // printf("%d %d\n\n", i, j);

    sum += value;
  }

  printf("%d\n", sum);
  fclose(file);
}
