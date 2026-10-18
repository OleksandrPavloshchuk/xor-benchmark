package main

import (
	"fmt"
	"io"
	"os"
)

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Key is needed")
		os.Exit(1)
	}
	key := os.Args[1]
	keyLen := len(key)

	buf := make([]byte, 8*1024)

	keyIndex := 0

	in := os.Stdin
	out := os.Stdout

	for true {
		var nRead = 0
		if nRead, err := io.ReadFull(in, buf); err != nil && nRead == 0 {
			break
		}
		for i := 0; i < nRead; i++ {
			buf[i] ^= key[keyIndex]
			keyIndex++
			if keyIndex == keyLen {
				keyIndex = 0
			}
		}
		_, _ = out.Write(buf)
	}

}
