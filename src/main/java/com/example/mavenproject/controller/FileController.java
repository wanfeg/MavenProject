package com.example.mavenproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${my.config.savePath}")
    private String uploadPath;
    //private boolean flag = true;
    private String tempFileName;

    private Map<String, List<File>> chunksMap = new ConcurrentHashMap<>();

    @PostMapping("/upload")
    public void upload(@RequestParam int currentChunk, @RequestParam int totalChunks,
                       @RequestParam MultipartFile chunk, @RequestParam String fileName) throws IOException {
        if (tempFileName == null) {
            int index = fileName.lastIndexOf(".");
            String photoType = fileName.substring(index);
            tempFileName = UUID.randomUUID() + photoType ;
        }
        fileName = tempFileName;
        // 将分片保存到临时文件夹中
        String chunkName = chunk.getOriginalFilename() + "." + currentChunk;
        File chunkFile = new File(uploadPath, chunkName);
        chunk.transferTo(chunkFile);

        // 记录分片上传状态
        List<File> chunkList = chunksMap.get(fileName);
        System.out.println("fileName = " + fileName);
        if (chunkList == null) {
            chunkList = new ArrayList<>(totalChunks);
            chunksMap.put(fileName, chunkList);
        }
        chunkList.add(chunkFile);
    }

    @PostMapping("/merge")
    public String merge(@RequestParam String fileName) throws IOException {

        // 获取所有分片，并按照分片的顺序将它们合并成一个文件
        fileName = tempFileName;
        List<File> chunkList = chunksMap.get(fileName);
        if (chunkList == null || chunkList.size() == 0) {
            throw new RuntimeException("分片不存在");
        }

        File outputFile = new File(uploadPath, fileName);
        try (FileChannel outChannel = new FileOutputStream(outputFile).getChannel()) {
            for (int i = 0; i < chunkList.size(); i++) {
                try (FileChannel inChannel = new FileInputStream(chunkList.get(i)).getChannel()) {
                    inChannel.transferTo(0, inChannel.size(), outChannel);
                }
                chunkList.get(i).delete(); // 删除分片
            }
        }

        chunksMap.remove(fileName); // 删除记录
        tempFileName = null;
        // 获取文件的访问URL
        Resource resource =
        			resourceLoader.getResource("file:" + uploadPath + fileName); //由于是本地文件，所以开头是"file"，如果是服务器，请改成自己服务器前缀
        return resource.getURI().toString();
    }


    @RequestMapping(value="download.json")
    public boolean download(HttpServletResponse res) throws IOException {
        File file = new File("C:\\Users\\abbyw\\Desktop\\图片\\wallhaven-yxgmll.png");
        String fileName = "wallhaven-yxgmll.png";
        // 如果不设置这个响应头的话，点击a标签图片会直接展示在当前页面上，类似于预览
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
        return false;
    }



}
