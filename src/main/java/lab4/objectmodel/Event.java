package lab4.objectmodel;

import java.lang.reflect.Method;

public class Event {
    private final Method action;
    private final Object cause;
    private final String description;

    Event(Object cause, Method action, String description) {
        this.cause = cause;
        this.action = action;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Method getAction() {
        return this.action;
    }

    public Object getCause() {
        return this.cause;
    }
}
