package com.hsy.parrot.bean.kafka;

import java.io.Serializable;
import java.util.Date;

/**
 * pojo
 * @author hsy
 */
public class KafkaOutMsg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private long id;
    /**
	 * 档案号 
	 */
	private long fwBh;
    /**
	 * 处理标记 0 失败 1 成功 
	 */
	private boolean dealFlag;
    /**
	 * 创建时间 
	 */
	private Date gmtCreate;
    /**
	 * 更新时间 
	 */
	private Date gmtUpdate;

	/**
	 * 构造
	 */
	public KafkaOutMsg() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFwBh() {
		return fwBh;
	}

	public void setFwBh(long fwBh) {
		this.fwBh = fwBh;
	}
	public boolean getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(boolean dealFlag) {
		this.dealFlag = dealFlag;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtUpdate() {
		return gmtUpdate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

}