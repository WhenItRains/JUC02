package com.countdownlatch;

public enum Nation {

	NOE(1,"赵国"),TWE(2,"魏国"),THREE(3,"楚国"),FOUR(4,"韩国"),FIVE(5,"齐国"),SIX(6,"燕国");

	private Integer num;
	private String nation;
	
	private Nation(Integer num, String nation) {
		this.num = num;
		this.nation = nation;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	//循环
	public static Nation forEachEnum(Integer index) {
		
		for(Nation na: values()) {
			if(na.getNum() == index) {
				return na;
			}
		}
		return null;
	}
	
}
