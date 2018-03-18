package com.countdownlatch;

public enum Nation {

	NOE(1,"�Թ�"),TWE(2,"κ��"),THREE(3,"����"),FOUR(4,"����"),FIVE(5,"���"),SIX(6,"���");

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
	
	//ѭ��
	public static Nation forEachEnum(Integer index) {
		
		for(Nation na: values()) {
			if(na.getNum() == index) {
				return na;
			}
		}
		return null;
	}
	
}
