public class TestPrototype {
    public static void main(String[] args) {
        // Tạo một đối tượng TenLop ban đầu
        TenLop originalTenLop = new TenLop("Original", 123.45);
        System.out.println("Original TenLop: " + originalTenLop.getF1() + ", " + originalTenLop.getF2());

        // Sao chép đối tượng TenLop
        TenLop clonedTenLop = originalTenLop.taoBanSao();
        System.out.println("Cloned TenLop: " + clonedTenLop.getF1() + ", " + clonedTenLop.getF2());

        // Kiểm tra xem hai đối tượng có giống nhau nhưng không phải cùng một tham chiếu
        System.out.println("Are original and cloned TenLop equal? " + (originalTenLop.equals(clonedTenLop)));
        System.out.println("Are original and cloned TenLop the same object? " + (originalTenLop == clonedTenLop));

        // Tạo một đối tượng TenLopCon ban đầu
        TenLopCon originalTenLopCon = new TenLopCon("OriginalCon", 678.90, 987.65);
        System.out.println("Original TenLopCon: " + originalTenLopCon.getF1() + ", " + originalTenLopCon.getF2() + ", " + originalTenLopCon.getField3());

        // Sao chép đối tượng TenLopCon
        TenLopCon clonedTenLopCon = originalTenLopCon.taoBanSao();
        System.out.println("Cloned TenLopCon: " + clonedTenLopCon.getF1() + ", " + clonedTenLopCon.getF2() + ", " + clonedTenLopCon.getField3());

        // Kiểm tra xem hai đối tượng có giống nhau nhưng không phải cùng một tham chiếu
        System.out.println("Are original and cloned TenLopCon equal? " + (originalTenLopCon.equals(clonedTenLopCon)));
        System.out.println("Are original and cloned TenLopCon the same object? " + (originalTenLopCon == clonedTenLopCon));
    }
}
