package com.work;

public enum Yeas {

	Spring(1,"spring"),Summer(2,"Summer"),Autumn(3,"Autumn"),Winter(4,"Winter");

	

	private String content;
	private Integer num;
	private Yeas(Integer num, String content) {
		this.num = num;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public static Yeas forEachYeas(Integer index) {
		for(Yeas yeas:values()) {
			
			if(yeas.num == index) {
				return yeas;
			}
		}
		return null;
	}
	
}
