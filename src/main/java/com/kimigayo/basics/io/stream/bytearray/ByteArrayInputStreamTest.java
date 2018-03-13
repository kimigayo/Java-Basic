package com.kimigayo.basics.io.stream.bytearray;

import java.io.*;

public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(read());
            byte[] bytes1 = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes1)) > 0) {
                outputStream.write(bytes1, 0, len);
            }
            outputStream.flush();
            System.out.println(outputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] read() {
        InputStream stream = null;
        ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
        try {
            stream = new FileInputStream("./db.properties");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = stream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
                if (null != stream) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
