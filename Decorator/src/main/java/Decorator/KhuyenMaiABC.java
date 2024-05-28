package Decorator;

public class KhuyenMaiABC extends  KhuyenMai{
    public KhuyenMaiABC(ThueBao thueBao) {
        super(thueBao);
    }
    public int getPhiThueBao() {
        return thueBao.getPhiThueBao(); // không thay đổi phí thuê bao
    }
    int getSoTinNhanFree() {
        return thueBao.getSoTinNhanFree() + 1000;
    }
    public int getSoPhutGoiFree() {
        return thueBao.getSoPhutGoiFree(); // không ảnh hưởng gì đến số phút gọi free của thuê bao
    }
    public int getGiaGoi() {
        return thueBao.getGiaGoi(); // gọi 1 phút tốn bao nhiêu
    }
    public int getGiaTinNhan() {
        return thueBao.getGiaTinNhan(); // 1 tin nhắn tốn bao nhiêu
    }
    
}