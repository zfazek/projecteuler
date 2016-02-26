#include "linked_list.h"
#include "predicate.h"
#include <stdio.h>

int main(int argc, char* argv[]) {
    int i;
    Node* list = init();
    for (i = 1; i < 1000; i++) {
        append(&list, i);
    }
    filter(&list, multiply_by_three_or_five);
    printf("sum: %d\n", sum(list));
    release(&list);
    return 0;
}
