package com.kimigayo.basics.io.file.randomaccess;

import com.google.common.collect.Lists;
import com.kimigayo.basics.io.FileUtil;

import java.io.*;
import java.util.List;
import java.util.Vector;

public final class RandomAccessFileUtil {
    private int blockSize;
    private int size;
    private long seekLocation;
    private long length;
    private String filePath;
    private List<String> blockPath = Lists.newArrayList();

    public RandomAccessFileUtil(int blockSize, String filePath) {
        this.blockSize = blockSize;
        this.filePath = filePath;
        this.init();
    }

    private void init() {
        File file = new File(this.filePath);
        this.size = (int) Math.ceil(file.length()*1.0 / this.blockSize);
        this.length = file.length();
        for (int i=0;i<size;i++){
            blockPath.add(this.filePath+".part"+i);
        }
    }

    public void fileCut() {
        int residueSize = this.blockSize;
        for (int i = 0; i < size; i++) {
            if (i==(size-1)){
                residueSize = (int) (this.length-seekLocation);
            }
            doFileCut(i, residueSize,blockPath.get(i));
            this.seekLocation = this.blockSize * (i + 1);
        }
    }

    public void fileClear(){

        for (int i = 0; i < size; i++) {
            new File(blockPath.get(i)).delete();
        }
    }

    private void doFileCut(int index, int residueSize, String s) {
        RandomAccessFile file = null;
        BufferedOutputStream outputStream = null;
        try {
            file = new RandomAccessFile(this.filePath, "r");
            outputStream = new BufferedOutputStream(new FileOutputStream(s));
            file.seek(seekLocation);
            byte[] bytes = new byte[blockSize];
            int len;
            while ((len = file.read(bytes)) > 0) {
                if (residueSize >= len) {
                    outputStream.write(bytes, 0, len);
                    residueSize -= len;
                } else {
                    outputStream.write(bytes, 0, residueSize);
                    break;
                }
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtil.closeAll(outputStream, file);
        }
    }

    public void fileMerge(String path){
        SequenceInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try{
            outputStream = new BufferedOutputStream(new FileOutputStream(path));
            Vector<InputStream> vector = new Vector<InputStream>();
            for(String s : blockPath){
                vector.add(new FileInputStream(s));
            }
            inputStream = new SequenceInputStream(vector.elements());
            byte[]  bytes = new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeAll(outputStream,inputStream);
        }
    }
}
