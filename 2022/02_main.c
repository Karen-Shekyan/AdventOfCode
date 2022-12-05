#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./02_in.txt", "r");

  char *input = malloc(512);

  int score = 0;

  while (fgets(input, 512, file)) {
    char *in = input;
    int opp = strsep(&in, " ")[0];
    int self = strsep(&in, " ")[0];
    // printf("%d %d\n", opp, self);

    opp -= 65;
    self -= 88;
    //0 = rock, 1 = paper, 2 = scissors

    // P2
    score += self * 3;

    if (self == 2) {
      score += (opp + 1) % 3 + 1;
    } else if (self == 1) {
      score += opp + 1;
    } else if (self == 0) {
      opp--;
      if (opp == -1) {
        opp = 2;
      }

      score += opp + 1;
    }

    //P1
    // score += self + 1;
    //
    // if (opp == self) {
    //   score += 3;
    // } else if (self == (opp + 1) % 3) {
    //   score += 6;
    // }
  }
  printf("%d\n", score);

  return 0;
}
