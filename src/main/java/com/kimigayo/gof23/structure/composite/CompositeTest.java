package com.kimigayo.gof23.structure.composite;

/**组合模式
 * 应用场景：把部分和整体的关系用树形结构来表示，从而从客户端可以使用统一的处理方式处理部分对象和整体对象
 * Created by chenbinbin on 2018/2/10.
 */
public class CompositeTest {
    public static void main(String[] args) {
        IFile f2,f3,f4,f5;
        f2 = new ImageFile("旅行青蛙.jpg");
        f3 = new VideoFile("琅琊榜2.avi");
        f4 = new TextFile("日记.txt");
        f5 = new VideoFile("古剑奇谭.avi");
        Folder f6 = new Folder("我的收藏");
        Folder f7 = new Folder("视频");
        f6.addFile(f2);
        f6.addFile(f4);
        f6.addFile(f7);
        f7.addFile(f3);
        f7.addFile(f5);
        f6.operation();
    }
}
