public class test {
    public static void main(String[] args) {
        SinhVien x = new SinhVien.SinhVienBuilder()
                .hoTen("Nguyễn Văn Trung")
                .maSinhVien("T102123")
                .maNganhDaoTao(102)
                .ngaySinh(new java.sql.Date(1981 - 1900, 10 - 1, 25)) // Lưu ý: Trừ đi 1900 cho năm và trừ đi 1 cho tháng
                .build();

        System.out.println(x);
    }
}
