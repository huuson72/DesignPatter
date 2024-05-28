package Decorator;

public class ChuongTrinh {
    public static void main(String[] args) {
    	 ThueBao tomato = new Tomato();
    	 System.out.println("Tomato Phí Thuê Bao: " + tomato.getPhiThueBao());
         System.out.println("Tomato Số Phút Gọi Free: " + tomato.getSoPhutGoiFree());
         System.out.println("Tomato Số Tin Nhắn Free: " + tomato.getSoTinNhanFree());
         System.out.println("Tomato Giá Gọi: " + tomato.getGiaGoi());
         System.out.println("Tomato Giá Tin Nhắn: " + tomato.getGiaTinNhan());
         ThueBao tomatoWithKhuyenMaiABC = new KhuyenMaiABC(tomato);
         System.out.println("Tomato with KhuyenMaiABC Số Tin Nhắn Free: " + tomatoWithKhuyenMaiABC.getSoTinNhanFree());
    	 
    
    }
}
