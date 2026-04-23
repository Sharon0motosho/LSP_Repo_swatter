package org.howard.edu.lsp.finalexam.question2;

class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    protected void formatHeader() {
        System.out.println("=== HEADER ===");
        System.out.println("Course Report\n");
    }

    protected void formatBody() {
        System.out.println("=== BODY ===");
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment + "\n");
    }

    protected void formatFooter() {
        System.out.println("=== FOOTER ===");
        System.out.println("End of Course Report\n");
    }
}
