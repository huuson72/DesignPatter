package service;

import java.util.List;

import model.SinhVien;

public interface Interface {
 List<SinhVien> selectAll();
 void insert(SinhVien sv);
 void delete (SinhVien sv);
}
