package com.cmd;

import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author iuuui
 * @time 2024/03/30 1207
 */
public class CMDTest {

    public static void main(String[] args) throws IOException {
        final String CMD = "mysqldump -uroot -proot --default-character-set=utf8mb4 swl";
        Process process = Runtime.getRuntime().exec(CMD);
        System.out.println("----------------------");
//        print(process.getErrorStream());
        System.out.println("----------------------");
        print(process.getInputStream());
    }

    public static void print(InputStream is) {
        List<String> strings = IOUtils.readLines(is, Charset.forName("UTF-8"));
        BufferedOutputStream bf = null;
        try {
            bf = new BufferedOutputStream(new FileOutputStream("C:\\Users\\admin\\Desktop\\swl-backup.sql"));
            for (String string : strings) {
                string = string + "\r\n";
                bf.write(string.getBytes());
            }
            bf.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is, bf);
        }
    }

}
