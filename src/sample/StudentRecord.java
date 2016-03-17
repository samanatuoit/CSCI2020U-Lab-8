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
        this.finalMark = ((0.2f * assignment) + (0.3f * midterm) + (0.5f * finalExam));
    }
    public String getSID () {
        return this.SID;
    }
    public float getAssignment() {
        return this.assignment;
    }
    public float getMidterm() {
        return this.midterm;
    }
    public float getFinalExam() {
        return this.finalExam;
    }
    public float getFinalMark() {
        return this.finalMark;
    }
}
