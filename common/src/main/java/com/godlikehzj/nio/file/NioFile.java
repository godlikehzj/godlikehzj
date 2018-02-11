package com.godlikehzj.nio.file;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class NioFile {
    public static void main(String[] args) throws Exception{
        NioFile file = new NioFile();
        System.out.println(file.getClass().getClassLoader().getParent().toString());
        System.out.println(String.class.getClassLoader());
//        File file = new File("D:\\code\\java\\godlikehzj\\common\\src\\main\\java\\com\\godlikehzj\\nio\\file\\test.txt");
//        FileChannel fc = new FileInputStream(file).getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        System.out.println("read num " + fc.read(byteBuffer));
//        byteBuffer.flip();
//        for (int i = 0; i< 3; i++)
//            System.out.print((char) byteBuffer.get());
////        byteBuffer.clear();
////        byteBuffer.put("xxxxx".getBytes());
//
//        byteBuffer.compact();
//        byteBuffer.flip();
//        fc.write(byteBuffer);
    }
}
