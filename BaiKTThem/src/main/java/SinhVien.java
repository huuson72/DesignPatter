public class SinhVien {
    private int studentID;
    private String fullName;
    private boolean isMale;
    private String dateOfBirth;

    public SinhVien(int studentID, String fullName, boolean isMale, String dateOfBirth) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.isMale = isMale;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentID: " + studentID + ", FullName: " + fullName + ", IsMale: " + isMale + ", DateOfBirth: " + dateOfBirth;
    }
}

