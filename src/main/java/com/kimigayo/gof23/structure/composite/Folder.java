package com.kimigayo.gof23.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class Folder extends AbstractFile {
    private List<IFile> files = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("---扫描文件夹：" + getName() + "---");
        for (IFile file : files){
            file.operation();
        }
    }

    public void addFile(IFile file){
        files.add(file);
    }
    public void removeFile(IFile file){
        files.remove(file);
    }
}
