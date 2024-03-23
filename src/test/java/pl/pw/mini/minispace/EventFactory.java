package pl.pw.mini.minispace;

import pl.pw.mini.minispace.entities.Event;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventFactory {

    private static Long DEFAULT_ID = 2000L;
    private static Long NON_EXISTING_ID = 99999999L;
    private static String DEFAULT_DESCRIPTION = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
    private static UUID DEFAULT_UUID = UUID.fromString("957c7c1f-1ba6-41b6-a862-25047877b093");
    private static String DEFAULT_NAME = "MINIÓWKA - LAST DANCE";
    private static LocalDateTime DEFAULT_DATETIME = LocalDateTime.now().minusHours(1L);
    private static Long DEFAULT_VERSION = 0L;

    public static Event createValidEvent() {
        Event event = new Event();
        event.setId(DEFAULT_ID);
        event.setDescription(DEFAULT_DESCRIPTION);
        event.setUuid(DEFAULT_UUID);
        event.setName(DEFAULT_NAME);
        event.setDate(DEFAULT_DATETIME);
        event.setDateCreated(DEFAULT_DATETIME);
        event.setVersion(DEFAULT_VERSION);
        return event;
    }

    public static Event createNonExistingEvent() {
        Event event = new Event();
        event.setId(NON_EXISTING_ID);
        event.setDescription(DEFAULT_DESCRIPTION);
        event.setUuid(DEFAULT_UUID);
        event.setName(DEFAULT_NAME);
        event.setDate(DEFAULT_DATETIME);
        event.setDateCreated(DEFAULT_DATETIME);
        event.setVersion(DEFAULT_VERSION);
        return event;
    }
}
