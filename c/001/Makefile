CFLAGS = -g -O2

OBJS = problem001.o \
	   linked_list.o \
	   predicate.o

DEPS = linked_list.h \
	   predicate.h

a.out: $(OBJS)
	$(CC) $(CFLAGS) -o $@ $(OBJS)

$(OBJS): $(DEPS)

clean:
	rm -f *.o a.out

.PHONY: clean
