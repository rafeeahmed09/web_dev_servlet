package Student_online_Admission_from;

public class Student_OOPSs {
    /* Admission Dashboard*/
    private int id;
    private String candidateName;
    private String motherName;
    private String subject;
    private double subjectFee;
    private String registeredEarlier;
    private String educationalBackground;

    public Student_OOPSs() {
    }

    public Student_OOPSs(
            int id,
            String candidateName,
            String motherName,
            String subject,
            double subjectFee,
            String registeredEarlier,
            String educationalBackground) {
        this.id = id;
        this.candidateName = candidateName;
        this.motherName = motherName;
        this.subject = subject;
        this.subjectFee = subjectFee;
        this.registeredEarlier = registeredEarlier;
        this.educationalBackground = educationalBackground;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getSubjectFee() {
        return subjectFee;
    }

    public void setSubjectFee(double subjectFee) {
        this.subjectFee = subjectFee;
    }

    public String getRegisteredEarlier() {
        return registeredEarlier;
    }

    public void setRegisteredEarlier(String registeredEarlier) {
        this.registeredEarlier = registeredEarlier;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }


}
