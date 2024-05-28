package com.nvtrung.baikiemtraso1.service;

import java.util.List;

import com.nvtrung.baikiemtraso1.model.SinhVien;

public interface NguonDuLieu {
	List<SinhVien> selectAll();

	void insert(SinhVien sv);

	void delete(String maSinhVien);
}
