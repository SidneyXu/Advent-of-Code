package main

import (
	"fmt"
	"os"
	"io/ioutil"
)

func main() {
	f, err := os.Open("input.txt")
	if err != nil {
		panic(err)
	}

	houses := make(map[[2]int]int)
	current_location := [2]int{}
	content, err := ioutil.ReadAll(f)
	for _, v := range content {
		switch v {
		case '^':
			current_location[1]++
		case 'v':
			current_location[1]--
		case '>':
			current_location[0]++
		case '<':
			current_location[0]--
		}
		houses[current_location]++
	}
	fmt.Println(len(houses))

	houses = make(map[[2]int]int)
	santa := [2]int{}
	robot := [2]int{}
	for i, v := range content {
		var location *[2]int

		if i % 2 == 0 {
			location = &santa
		}else {
			location = &robot
		}

		switch v {
		case '^':
			location[1]++
		case 'v':
			location[1]--
		case '>':
			location[0]++
		case '<':
			location[0]--
		}
		houses[*location]++
	}
	fmt.Println(len(houses))
}