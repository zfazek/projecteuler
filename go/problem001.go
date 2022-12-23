package main

import (
	"fmt"
)

func main() {
	n := 0
    for i := 0; i < 10000; i++ {
		if i %3 == 0 || i%5 == 0 {
			n += i
		}
	}
	fmt.Println(n)
}
