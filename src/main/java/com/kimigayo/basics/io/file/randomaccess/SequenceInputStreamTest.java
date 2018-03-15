package com.kimigayo.basics.io.file.randomaccess;

import java.io.SequenceInputStream;

public class SequenceInputStreamTest {
    public static void main(String[] args) {
        RandomAccessFileUtil fileUtil = new RandomAccessFileUtil(50,"./db.properties");
        fileUtil.fileCut();
        fileUtil.fileMerge("./db2.properties");
        fileUtil.fileClear();
    }
}
