#pragma once

typedef struct Node {
    int a;
    struct Node* next;
} Node;

int getNode(const Node* const node);

void print(const Node* const n);

Node* init();

void release(Node** n);

void append(Node** n, int item);

int sum(const Node* const n);

void filter(Node** n, int (*p)(int item));
