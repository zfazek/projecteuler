#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int a;
    struct Node* next;
} Node;

int getNode(const Node* const node) {
    if (node) {
        return node->a;
    }
    return 0;
}

void print(const Node* const n) {
    const Node* node = n;
    while (node) {
        printf("%d\n", getNode(node));
        node = node->next;
    }
}

Node* init() {
    return NULL;
}

void release(Node** n) {
    Node* node = *n;
    while(node) {
        Node* old_node = node;
        node = node->next;
        free(old_node);
    }
    *n = NULL;
}

void append(Node** n, int item) {
    Node* node = *n;
    Node* head = node;
    while (node && node->next) {
        node = node->next;
    }
    Node* new_node = (Node*)malloc(sizeof(Node));
    if (new_node) {
        new_node->a = item;
        new_node->next = NULL;
        if (node) {
            node->next = new_node;
            *n = head;
        } else {
            *n = new_node;
        }
    }
}

void filter(Node** n, int (*p)(int item)) {
    Node* node = *n;
    Node* head = node;
    Node* prev = NULL;
    while (node) {
        if (! (*p)(node->a)) {
            Node* old_node = node;
            if (node == head) {
                head = head->next;
            } else {
                prev->next = node->next;
            }
            node = node->next;
            free(old_node);
        } else {
            prev = node;
            node = node->next;
        }
    }
    *n = head;
}

int sum(const Node* const n) {
    const Node* node = n;
    int ret = 0;
    while (node) {
        ret += getNode(node);
        node = node->next;
    }
    return ret;
}

