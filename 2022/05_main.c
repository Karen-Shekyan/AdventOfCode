#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#define MAX(x, y) (((x) > (y)) ? (x) : (y))
#define MIN(x, y) (((x) < (y)) ? (x) : (y))
#define push(sp, n) (*((sp)++) = (n))
#define pop(sp) (*--(sp))

int main(int argc, char const *argv[]) {

  FILE * file = fopen("./05_in.txt", "r");

  char *input = malloc(512);

  int stackEX[1000];

  // EXAMPLE CODE:
  int *sp;

  {
      sp = stackEX; /* initialize */

      push(sp, 10);
      int x = pop(sp);
  }
  //

  char *one;
  char *two;
  char *three;
  char *four;
  char *five;
  char *six;
  char *seven;
  char *eight;
  char *nine;

  char o[500];
  char t[500];
  char th[500];
  char f[500];
  char fi[500];
  char s[500];
  char se[500];
  char e[500];
  char n[500];

  one = o;
  two = t;
  three = th;
  four = f;
  five = fi;
  six = s;
  seven = se;
  eight = e;
  nine = n;

  push(one, 'W');
  push(one, 'M');
  push(one, 'L');
  push(one, 'F');

  push(two, 'B');
  push(two, 'Z');
  push(two, 'V');
  push(two, 'M');
  push(two, 'F');

  push(three, 'H');
  push(three, 'V');
  push(three, 'R');
  push(three, 'S');
  push(three, 'L');
  push(three, 'Q');

  push(four, 'F');
  push(four, 'S');
  push(four, 'V');
  push(four, 'Q');
  push(four, 'P');
  push(four, 'M');
  push(four, 'T');
  push(four, 'J');

  push(five, 'L');
  push(five, 'S');
  push(five, 'W');

  push(six, 'F');
  push(six, 'V');
  push(six, 'P');
  push(six, 'M');
  push(six, 'R');
  push(six, 'J');
  push(six, 'W');

  push(seven, 'J');
  push(seven, 'Q');
  push(seven, 'C');
  push(seven, 'P');
  push(seven, 'N');
  push(seven, 'R');
  push(seven, 'F');

  push(eight, 'V');
  push(eight, 'H');
  push(eight, 'P');
  push(eight, 'S');
  push(eight, 'Z');
  push(eight, 'W');
  push(eight, 'R');
  push(eight, 'B');

  push(nine, 'B');
  push(nine, 'M');
  push(nine, 'J');
  push(nine, 'C');
  push(nine, 'G');
  push(nine, 'H');
  push(nine, 'Z');
  push(nine, 'W');

  char *stacks[9];
  stacks[0] = one;
  stacks[1] = two;
  stacks[2] = three;
  stacks[3] = four;
  stacks[4] = five;
  stacks[5] = six;
  stacks[6] = seven;
  stacks[7] = eight;
  stacks[8] = nine;

  while (fgets(input, 512, file)) {
    // P2
    char *in = input;
    int amount, from, to;
    sscanf(in, "move %d from %d to %d", &amount, &from, &to);
    // printf("%d %d %d\n", amount, from, to);

    char Tstack[500];
    char *temp = Tstack;

    int i;
    for (i = 0; i < amount; i++) {
      char rm = pop(stacks[from-1]);
      push(temp, rm);
    }

    for (i = 0; i < amount; i++) {
      char rm = pop(temp);
      push(stacks[to-1], rm);
    }

    // P1
    // char *in = input;
    // int amount, from, to;
    // sscanf(in, "move %d from %d to %d", &amount, &from, &to);
    // // printf("%d %d %d\n", amount, from, to);
    //
    // int i;
    // for (i = 0; i < amount; i++) {
    //   char rm = pop(stacks[from-1]);
    //   push(stacks[to-1], rm);
    // }
  }

  int i;
  for (i = 0; i < 9; i++) {
    printf("%c", pop(stacks[i]));
  }
  printf("\n");

  return 0;
}
