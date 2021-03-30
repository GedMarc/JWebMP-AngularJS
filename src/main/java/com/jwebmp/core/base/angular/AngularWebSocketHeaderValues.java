package com.jwebmp.core.base.angular;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;
import jakarta.validation.constraints.NotNull;

public class AngularWebSocketHeaderValues implements IEventConfigurator<AngularWebSocketHeaderValues> {
    @Override
    public @NotNull Event<?, ?> configureEvent(Event<?, ?> event) {
        event.returnVariable("headers");
        return event;
    }

}
