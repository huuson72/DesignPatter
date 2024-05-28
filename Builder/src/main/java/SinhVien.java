@lombok.Builder
@lombok.Getter
@lombok.Setter

public class SinhVien {
    private String maSinhVien;
    private String hoTen;
    private boolean gioiTinhNam;
    private java.sql.Date ngaySinh;
    private int maNganhDaoTao;
}

