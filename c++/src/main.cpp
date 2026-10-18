/**
 * main.cpp
 */

 #include <iostream>
 #include <string.h>
 #include <unistd.h>

 int main(int argc, char **argv) {
        if (argc < 2) {
            std::cerr << "Key is needed" << std::endl;
            return 1;
        }

        char buf[8 * 1024];

        int keyIndex = 0;
        int nRead;

        const int IN = 0;
        const int OUT = 1;

        const char *key = argv[1];
        const int keyLen = strlen(key);

        while((nRead = read(IN, buf, sizeof(buf))) > NULL) {
            for (int i = 0; i < nRead; i++) {
                buf[i] ^= key[keyIndex];
                if (++keyIndex == keyLen) {
                    keyIndex = 0;
                }
            }
            write( OUT, buf, nRead);
        }

        return 0;
 }