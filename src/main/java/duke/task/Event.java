package duke.task;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return this.from.toString();
    }

    public String getTo() {
        return this.to.toString();
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " +
                from.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + " to: " +
                to.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + ")";
    }
}
