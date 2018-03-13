package com.kimigayo.basics.io;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
    public void close(Closeable... io) {
        for (Closeable closeable : io) {
            if (null != io) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T extends Closeable> void closeAll(T... io) {
        for (Closeable closeable : io) {
            if (null != io) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
