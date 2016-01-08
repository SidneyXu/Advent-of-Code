package main

import (
	"fmt"
	"os"
	"io/ioutil"
)

const (
	left = byte('(')
	right = byte(')')
)

func main() {
	f, err := os.Open("input.txt")
	if err != nil {
		panic(err)
	}
	floor := 0
	pos := 0
	found := false
	content, err := ioutil.ReadAll(f)
	for _, v := range content {
		if !found && floor != -1 {
			pos++
		}else if floor == -1 {
			found = true
		}
		if v == left {
			floor++
		}else if v == right {
			floor--
		}
	}
	fmt.Println(floor)
	fmt.Println(pos)
}