package za.co.wethinkcode.unnamed_project.src.unnamed.Events;

public interface Event {
    public boolean handled = false;

    EventType   GetEventType();
    String      GetName();
    int         GetCategoryFlags();

    boolean     IsInCategory(EventCategory category);
}
