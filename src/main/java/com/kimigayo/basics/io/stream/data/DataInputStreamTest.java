package com.kimigayo.basics.io.stream.data;

import java.io.*;

public class DataInputStreamTest {
    public static void main(String[] args) {
//        write("./data.txt");
//        read("./data.txt");
        byteRead(byteWrite());
    }

    public static void read(String path) {
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
            System.out.println(inputStream.readDouble() + "\t\t" + inputStream.readLong() + "\t\t" + inputStream.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void write(String path) {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            double v = 2.0;
            long l = 11l;
            int integer = 100;
            outputStream.writeDouble(v);
            outputStream.writeLong(l);
            outputStream.writeInt(integer);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void byteRead(byte[] bytes) {
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
            System.out.println(inputStream.readDouble() + "\t\t" + inputStream.readLong() + "\t\t" + inputStream.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] byteWrite() {
        DataOutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            outputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
            double v = 2.0;
            long l = 11l;
            int integer = 100;
            outputStream.writeDouble(v);
            outputStream.writeLong(l);
            outputStream.writeInt(integer);
            outputStream.flush();
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
