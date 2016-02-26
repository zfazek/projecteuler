#include "predicate.h"

int multiply_by(int n, int d) {
    if (n % d == 0) {
        return 1;
    } else {
        return 0;
    }
}

int even(int n) {
    return multiply_by(n, 2);
}

int odd(int n) {
    return 1 - multiply_by(n, 2);
}

int multiply_by_three(int n) {
    return multiply_by(n, 3);
}

int multiply_by_five(int n) {
    return multiply_by(n, 5);
}

int multiply_by_three_or_five(int n) {
    return multiply_by_three(n) || multiply_by_five(n);
}

