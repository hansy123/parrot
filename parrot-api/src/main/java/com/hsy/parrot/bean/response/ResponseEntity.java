package com.hsy.parrot.bean.response;

/**  
 * 简述功能
 * ClassName: ResponseEntity    
 * date: 2018年1月19日 下午3:27:07 
 * @author 82702   
 * @since JDK 1.8 
 */
public class ResponseEntity {

	/**
	 * 返回状态
	 */
	protected int result;
	/**
	 * 返回结果
	 */
	protected String message;
	/**
	 * 返回值
	 */
	protected Object value;

	public ResponseEntity() {
		super();
	}
	public ResponseEntity(int result) {
		super();
		this.result = result;
		if(GeneConstant.INT_1 == result){
			message = GeneConstant.SUCCESS;
		}else if(GeneConstant.INT_0 == result){
			message = GeneConstant.ERROR;
		}
	}
	/**
	 * 返回结果初始化 Creates a new instance of ResponseEntity.
	 * @param message
	 */
	public ResponseEntity(String message) {
		super();
		if (null != message) {
			this.message = message;
			switch (message) {
			case GeneConstant.ERROR:
				this.result = GeneConstant.INT_0;// 请求失败
				break;
			case GeneConstant.SUCCESS:
				this.result = GeneConstant.INT_1;// 请求成功
				break;
			case GeneConstant.YES:
				this.result = GeneConstant.INT_1;// 逻辑肯定
				break;
			case GeneConstant.NO:
				this.result = GeneConstant.INT_1_MIN;// 逻辑否定
				break;
			default:
				this.result = GeneConstant.INT_1;
				break;
			}
		}
	}
	/**
	 * Creates a new instance of ResponseEntity.  
	 * @param result
	 * @param message
	 * @param value
	 */
	public ResponseEntity(int result, String message, Object value) {
		super();
		this.result = result;
		this.message = message;
		this.value = value;
	}
	/**
	 * Creates a new instance of ResponseEntity.  
	 * @param result
	 * @param message
	 */
	public ResponseEntity(int result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	/**
	 * Creates a new instance of ResponseEntity.  
	 * @param message
	 * @param value
	 */
	public ResponseEntity(String message,Object value) {
		super();
		switch (message) {
		case GeneConstant.ERROR:
			this.result = GeneConstant.INT_0;// 请求失败
			break;
		case GeneConstant.SUCCESS:
			this.result = GeneConstant.INT_1;// 请求成功
			break;
		case GeneConstant.YES:
			this.result = GeneConstant.INT_1;// 逻辑肯定
			break;
		case GeneConstant.NO:
			this.result = GeneConstant.INT_1_MIN;// 逻辑否定
			break;
		default:
			this.result = GeneConstant.INT_1;
			break;
		}
		this.message = message;
		this.value = value;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getValue() {
		return value;
	}
	public ResponseEntity setValue(Object value) {
		this.value = value;
		return this;
	}
	@Override
	public String toString() {
		return "ResponseEntity [result=" + result + ", message=" + message + ", value=" + value
				+ "]";
	}
	
}
  
