import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TenLopCon extends TenLop{
    private double field3; // thêm thuộc tính mới

    public TenLopCon(TenLopCon x) {
        super(); // gọi hàm này để khởi tạo các thuộc tính ở lớp cha

        this.field3 = x.field3; // gán thêm thuộc tính mới, chỉ có ở lớp con
    }
    public TenLopCon(String f1, double f2, double field3) {
        super(f1, f2); // gọi constructor của lớp cha
        this.field3 = field3; // gán thuộc tính mới
    }

    public TenLopCon taoBanSao() {
        return new TenLopCon(this);
    }
}
