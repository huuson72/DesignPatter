package SinhVien;

import java.util.Date;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private boolean gioiTinh;
    private Date ngaySinh; // Thay đổi kiểu dữ liệu thành Date

    public SinhVien(String studentID, String fullName, boolean isMale, Date dateOfBirth) { // Thay đổi kiểu dữ liệu của tham số dateOfBirth thành Date
        this.maSV = studentID;
        this.hoTen = fullName;
        this.gioiTinh = isMale;
        this.ngaySinh = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentID: " + maSV + ", FullName: " + hoTen + ", IsMale: " + gioiTinh + ", DateOfBirth: " + ngaySinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() { // Thay đổi kiểu trả về của phương thức thành Date
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) { // Thay đổi kiểu dữ liệu của tham số ngaySinh thành Date
        this.ngaySinh = ngaySinh;
    }
}
