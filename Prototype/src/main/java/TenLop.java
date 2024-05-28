import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TenLop {
    private String f1;
    private double f2;

    public TenLop(TenLop x) {
        this.f1 = x.f1;
        this.f2 = x.f2;
    }

    public TenLop taoBanSao() {
        return new TenLop(this);
    }
}
