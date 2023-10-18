package com.example.mavenproject.controller;

import com.example.mavenproject.pojo.MessageRecord;
import com.example.mavenproject.service.MessageRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MessageRecord)表控制层
 *
 * @author makejava
 * @since 2023-09-15 11:20:00
 */
@RestController
@RequestMapping("/messageRecord")
public class MessageRecordController {
    /**
     * 服务对象
     */
    @Resource
    private MessageRecordService messageRecordService;

    /**
     * 分页查询
     *
     * @param messageRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/pageQuery")
    public ResponseEntity<Page<MessageRecord>> queryByPage(MessageRecord messageRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.messageRecordService.queryByPage(messageRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MessageRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.messageRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param messageRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<MessageRecord> add(MessageRecord messageRecord) {
        return ResponseEntity.ok(this.messageRecordService.insert(messageRecord));
    }

    /**
     * 编辑数据
     *
     * @param messageRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<MessageRecord> edit(MessageRecord messageRecord) {
        return ResponseEntity.ok(this.messageRecordService.update(messageRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.messageRecordService.deleteById(id));
    }

}

