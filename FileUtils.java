package com.neuedu.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 * */
public class FileUtils {
    // 将客户端传的文件存到虚拟目录中
    public static void storFile(InputStream inputStream,String fileName){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("E:\\PPT\\"+fileName);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,len);
            }
            System.out.println("上传成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fileOutputStream){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
