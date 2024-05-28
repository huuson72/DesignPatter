package com.nvtrung.baikiemtraso1.implement;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class NguonDuLieuVanBan implements NguonDuLieu {
    private String filename;

    public NguonDuLieuVanBan(String filename) {
        this.filename = filename;
    }

    private Date convertToDate(String stDMY) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date kq = null;
        try {
            kq = sdf.parse(stDMY);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public List<SinhVien> selectAll() {
        ArrayList<SinhVien> lst = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;  // Bỏ qua dòng trống
                }
                String[] info = line.split(",");
                if (info.length >= 4) {
                    String maSinhVien = info[0];
                    String hoTen = info[1];
                    boolean gioiTinhNam = info[2].equals("True");
                    Date ngaySinh = convertToDate(info[3]);
                    lst.add(new SinhVien(maSinhVien, hoTen, gioiTinhNam, ngaySinh));
                } else {
                    System.err.println("Dòng dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public void insert(SinhVien sv) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String ngaySinh = (sv.getNgaySinh() != null) ? sdf.format(sv.getNgaySinh()) : "";
            String stNewSV = String.format("%s,%s,%s,%s\n",
                    sv.getMaSinhVien(),
                    sv.getHoTen(),
                    sv.isGioiTinhNam(),
                    ngaySinh);
            bw.write(stNewSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSinhVien) {
        List<SinhVien> lst = selectAll();
        lst.removeIf(sv -> sv.getMaSinhVien().equals(maSinhVien));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            for (SinhVien sv : lst) {
                String ngaySinh = (sv.getNgaySinh() != null) ? sdf.format(sv.getNgaySinh()) : "";
                String stNewSV = String.format("%s,%s,%s,%s\n",
                        sv.getMaSinhVien(),
                        sv.getHoTen(),
                        sv.isGioiTinhNam(),
                        ngaySinh);
                bw.write(stNewSV);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
