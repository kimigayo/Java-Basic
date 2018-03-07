package com.kimigayo.gof23.structure.composite;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public abstract class AbstractFile implements IFile {
    private String name;

    public AbstractFile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ImageFile extends AbstractFile {
    public ImageFile(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("---扫描图像文件：" + getName() + "---");
    }
}

class TextFile extends AbstractFile {
    public TextFile(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("---扫描图像文件：" + getName() + "---");
    }
}

class VideoFile extends AbstractFile {
    public VideoFile(String name) {
        super(name);
    }

    @Override
    public void operation() {
        System.out.println("---扫描图像文件：" + getName() + "---");
    }

}
