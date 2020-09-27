package com.example.springcloudseataeurekaclient01.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
public class Statement extends Model<Statement> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer outUserId;
    private Integer inUserId;
    private BigDecimal money;

    private LocalDateTime ctime;

    private String text;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(Integer outUserId) {
        this.outUserId = outUserId;
    }

    public Integer getInUserId() {
        return inUserId;
    }

    public void setInUserId(Integer inUserId) {
        this.inUserId = inUserId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", outUserId=" + outUserId +
                ", inUserId=" + inUserId +
                ", money=" + money +
                ", ctime=" + ctime +
                ", text='" + text + '\'' +
                '}';
    }
}
