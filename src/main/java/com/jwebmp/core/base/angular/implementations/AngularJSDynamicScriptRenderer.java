package com.jwebmp.core.base.angular.implementations;

import com.google.common.base.Strings;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.Script;
import com.jwebmp.core.services.IDynamicRenderingServlet;
import com.guicedee.guicedinjection.json.StaticStrings;
import com.guicedee.guicedinjection.GuiceContext;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import static com.guicedee.guicedinjection.GuiceContext.get;

public class AngularJSDynamicScriptRenderer
        implements IDynamicRenderingServlet<AngularJSDynamicScriptRenderer> {
    @Override
    public String getScriptLocation(Page<?> page) {
        String queryParams = "";
        try
        {
            HttpServletRequest hsr = get(HttpServletRequest.class);
            queryParams = hsr.getQueryString();
        }
        catch (Throwable T)
        {

        }
        return com.jwebmp.core.utilities.StaticStrings.ANGULAR_SCRIPT_LOCATION
                .replaceAll(StaticStrings.STRING_FORWARD_SLASH, StaticStrings.STRING_EMPTY) + "?" +  Strings.nullToEmpty(queryParams);
    }

    @Override
    public Script<?, ?> renderScript(Page<?> page) {
        if (!AngularPageConfigurator.isRequired()) {
            return null;
        }
        return getAngularScript(page);
    }

    /**
     * Method getAngularScript ...
     *
     * @return Script
     */
    private Script<?, ?> getAngularScript(Page<?> page) {
        StringBuilder jsAngular = GuiceContext.get(AngularPageConfigurator.class)
                .renderAngularJavascript(page);
        if (!jsAngular.toString()
                .trim()
                .isEmpty()) {
            return newScript(jsAngular.toString());
        }
        return null;
    }

    /**
     * Default Sort Order Integer.max - 950
     *
     * @return Integer.max - 950
     */
    @Override
    public Integer sortOrder() {
        return Integer.MAX_VALUE - 950;
    }

    @Override
    public boolean enabled() {
        return AngularPageConfigurator.isEnabled() && AngularPageConfigurator.isRequired();
    }


}
