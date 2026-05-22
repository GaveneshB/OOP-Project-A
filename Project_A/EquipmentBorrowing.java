enum EquipmentType {
    LAPTOP, PROJECTOR, CAMERA, SENSOR_KIT
}

enum BorrowStatus {
    BORROWED, RETURNED, OVERDUE
}

public class EquipmentBorrowing{
    private String studentId;
    private EquipmentType equipmentType;
    private int borrowDays;
    private BorrowStatus status;

    public EquipmentBorrowing(String studentId, EquipmentType equipmentType, int borrowDays) {
        this.studentId = studentId;
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
}