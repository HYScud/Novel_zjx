//package com.luyisac.novel_zjx.config;
//
//import com.luyisac.novel_zjx.entity.MinioProperties;
//import io.minio.MinioClient;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//
//
//@Configuration
//@EnableConfigurationProperties(MinioProperties.class)
//public class MinioConfig {
//
//    @Resource
//    private MinioProperties minioPropertiesConfig;
//
//
//    /**
//     * 初始化 MinIO 客户端
//     */
//    @Bean
//    public MinioClient minioClient() {
//        MinioClient minioClient = MinioClient.builder()
//                .endpoint(minioPropertiesConfig.getEndpoint())
//                .credentials(minioPropertiesConfig.getAccessKey(), minioPropertiesConfig.getSecretKey())
//                .build();
//        return minioClient;
//    }
//}