//package com.luyisac.novel_zjx.controller;
//
//import com.luyisac.novel_zjx.utils.fileUtils.MinIoUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("minio")
//public class MinIoController {
//
//    @Autowired
//    private MinIoUtil minIoUtil;
//
//    @PostMapping("/upload")
//    public List<String> upload(@RequestParam(name = "multipartFile") MultipartFile[] multipartFile) {
//        return minIoUtil.upload(multipartFile);
//    }
//
//    @GetMapping("/download")
//    public ResponseEntity<byte[]> download(@RequestParam String fileName) {
//        return minIoUtil.download(fileName);
//    }
//
//    @PostMapping("/existBucket")
//    public void existBucket(@RequestParam String bucketName) {
//        minIoUtil.existBucket(bucketName);
//    }
//}
