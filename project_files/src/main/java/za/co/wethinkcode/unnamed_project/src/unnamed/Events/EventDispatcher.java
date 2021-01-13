package za.co.wethinkcode.unnamed_project.src.unnamed.Events;

import java.util.concurrent.Callable;

public class EventDispatcher {
    Event m_Event;

    public EventDispatcher(Event event) {
        this.m_Event = event;
    }

    // Create overloads for each type :(
    public <T, F> boolean Dispatch(Callable<F> func) {
/*
        if (m_Event.GetEventType() == T.GetStaticType()) {
            m_Event.handled |= func.call(T::m_Event);
            return true;
        }
*/
        return false;
    }
}
