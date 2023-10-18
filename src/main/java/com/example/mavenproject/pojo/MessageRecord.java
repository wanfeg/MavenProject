package com.example.mavenproject.pojo;

import java.io.Serializable;

/**
 * (MessageRecord)实体类
 *
 * @author makejava
 * @since 2023-09-15 11:08:01
 */
public class MessageRecord implements Serializable {
    private static final long serialVersionUID = 809810364605516174L;
    
    private Integer id;
    
    private Integer userId;
    
    private String userName;
    /**
     * 1.文本， 2.图片
     */
    private Integer messageType;
    
    private String content;
    
    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}

