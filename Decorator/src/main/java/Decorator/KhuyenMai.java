package Decorator;

import java.sql.Date;

public class KhuyenMai extends  ThueBao{
	protected Date ngayBatDauApDung;
	protected ThueBao thueBao;

    public KhuyenMai(ThueBao x) {
        this.thueBao = x;
    }


	int getPhiThueBao() {
        return thueBao.getPhiThueBao();
    }


    int getSoPhutGoiFree() {
        return thueBao.getSoPhutGoiFree();
    }


    int getSoTinNhanFree() {
        return thueBao.getSoPhutGoiFree();
    }


    int getGiaGoi() {
        return thueBao.getGiaGoi();
    }


    int getGiaTinNhan() {
        return thueBao.getGiaTinNhan();
    }
}
