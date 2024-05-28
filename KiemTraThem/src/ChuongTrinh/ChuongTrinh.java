package ChuongTrinh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Singleton.DatabaseConnection;
import SinhVien.SinhVien;

public class ChuongTrinh {
    private List<SinhVien> studentCache = new ArrayList<>();
    private boolean cacheValid = false;
    private DatabaseConnection dbConnection = DatabaseConnection.getInstance(); // Lưu tham chiếu đến đối tượng kết nối CSDL

    public List<SinhVien> getAllStudents() {
        if (!cacheValid) {
            studentCache.clear();
            try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
                if (conn != null && !conn.isClosed()) { // Kiểm tra kết nối không đóng
                    System.out.println("Connection is open");
                    String sql = "SELECT * FROM Students";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql);
                         ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            String studentID = rs.getString("StudentID");
                            String fullName = rs.getString("FullName");
                            boolean isMale = rs.getBoolean("IsMale");
                            // Lấy ngày sinh dưới dạng java.util.Date
                            Date dateOfBirth = rs.getDate("DateOfBirth");
                            studentCache.add(new SinhVien(studentID, fullName, isMale, dateOfBirth));
                        }
                    }
                    cacheValid = true;
                    System.out.println("Connection is still open after executing query.");
                } else {
                    System.out.println("Connection is null or closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentCache;
    }


    public void addStudent(String studentID, String fullName, boolean isMale, Date dateOfBirth) { 
        try (Connection conn = dbConnection.getConnection()) { // Sử dụng kết nối từ đối tượng DatabaseConnection
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection is open");
                String sql = "INSERT INTO Students (StudentID, FullName, IsMale, DateOfBirth) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, studentID);
                    pstmt.setString(2, fullName);
                    pstmt.setBoolean(3, isMale);
                    pstmt.setDate(4, new java.sql.Date(dateOfBirth.getTime()));
                    pstmt.executeUpdate();
                    
                    // Clear the cache and set it as invalid since we have added a new student
                    studentCache.clear();
                    cacheValid = false;
                }
            } else {
                System.out.println("Connection is null or closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        ChuongTrinh manager = new ChuongTrinh();

        // In danh sách tất cả sinh viên ban đầu
        System.out.println("Danh sách tất cả sinh viên ban đầu:");
        for (SinhVien student : manager.getAllStudents()) {
            System.out.println(student);
        }

        // Bổ sung một sinh viên mới vào bảng
        Date dateOfBirth = new Date(2000 - 1900, 1 - 1, 1); // 2000-01-01
        manager.addStudent("T10200812", "Trần Thị Hoa", true, dateOfBirth);

        // In danh sách tất cả sinh viên sau khi bổ sung
        System.out.println("\nDanh sách tất cả sinh viên sau khi bổ sung:");
        for (SinhVien student : manager.getAllStudents()) {
            System.out.println(student);
        }
    }
}
