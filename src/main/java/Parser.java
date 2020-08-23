import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Parser {
    private static final String[] dateFormats = new String[] {
            "d/M/y HHmm", "d-M-y HHmm", "d/M/y", "d-M-y"
    };

    public static LocalDateTime parseDateTime(String dateTime) {
        DateFormat df = new SimpleDateFormat("MMM d yyyy HHmm'H'");
        for (String format : dateFormats) {
            try {
                Date d = new SimpleDateFormat(format).parse(dateTime);
                return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            } catch (ParseException ignored) {}
        }
        return null;
    }

    public static Task parse(String input) throws ChatterboxException {
        // Get first word of input
        String command = (input + " ").split(" ")[0];

        if (!input.contains(" ") || input.substring(input.indexOf(' ')).strip().equals("")) {
            throw new ChatterboxException("The description of a " + command + " cannot be empty");
        }
        String contents = input.substring(input.indexOf(' ') + 1);
        switch (command) {
        case "deadline":
            return new Deadline(contents);
        case "todo":
            return new ToDo(contents);
        case "event":
            return new Event(contents);
        default:
            throw new ChatterboxException("Invalid command.");
        }
    }
}
