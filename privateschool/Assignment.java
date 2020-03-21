package privateschool;

import java.time.LocalDate;

public class Assignment {

    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
//    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Assignment(String title, String description, LocalDate subDateTime) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        MainClass.assignments.add(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public String getSubDateTimeString() {
        return subDateTime.format(MainClass.formatter);
    }

    public int getOralMark() {
        return oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    @Override
    public String toString() {
        return String.format("Assignment: %-7s %s %s\n", title,
                description, getSubDateTimeString());
    }
}
