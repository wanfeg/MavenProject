//package com.example.mavenproject.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.security.MessageDigest;
//import java.util.*;
//
//@RestController
//@RequestMapping("/file2")
//public class File2Controller {
//
//    private static final String FILE_UPLOAD_PREFIX = "file_upload:";
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//
//    @Value("${my.config.savePath}")
//    private String uploadPath;
//    @Autowired
//    private ThreadLocal<RedisConnection> redisConnectionThreadLocal;
//
////    @Autowired
////    private RedisTemplate redisTemplate;
//
//    @PostMapping("/upload")
//    public ResponseEntity<?> uploadFile(@RequestParam("chunk") MultipartFile chunk,
//                                        @RequestParam("chunkIndex") Integer chunkIndex,
//                                        @RequestParam("chunkSize") Integer chunkSize,
//                                        @RequestParam("chunkChecksum") String chunkChecksum,
//                                        @RequestParam("fileId") String fileId) throws Exception {
//        if (fileId == null || StringUtils.isEmpty(fileId)) {
//            fileId = UUID.randomUUID().toString();
//        }
//        String key = FILE_UPLOAD_PREFIX + fileId;
//        byte[] chunkBytes = chunk.getBytes();
//        String actualChecksum = calculateHash(chunkBytes);
//        if (!chunkChecksum.equals(actualChecksum)) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Chunk checksum does not match");
//        }
////        if(!redisTemplate.opsForHash().hasKey(key,String.valueOf(chunkIndex))) {
////            redisTemplate.opsForHash().put(key, String.valueOf(chunkIndex), chunkBytes);
////        }
//        RedisConnection connection = redisConnectionThreadLocal.get();
//
//        Boolean flag = connection.hExists(key.getBytes(), String.valueOf(chunkIndex).getBytes());
//        if (flag==null || !flag) {
//            connection.hSet(key.getBytes(), String.valueOf(chunkIndex).getBytes(), chunkBytes);
//        }
//
//        return ResponseEntity.ok(fileId);
//
//    }
//
//    public static String calculateHash(byte[] fileChunk) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(fileChunk);
//        byte[] hash = md.digest();
//        ByteBuffer byteBuffer = ByteBuffer.wrap(hash);
//        StringBuilder hexString = new StringBuilder();
//        while (byteBuffer.hasRemaining()) {
//            hexString.append(String.format("%02x", byteBuffer.get()));
//        }
//        return hexString.toString();
//    }
//
//    @PostMapping("/merge")
//    public ResponseEntity<?> mergeFile(@RequestParam("fileId") String fileId, @RequestParam("fileName") String fileName) throws IOException {
//        String key = FILE_UPLOAD_PREFIX + fileId;
//        RedisConnection connection = redisConnectionThreadLocal.get();
//        try {
//            Map<byte[], byte[]> chunkMap = connection.hGetAll(key.getBytes());
////            Map chunkMap = redisTemplate.opsForHash().entries(key);
//            if (chunkMap.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
//            }
//
//            Map<String,byte[]> hashMap = new HashMap<>();
//            for(Map.Entry<byte[],byte[]> entry :chunkMap.entrySet()){
//                hashMap.put((new String(entry.getKey())),entry.getValue());
//            }
//            // 检测是否所有分片都上传了
//            boolean allChunksUploaded = true;
//            List<Integer> missingChunkIndexes = new ArrayList<>();
//            for (int i = 0; i < hashMap.size(); i++) {
//                if (!hashMap.containsKey(String.valueOf(i))) {
//                    allChunksUploaded = false;
//                    missingChunkIndexes.add(i);
//                }
//            }
//            if (!allChunksUploaded) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(missingChunkIndexes);
//            }
//
//            File outputFile = new File(uploadPath, fileName);
//            boolean flag = mergeChunks(hashMap, outputFile);
//            Resource resource = resourceLoader.getResource("file:" + uploadPath + fileName);
//
//
//            if (flag) {
//                connection.del(key.getBytes());
////                redisTemplate.delete(key);
//                return ResponseEntity.ok().body(resource.getURI().toString());
//            } else {
//                return ResponseEntity.status(555).build();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    private boolean mergeChunks(Map<String, byte[]> chunkMap, File destFile) {
//        try (FileOutputStream outputStream = new FileOutputStream(destFile)) {
//            // 将分片按照顺序合并
//            for (int i = 0; i < chunkMap.size(); i++) {
//                byte[] chunkBytes = chunkMap.get(String.valueOf(i));
//                outputStream.write(chunkBytes);
//            }
//            return true;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//}
