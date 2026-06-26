
class IssueReport extends ServiceRecord {

    enum IssueType {
        ELECTRICAL, NETWORK, FURNITURE, CLEANLINESS, AIR_CONDITIONING
    }

    enum PriorityLevel {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    enum ReportStatus {
        OPEN, IN_PROGRESS, RESOLVED, CLOSED
    }

    private IssueType issueType;
    private PriorityLevel priority;
    private ReportStatus status;

    public IssueReport(String studentId, IssueType issueType, PriorityLevel priority) {
        super(studentId);
        this.issueType = issueType;
        this.priority = priority;
        this.status = ReportStatus.OPEN;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public void displayRecord() {
        System.out.println("Student ID    : " + studentId);
        System.out.println("Issue Type    : " + issueType);
        System.out.println("Priority      : " + priority);
        System.out.println("Status        : " + status);
    }
}
