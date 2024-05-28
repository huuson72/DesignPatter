package com.nvtrung.dp.simplefactory.ui;

import com.nvtrung.dp.simplefactory.ConVật;
import com.nvtrung.dp.simplefactory.ConVậtFactory;

public class ChuongTrinh {

	public static void main(String[] args) {
		testConVật();
	}

	private static void testConVật() {
		
		ConVậtFactory f = new ConVậtFactory();
		
		// 1. Khởi tạo con vật x
		ConVật x = f.getConVật("CHÓ");
		ConVật x1 = f.getConVật("GÀ");
		ConVật x2 = f.getConVật("Chim");
		// x = f.getConVật("GÀ");

		// 2. Thể hiện hoạt cảnh của game
		x.kêu();
		x1.kêu();
		x2.kêu();
		
	}

}
