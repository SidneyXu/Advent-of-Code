package main

import (
	"fmt"
	"os"
	"strings"
	"strconv"
	"sort"
	"io/ioutil"
)

func main() {
	f, err := os.Open("input.txt")
	if err != nil {
		panic(err)
	}
	total_wrapping := 0
	total_length := 0

	content, err := ioutil.ReadAll(f)
	lines := strings.Split(string(content), "\n")
	for _, line := range lines {

		lwh := strings.Split(string(line), "x")

		l, _ := strconv.Atoi(lwh[0])
		w, _ := strconv.Atoi(lwh[1])
		h, _ := strconv.Atoi(lwh[2])

		side := []int{l * w, w * h, l * h}
		sort.Ints(side)
		min_side := side[0]
		wrapping := 2 * (l * w + w * h + l * h) + min_side
		total_wrapping += wrapping

		perimeter := []int{2 * (l + w), 2 * (w + h), 2 * (l + h)}
		sort.Ints(perimeter)
		min_perimeter := perimeter[0]
		bow := l * w * h
		total_length += min_perimeter + bow
	}

	fmt.Println(total_wrapping)
	fmt.Println(total_length)
}