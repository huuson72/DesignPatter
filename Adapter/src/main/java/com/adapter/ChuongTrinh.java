package com.adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.jerry.dp.CongNhanReader;
import com.peter.dp.SinhVien;
import com.peter.dp.SinhVienReader;

public class ChuongTrinh {
	public static void main(String[] args) throws IOException {
		
			// 1. Doc danh sach sinh vien, cong nhan & add vao danh sach chung
			List<SinhVien> lstSV = SinhVienReader.readFromFile("D:\\DesignPattern\\sv.txt");			
			for (int i = 0; i < lstSV.size(); i++) {
				System.out.println(lstSV.get(i).getHoTen());
			}			
		
			var lstCN = CongNhanReader.readFromFile("D:\\DesignPattern\\cn.txt");
			for (var x: lstCN)
				System.out.println(x.getHoTen() + " ngày vào làm " + x.getNgayVaoLam());
			
			var lst = new ArrayList<PhanTu>();
			for (SinhVien sv: lstSV)
				lst.add(new PhanTuCuaSinhVien(sv));
			
			for (var cn: lstCN)
				lst.add(new PhanTuCuaCongNhan(cn));
			
			System.out.println("Danh sách gộp:");
			int stt = 0;
			for (var x: lst)
				System.out.printf("%4d %-40s %-10s %3s\n", ++stt, x.getTen(), x.getLoaiPhanTu(), x.getDanhGia());
				
			 Collections.sort(lst, (pt1, pt2) -> pt1.getDanhGia().compareTo(pt2.getDanhGia()));
			
			
			// 3. In kết quả
			System.out.println("Danh sách sau khi sắp xếp:");
			int stt1 = 0;
			for (var x: lst)
				System.out.printf("%4d %-40s %-10s %3s\n", ++stt1, x.getTen(), x.getLoaiPhanTu(), x.getDanhGia());			
	}
}