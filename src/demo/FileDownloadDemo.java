package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: heyong
 * @Date: 2020-01-02 14:38
 * @Description:
 */
public class FileDownloadDemo {


    public static void main(String[] args) throws Exception {
        String path = "http://test6tiantian.oss-cn-beijing.aliyuncs.com/mp3_ZDk5YTBiM2QtM2ZlMS00YjYxLWEzMDYtOTY5MTJlNThhOGNj.mp3";
        String name = "Our clothes语篇1.mp3";
        URL url = new URL(path);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String fileName = "/Users/heyong/Pictures/" + name;

        File file = new File(fileName);
        FileOutputStream fs = new FileOutputStream(fileName);
        byte[] buffer = new byte[1024];

        int byteRead = 0;

        while ((byteRead = inputStream.read(buffer)) != -1) {
            fs.write(buffer, 0, byteRead);
        }

        System.out.println("success");

    }
}
