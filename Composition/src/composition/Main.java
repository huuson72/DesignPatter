package composition;

public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng và thiết lập màu nền
        MyColor redColor = new MyColor(255, 0, 0);
        MyColor greenColor = new MyColor(0, 255, 0);
        MyColor blueColor = new MyColor(0, 0, 255);

        Panel panel = new Panel("Panel 1", redColor);
        Button button = new Button("Button 1", greenColor);
        ListBox listBox = new ListBox("ListBox 1", blueColor);
        Label label = new Label("Label 1", redColor);

        // In thông tin của các đối tượng
        System.out.println("Thông tin của các đối tượng:");
        printObjectInfo(panel);
        printObjectInfo(button);
        printObjectInfo(listBox);
        printObjectInfo(label);
    }

    // Phương thức in thông tin của đối tượng Control
    private static void printObjectInfo(Control control) {
        System.out.println("Loại: " + control.getClass().getSimpleName());
        System.out.println("Text: " + control.getText());
        System.out.println("Màu nền: " + control.getBackColor().getRed() + ", " +
                           control.getBackColor().getGreen() + ", " +
                           control.getBackColor().getBlue());
        System.out.println();
    }
}
