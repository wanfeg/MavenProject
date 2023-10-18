package com.example.mavenproject.service;


import com.example.mavenproject.pojo.MessageRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (MessageRecord)表服务接口
 *
 * @author makejava
 * @since 2023-09-15 11:09:22
 */
public interface MessageRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MessageRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param messageRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<MessageRecord> queryByPage(MessageRecord messageRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param messageRecord 实例对象
     * @return 实例对象
     */
    MessageRecord insert(MessageRecord messageRecord);

    /**
     * 修改数据
     *
     * @param messageRecord 实例对象
     * @return 实例对象
     */
    MessageRecord update(MessageRecord messageRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
