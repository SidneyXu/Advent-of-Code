package main

import (
	"fmt"
	"crypto/md5"
	"strings"
	"strconv"
	"encoding/hex"
)

func main() {
	secretKey := "ckczppom"
	findResult(secretKey, "00000")
	findResult(secretKey, "000000")
}

func findResult(secretKey string, strToFind string) {
	i := 1
	for {
		hash := md5.Sum([]byte(secretKey + strconv.Itoa(i)))
		if strings.HasPrefix(hex.EncodeToString(hash[:]), strToFind) {
			fmt.Println("result is", i)
			break
		}
		i++
	}
}