<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="CN">
<head>
    <title>文件上传示例</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="http:localhost:8080/nihk">
</head>
<body>
<form>
    <input type="file" id="fileInput" multiple>
    <button type="button" onclick="upload()" >上传</button>
</form>
<script>
    function upload() {
        var fileInput = document.getElementById('fileInput');
        var fileName = document.getElementById("fileInput").files[0].name;
        var files = fileInput.files;
        var chunkSize = 1024 * 500; // 每个块的大小为10KB
        var totalChunks = Math.ceil(files[0].size / chunkSize); // 文件总块数
        var currentChunk = 0; // 当前块数

        // 分片上传文件
        function uploadChunk() {
            var xhr = new XMLHttpRequest();
            var formData = new FormData();

            // 将当前块数和总块数添加到formData中
            formData.append('currentChunk', currentChunk);
            formData.append('totalChunks', totalChunks);
            formData.append('fileName',fileName);

            // 计算当前块在文件中的偏移量和长度
            var start = currentChunk * chunkSize;
            var end = Math.min(files[0].size, start + chunkSize);
            var chunk = files[0].slice(start, end);

            // 添加当前块到formData中
            formData.append('chunk', chunk);

            // 发送分片到后端
            xhr.open('POST', '/file/upload');
            xhr.send(formData);

            xhr.onload = function() {
                // 更新当前块数
                currentChunk++;

                // 如果还有未上传的块，则继续上传
                if (currentChunk < totalChunks) {
                    uploadChunk();
                } else {
                    // 所有块都上传完毕，进行文件合并
                    mergeChunks(fileName);
                }
            }
        }

        // 合并所有分片
        function mergeChunks() {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/file/merge", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        console.log("文件上传完成：", xhr.responseText);
                    } else {
                        console.error(xhr.responseText);
                    }
                }
            };
            xhr.send("fileName=" + fileName);
        }

        // 开始上传
        uploadChunk();
    }
</script>
</body>
</html>

