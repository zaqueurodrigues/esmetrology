package com.zaqueurodrigues.esmetrology.entities.enums;

public enum InstrumentStatus {
	
	INACTIVE(0), ACTIVE(1);
	
	private int status;
	
	private InstrumentStatus(int i) {
		this.status = i;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public static InstrumentStatus valueOf(int status) {
		for (InstrumentStatus value : InstrumentStatus.values()) {
			if (value.getStatus() == status) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
	
	
}
