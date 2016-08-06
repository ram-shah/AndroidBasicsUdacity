package com.example.android.reportcard;

/**
 * Created by ramshah on 7/23/16.
 */
public class ReportCard {
    private String mStudentName;
    private String mEnglishGrade;
    private String mChemistryGrade;
    private String mPhysicsGrade;
    private String mMathGrade;
    private String mHistoryGrade;

    public ReportCard(String studentName, String englishGrade, String chemistryGrade,
                      String physicsGrade, String mathGrade, String historyGrade) {
        this.mStudentName = studentName;
        this.mEnglishGrade = englishGrade;
        this.mChemistryGrade = chemistryGrade;
        this.mPhysicsGrade = physicsGrade;
        this.mMathGrade = mathGrade;
        this.mHistoryGrade = historyGrade;
    }

    public String getStudentName() {
        return mStudentName;
    }

    public void setStudentName(String studentName) {
        this.mStudentName = studentName;
    }

    public String getEnglishGrade() {
        return mEnglishGrade;
    }

    public void setEnglishGrade(String englishGrade) {
        this.mEnglishGrade = englishGrade;
    }

    public String getChemistryGrade() {
        return mChemistryGrade;
    }

    public void setChemistryGrade(String chemistryGrade) {
        this.mChemistryGrade = chemistryGrade;
    }

    public String getPhysicsGrade() {
        return mPhysicsGrade;
    }

    public void setPhysicsGrade(String physicsGrade) {
        this.mPhysicsGrade = physicsGrade;
    }

    public String getMathGrade() {
        return mMathGrade;
    }

    public void setMathGrade(String mathGrade) {
        this.mMathGrade = mathGrade;
    }

    public String getHistoryGrade() {
        return mHistoryGrade;
    }

    public void setHistoryGrade(String historyGrade) {
        this.mHistoryGrade = historyGrade;
    }

    @Override
    public String toString() {
        return "Student Name:    " + mStudentName + "\n" +
                "English Grade:   " + mEnglishGrade + "\n" +
                "Chemistry Grade: " + mChemistryGrade + "\n" +
                "Physics Grade:   " + mPhysicsGrade + "\n" +
                "Math Grade:      " + mMathGrade + "\n" +
                "History Grade:   " + mHistoryGrade;
    }
}