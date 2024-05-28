package Decorator;
@lombok.Data
@lombok.AllArgsConstructor

public class Tomato extends ThueBao{
	public int getPhiThueBao() {
        return 50000; // ví dụ: phí thuê bao là 50,000 VND
    }

    @Override
    public int getSoPhutGoiFree() {
        return 100; // ví dụ: 100 phút gọi miễn phí
    }

    @Override
    public int getSoTinNhanFree() {
        return 500; // ví dụ: 500 tin nhắn miễn phí
    }

    @Override
    public int getGiaGoi() {
        return 200; // ví dụ: 200 VND mỗi phút gọi
    }

    @Override
    public int getGiaTinNhan() {
        return 100; // ví dụ: 100 VND mỗi tin nhắn
    }
}
