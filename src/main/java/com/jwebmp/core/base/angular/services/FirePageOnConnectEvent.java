package com.jwebmp.core.base.angular.services;

import com.guicedee.guicedinjection.GuiceContext;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.BodyEvents;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.events.commandevent.OnComponentLoadedEvent;
import com.jwebmp.core.services.IPage;

/**
 * Fires the on connect method in page, configured like any other event
 *
 */
public class FirePageOnConnectEvent  extends OnComponentLoadedEvent<FirePageOnConnectEvent>
        implements BodyEvents<GlobalFeatures,FirePageOnConnectEvent> {

    public FirePageOnConnectEvent() {
        this(null);
    }

    public FirePageOnConnectEvent(IComponentHierarchyBase<?, ?> component) {
        super(component);
    }

    @Override
    public void perform(AjaxCall<?> call, AjaxResponse<?> response) {
        IPage<?> page = GuiceContext.get(IPage.class);
        page.onConnect(call, response);
    }
}
