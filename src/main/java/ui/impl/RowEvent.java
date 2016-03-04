package ui.impl;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * 3/4/16
 *
 * @author {anobis}
 */
public class RowEvent extends Event {
    public static final EventType<RowEvent> ROW_ADDED = new EventType(ANY, "ROW_ADDED");

    public RowEvent() {
        this(ROW_ADDED);
    }

    public RowEvent(EventType<? extends Event> arg0) {
        super(arg0);
    }

    public RowEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
        super(arg0, arg1, arg2);
    }

}
