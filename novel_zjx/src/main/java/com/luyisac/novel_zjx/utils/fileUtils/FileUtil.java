package com.luyisac.novel_zjx.utils.fileUtils;

import com.luyisac.novel_zjx.entity.User;
import com.luyisac.novel_zjx.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    @Value("${image.location}")
    private String location;

    @Autowired
    private FastDFSClient fastDFSClient;

    public String uploadUserAvatar(MultipartFile file) throws Exception {//        获取前端传过来的把涩的字符串,
        User user = new User();
        user.setId(1);
        System.out.println("上传文件开始");
        user.setPassword(null);
//        上传文件到fastdfs
        String url = fastDFSClient.uploadFile(file);
        url = location + url;
        System.out.println(url);
//      获取缩略图
        String thump = "_80x80.";
        String arr[] = url.split("\\.");
        String thumpurl = arr[0] + thump + arr[1];
        System.out.println("上传文件文件完毕");
        return url;
    }
}
