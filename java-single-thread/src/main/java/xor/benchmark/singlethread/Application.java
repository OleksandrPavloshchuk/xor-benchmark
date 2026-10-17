package xor.benchmark.singlethread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("key is needed");
        }

        final byte[] key = args[0].getBytes();

        final InputStream in = System.in;
        final OutputStream out = System.out;

        final byte[] buf = new byte[8 * 1024];
        int totalRead = 0;
        int nRead;
        while ((nRead = in.read(buf, 0, buf.length)) > 0) {
            for (int i = 0; i < nRead; i++) {
                buf[i] = (byte) (buf[i] ^ key[ totalRead % key.length]);
            }
            totalRead += nRead;
            out.write(buf, 0, nRead);
        }
    }
}
