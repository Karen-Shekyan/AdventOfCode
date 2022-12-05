compile: main.o
	gcc -Wall -o out $(ARGS)_main.o

run: out
	./out

main.o: $(ARGS)_main.c
	gcc -c $(ARGS)_main.c

clean:
	rm *.o out
