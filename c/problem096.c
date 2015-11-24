#include <stdio.h>
#include <string.h>

#define TRUE 1
#define FALSE 0

const int X_SIZE = 9;
const int Y_SIZE = 9;
int r[9][9];
int found;
int puzzle = 0;

void print_sudoku(int s[9][9]) {
    int x, y;
    printf("%d. puzzle\n", puzzle);
    for (y = 0; y < 9; y++) {
        for (x = 0; x < 9; x++) {
            printf("%d", s[y][x]);
            if (x % 3 == 2) printf(" ");
        }
        if (y % 3 == 2) printf("\n");
        printf("\n");
    }
    printf("\n");
}

int is_correct(int s[9][9], int x, int y) {
    int i, j;
    int xx = 3 * (x / 3);
    int yy = 3 * (y / 3);
    int n = s[y][x];
    for (i = 0; i < 9; i++) {
        if (i != x && s[y][i] == n)
            return FALSE;
    }
    for (i = 0; i < 9; i++) {
        if (i != y && s[i][x] == n)
            return FALSE;
    }
    for (i = yy; i < yy + 3; i++) {
        for (j = xx; j < xx + 3; j++) {
            if ( ! (j == x && i == y)) {
                if (s[i][j] == n)
                    return FALSE;
            }
        }
    }
    return TRUE;
}

void solve_sudoku(int s[9][9], int x, int y) {
    int sum = 0;
    int n;
    if (s[y][x] == 0) {
        for (n = 1; n <= 9; n++) {
            if (found == FALSE) {
                s[y][x] = n;
                if (is_correct(s, x, y)) {
                    if (x < X_SIZE - 1) {
                        solve_sudoku(s, x + 1, y);
                    } else if (y < Y_SIZE - 1) {
                        solve_sudoku(s, 0, y + 1);
                    } else {
                        memcpy(r, s, 81 * sizeof(int));
                        found = TRUE;
                        return;
                    }
                }
            }
        }
        s[y][x] = 0;
    } else if (x < X_SIZE - 1) {
        solve_sudoku(s, x + 1, y);
    } else if (y < Y_SIZE - 1) {
        solve_sudoku(s, 0, y + 1);
    } else {
        memcpy(r, s, 81 * sizeof(int));
        found = TRUE;
    }
}

int main() {
    int i, j;
    int sum = 0;
    const int LINE_SIZE = 256;
    int n = 0;
    int s[9][9];
    char line[LINE_SIZE];
    FILE *f = fopen("sudoku.txt", "r");
    if (f) {
        while (fgets(line, LINE_SIZE, f)) {
            if (line[0] != 'G') {
                for (i = 0; i < 9; i++) {
                    s[n-1][i] = line[i] - '0';
                }
            }
            if (++n % 10 == 0) {
                ++puzzle;
                if (puzzle <= 100) {
                    found = FALSE;
                    //print_sudoku(s);
                    solve_sudoku(s, 0, 0);
                    //print_sudoku(r);
                    sum += 100*r[0][0]+10*r[0][1]+r[0][2];
                }
                n = 0;
                //break;
            }
        }
        fclose(f);
    }
    printf("%d\n", sum);


}
