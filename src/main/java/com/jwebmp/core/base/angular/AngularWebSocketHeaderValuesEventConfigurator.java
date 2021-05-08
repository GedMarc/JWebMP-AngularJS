package com.jwebmp.core.base.angular;

import com.jwebmp.core.Event;
import com.jwebmp.core.events.IEventConfigurator;
import jakarta.validation.constraints.NotNull;

public class AngularWebSocketHeaderValuesEventConfigurator implements IEventConfigurator<AngularWebSocketHeaderValuesEventConfigurator> {
    @Override
    public @NotNull Event<?, ?> configureEvent(Event<?, ?> event) {
        event.returnVariable("headers");
        return event;
    }

}
