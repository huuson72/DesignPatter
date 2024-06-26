package com.nvtrung.dp.ui;

import com.nvtrung.dp.absfactory.DongVatAnCo;
import com.nvtrung.dp.absfactory.DongVatAnThit;
import com.nvtrung.dp.absfactory.DongVatFactory;
import com.nvtrung.dp.absfactory.style1.FactoryStyle1;
import com.nvtrung.dp.absfactory.style2.FactoryStyle2;

public class ChuongTrinh {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		// 1. Tạo nhà máy theo style
//		DongVatFactory f;
		DongVatFactory s = new FactoryStyle1();
		DongVatFactory f = new FactoryStyle2();
		
//		f = new FactoryStyle2();

		// 2. Tạo & sử dụng các đối tượng thuộc hệ sinh thái 
		// của nhà máy
		DongVatAnCo dvc = s.createDongVatAnCo();
		DongVatAnThit dvt = s.createDongVatAnThit();


		// 3. Sử dụng các đối tượng THUỘC CÙNG STYLE
		dvt.đuổiTheo(dvc);
		System.out.println();
		
	}

}
