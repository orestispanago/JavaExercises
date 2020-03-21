package privateschool;

import java.time.LocalDate;

public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
//    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
        MainClass.courses.add(this);
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public String getStart_dateString() {
        return start_date.format(MainClass.formatter);
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public String getEnd_dateString() {
        return end_date.format(MainClass.formatter);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return String.format("Course: %-7s %s %s %s to %s\n", title,
                stream, type, getStart_dateString(), getEnd_dateString());
    }
}
