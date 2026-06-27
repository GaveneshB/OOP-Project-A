public class EquipmentBorrowing extends ServiceRecord{
    enum EquipmentType {
        LAPTOP, PROJECTOR, CAMERA, SENSOR_KIT
    }

    enum BorrowStatus {
        BORROWED, RETURNED, OVERDUE
    }

    private EquipmentType equipmentType;
    private int borrowDays;
    private BorrowStatus status;

    public EquipmentBorrowing(String studentId, EquipmentType equipmentType, int borrowDays) {
        super(studentId);

        if (borrowDays <= 0) {
        throw new IllegalArgumentException("Borrow days must be greater than 0.");
    }

        this.equipmentType = equipmentType;
        this.borrowDays = borrowDays;
        this.status = BorrowStatus.BORROWED;
    }

    public String getStudentId() {
        return studentId;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setBorrowDays(int borrowDays) {
        this.borrowDays = borrowDays;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public String getDurationStatus() {
        if (borrowDays >= 1 && borrowDays <= 3) {
            return "Normal borrowing";
        } else if (borrowDays >= 4 && borrowDays <= 7) {
            return "Extended borrowing";
        } else {
            return "Requires special approval";
        }
    }

    @Override
    public void displayRecord() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Equipment Type: " + equipmentType);
        System.out.println("Borrow Days: " + borrowDays);
        System.out.println("Status: " + status);
        System.out.println("Duration Status: " + getDurationStatus());
    }
}