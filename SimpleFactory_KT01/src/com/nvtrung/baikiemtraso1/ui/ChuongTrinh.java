package com.nvtrung.baikiemtraso1.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import com.nvtrung.baikiemtraso1.implement.NguonDuLieuSqlServer;
import com.nvtrung.baikiemtraso1.implement.NguonDuLieuVanBan;
import com.nvtrung.baikiemtraso1.model.CauHinh;
import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class ChuongTrinh {

    static CauHinh docCauHinhTuFile() throws IOException {
        var ch = new CauHinh();
        var br = new BufferedReader(new FileReader("config"));
        String loaiNguon = br.readLine();
        ch.setLoaiNguon(loaiNguon);
        String chuoiKetNoi = br.readLine();
        ch.setChuoiKetNoi(chuoiKetNoi);
        br.close();

        return ch;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var ch = docCauHinhTuFile();

        NguonDuLieu ndl;
        if (ch.getLoaiNguon().equals(CauHinh.LOAI_TEXT_FILE))
            ndl = new NguonDuLieuVanBan(ch.getChuoiKetNoi());
        else
            ndl = NguonDuLieuSqlServer.getInstance(ch.getChuoiKetNoi());

        // 1. Đọc & in danh sách sv
        var lst = ndl.selectAll();
        System.out.println("Danh sách các sinh viên đọc được");
        inDanhSach(lst);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // Tạo ngày sinh từ chuỗi
        Date ngaySinh = new Date(2001 - 1900, 4, 15); // Năm - 1900, Tháng (0 - 11), Ngày

        // Tạo đối tượng SinhVien
        SinhVien nguyen = new SinhVien();
        nguyen.setMaSinhVien("T123450");
        nguyen.setHoTen("Trần Văn B");
        nguyen.setGioiTinhNam(true);
        nguyen.setNgaySinh(ngaySinh);

        ndl.insert(nguyen);
        System.out.println("Danh sách sinh viên sau khi insert");
        lst = ndl.selectAll();
        inDanhSach(lst);

        // 3. Xoá sinh viên khỏi nguồn dữ liệu
        ndl.delete("T12345"); 

        // Hiển thị danh sách sinh viên sau khi xóa
        lst = ndl.selectAll();
        System.out.println("Danh sách sinh viên sau khi xóa");
        inDanhSach(lst);
    }

    /**
     * In danh sách sinh viên trong danh sách lst ra màn hình
     * 
     * @param lst
     */
    private static void inDanhSach(List<SinhVien> lst) {
        for (int i = 0; i < lst.size(); i++) {
            var sv = lst.get(i);
            System.out.printf("%5s %30s %8s %s\n", //
                    sv.getMaSinhVien(), //
                    sv.getHoTen(), //
                    sv.isGioiTinhNam(), //
                    sv.getNgaySinh());//
        }
    }
}
