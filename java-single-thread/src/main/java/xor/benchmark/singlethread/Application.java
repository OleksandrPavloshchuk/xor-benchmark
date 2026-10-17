package xor.benchmark.singlethread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("key is needed");
        }

        final byte[] key = args[0].getBytes(StandardCharsets.UTF_8);

        final InputStream in = System.in;
        final OutputStream out = System.out;

        final byte[] buf = new byte[8 * 1024];
        int keyIndex = 0;
        int nRead;
        while ((nRead = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < nRead; i++) {
                buf[i] ^= key[ keyIndex];
                if (++keyIndex == key.length) {
                    keyIndex = 0;
                }
            }
            out.write(buf, 0, nRead);
        }
    }
}
