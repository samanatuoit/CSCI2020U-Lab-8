package sample;

public class StudentRecord {
    protected String SID;
    protected float assignment;
    protected float midterm;
    protected float finalExam;
    protected float finalMark;

    public StudentRecord(String SID, float assignment, float midterm, float finalExam) {
        this.SID = SID;
        this.assignment = assignment;
        this.midterm = midterm;
        this.finalExam = finalExam;

        calcMarks();
    }
    private void calcMarks() {
        finalMark = ((0.2f * assignment) + (0.3f * midterm) + (0.5f * finalExam));
    }
    public String getSID () {
        return SID;
    }
    public float getAssignment() {
        return assignment;
    }
    public float getMidterm() {
        return midterm;
    }
    public float getFinalExam() {
        return finalExam;
    }
    public float getFinalMark() {
        return finalMark;
    }
}
