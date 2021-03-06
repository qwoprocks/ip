package chatterbox.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void checkDeadlineFormatting() {
        Deadline d = new Deadline("read book /by 20/1/2019 1800");
        assertEquals(d.inputString, "deadline read book /by 20/1/2019 1800");
        assertEquals(d.toString(), "[D][\u2717] read book (by: Jan 20 2019 1800H)");
        d.setDone(true);
        assertEquals(d.toString(), "[D][\u2713] read book (by: Jan 20 2019 1800H)");
    }
}
