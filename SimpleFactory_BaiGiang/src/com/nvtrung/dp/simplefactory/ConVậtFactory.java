package com.nvtrung.dp.simplefactory;

public class ConVậtFactory {
	public ConVật getConVật(String loại) {
		if ("MÈO".equals(loại))
			return new Mèo();
		else if ("CHÓ".equals(loại))
			return new Chó();
		else if ("Chim".equals(loại))
			return new Chim();
		else 
			return new Gà();
	}
}
