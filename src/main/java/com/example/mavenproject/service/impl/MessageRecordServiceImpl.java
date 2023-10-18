package com.example.mavenproject.service.impl;

import com.example.mavenproject.mapper.MessageRecordDao;
import com.example.mavenproject.pojo.MessageRecord;
import com.example.mavenproject.service.MessageRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (MessageRecord)表服务实现类
 *
 * @author makejava
 * @since 2023-09-15 11:09:22
 */
@Service("messageRecordService")
public class MessageRecordServiceImpl implements MessageRecordService {
    @Resource
    private MessageRecordDao messageRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MessageRecord queryById(Integer id) {
        return this.messageRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param messageRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<MessageRecord> queryByPage(MessageRecord messageRecord, PageRequest pageRequest) {
        long total = this.messageRecordDao.count(messageRecord);
        return new PageImpl<>(this.messageRecordDao.queryAllByLimit(messageRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param messageRecord 实例对象
     * @return 实例对象
     */
    @Override
    public MessageRecord insert(MessageRecord messageRecord) {
        this.messageRecordDao.insert(messageRecord);
        return messageRecord;
    }

    /**
     * 修改数据
     *
     * @param messageRecord 实例对象
     * @return 实例对象
     */
    @Override
    public MessageRecord update(MessageRecord messageRecord) {
        this.messageRecordDao.update(messageRecord);
        return this.queryById(messageRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.messageRecordDao.deleteById(id) > 0;
    }
}
