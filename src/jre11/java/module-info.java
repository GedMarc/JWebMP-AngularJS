import com.jwebmp.core.base.angular.controllers.JWAngularController;
import com.jwebmp.core.base.angular.implementations.AngularJSDynamicScriptRenderer;
import com.jwebmp.core.base.angular.implementations.AngularJSOnCloak;
import com.jwebmp.core.base.angular.implementations.AngularJSServicesBindings;
import com.jwebmp.core.base.angular.implementations.AngularJSSiteBinder;
import com.jwebmp.core.base.angular.modules.AngularMessagesModule;
import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.core.databind.IOnDataBindCloak;
import com.jwebmp.core.services.IDynamicRenderingServlet;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;

module com.jwebmp.core.angularjs {
	requires com.jwebmp.core;
	requires java.validation;
	requires java.logging;
	requires com.jwebmp.logmaster;
	requires com.google.guice;
	requires com.jwebmp.guicedinjection;
	requires com.google.guice.extensions.servlet;
	requires com.jwebmp.guicedservlets;
	requires com.fasterxml.jackson.annotation;
	requires com.jwebmp.interception;
	requires com.fasterxml.jackson.databind;
	requires org.apache.commons.io;
	requires org.apache.commons.lang3;
	requires javax.servlet.api;

	exports com.jwebmp.core.base.angular;
	exports com.jwebmp.core.base.angular.directives;
	exports com.jwebmp.core.base.angular.controllers;
	exports com.jwebmp.core.base.angular.factories;
	exports com.jwebmp.core.base.angular.forms;
	exports com.jwebmp.core.base.angular.forms.enumerations;
	exports com.jwebmp.core.base.angular.modules;
	exports com.jwebmp.core.base.angular.configurations;

	exports com.jwebmp.core.base.angular.services;

	exports com.jwebmp.core.base.angular.directives.events.response;
	exports com.jwebmp.core.base.angular.directives.events.activate;
	exports com.jwebmp.core.base.angular.directives.events.beforeactivate;
	exports com.jwebmp.core.base.angular.directives.events.beforeclose;
	exports com.jwebmp.core.base.angular.directives.events.beforeload;
	exports com.jwebmp.core.base.angular.directives.events.beforestop;
	exports com.jwebmp.core.base.angular.directives.events.blur;
	exports com.jwebmp.core.base.angular.directives.events.buttonclick;
	exports com.jwebmp.core.base.angular.directives.events.cancel;
	exports com.jwebmp.core.base.angular.directives.events.change;
	exports com.jwebmp.core.base.angular.directives.events.checked;
	exports com.jwebmp.core.base.angular.directives.events.click;
	exports com.jwebmp.core.base.angular.directives.events.close;
	exports com.jwebmp.core.base.angular.directives.events.complete;
	exports com.jwebmp.core.base.angular.directives.events.create;
	exports com.jwebmp.core.base.angular.directives.events.deactivate;
	exports com.jwebmp.core.base.angular.directives.events.drag;
	exports com.jwebmp.core.base.angular.directives.events.dragstart;
	exports com.jwebmp.core.base.angular.directives.events.dragstop;
	exports com.jwebmp.core.base.angular.directives.events.drop;
	exports com.jwebmp.core.base.angular.directives.events.dropout;
	exports com.jwebmp.core.base.angular.directives.events.dropover;
	exports com.jwebmp.core.base.angular.directives.events.focus;
	exports com.jwebmp.core.base.angular.directives.events.keydown;
	exports com.jwebmp.core.base.angular.directives.events.keypressed;
	exports com.jwebmp.core.base.angular.directives.events.keyup;
	exports com.jwebmp.core.base.angular.directives.events.load;
	exports com.jwebmp.core.base.angular.directives.events.mousedown;
	exports com.jwebmp.core.base.angular.directives.events.mouseenter;
	exports com.jwebmp.core.base.angular.directives.events.mousemove;
	exports com.jwebmp.core.base.angular.directives.events.mouseout;
	exports com.jwebmp.core.base.angular.directives.events.mouseover;
	exports com.jwebmp.core.base.angular.directives.events.mouseup;
	exports com.jwebmp.core.base.angular.directives.events.open;
	exports com.jwebmp.core.base.angular.directives.events.receive;
	exports com.jwebmp.core.base.angular.directives.events.remove;
	exports com.jwebmp.core.base.angular.directives.events.resize;
	exports com.jwebmp.core.base.angular.directives.events.resizestart;
	exports com.jwebmp.core.base.angular.directives.events.resizestop;
	exports com.jwebmp.core.base.angular.directives.events.rightclick;
	exports com.jwebmp.core.base.angular.directives.events.search;
	exports com.jwebmp.core.base.angular.directives.events.select;
	exports com.jwebmp.core.base.angular.directives.events.selected;
	exports com.jwebmp.core.base.angular.directives.events.selecting;
	exports com.jwebmp.core.base.angular.directives.events.slide;
	exports com.jwebmp.core.base.angular.directives.events.sort;
	exports com.jwebmp.core.base.angular.directives.events.spin;
	exports com.jwebmp.core.base.angular.directives.events.start;
	exports com.jwebmp.core.base.angular.directives.events.stop;
	exports com.jwebmp.core.base.angular.directives.events.submit;
	exports com.jwebmp.core.base.angular.directives.events.unselected;
	exports com.jwebmp.core.base.angular.directives.events.update;

	uses IAngularDirective;
	uses IAngularControllerScopeStatement;
	uses IAngularModule;
	uses IAngularConfigurationScopeStatement;
	uses IAngularConfiguration;
	uses IAngularController;
	uses IAngularFactory;

	provides IAngularModule with AngularMessagesModule;
	provides IAngularController with JWAngularController;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder with AngularJSServicesBindings;
	provides IOnDataBindCloak with AngularJSOnCloak;
	provides IGuiceSiteBinder with AngularJSSiteBinder;
	provides IDynamicRenderingServlet with AngularJSDynamicScriptRenderer;

	provides IAngularDirective with com.jwebmp.core.base.angular.directives.events.activate.ActivateDirective,
			                           com.jwebmp.core.base.angular.directives.events.beforeactivate.BeforeActivateDirective,
			                           com.jwebmp.core.base.angular.directives.events.beforeclose.BeforeCloseDirective,
			                           com.jwebmp.core.base.angular.directives.events.beforeload.BeforeLoadDirective,
			                           com.jwebmp.core.base.angular.directives.events.beforestop.BeforeStopDirective,
			                           com.jwebmp.core.base.angular.directives.events.buttonclick.ButtonClickDirective,
			                           com.jwebmp.core.base.angular.directives.events.cancel.CancelDirective,
			                           com.jwebmp.core.base.angular.directives.events.close.CloseDirective,
			                           com.jwebmp.core.base.angular.directives.events.complete.CompleteDirective,
			                           com.jwebmp.core.base.angular.directives.events.create.CreateDirective,
			                           com.jwebmp.core.base.angular.directives.events.deactivate.DeactivateDirective,
			                           com.jwebmp.core.base.angular.directives.events.drag.DragDirective,
			                           com.jwebmp.core.base.angular.directives.events.dragstart.DragStartDirective,
			                           com.jwebmp.core.base.angular.directives.events.dragstop.DragStopDirective,
			                           com.jwebmp.core.base.angular.directives.events.drop.DropDirective,
			                           com.jwebmp.core.base.angular.directives.events.dropout.DropOutDirective,
			                           com.jwebmp.core.base.angular.directives.events.dropover.DropOverDirective,
			                           com.jwebmp.core.base.angular.directives.events.focus.FocusDirective,
			                           com.jwebmp.core.base.angular.directives.events.load.LoadDirective,
			                           com.jwebmp.core.base.angular.directives.events.receive.ReceiveDirective,
			                           com.jwebmp.core.base.angular.directives.events.remove.RemoveDirective,
			                           com.jwebmp.core.base.angular.directives.events.resize.ResizeDirective,
			                           com.jwebmp.core.base.angular.directives.events.resizestart.ResizeStartDirective,
			                           com.jwebmp.core.base.angular.directives.events.resizestop.ResizeStopDirective,
			                           com.jwebmp.core.base.angular.directives.events.response.ResponseDirective,
			                           com.jwebmp.core.base.angular.directives.events.rightclick.RightClickDirective,
			                           com.jwebmp.core.base.angular.directives.events.search.SearchDirective,
			                           com.jwebmp.core.base.angular.directives.events.select.SelectDirective,
			                           com.jwebmp.core.base.angular.directives.events.selecting.SelectingDirective,
			                           com.jwebmp.core.base.angular.directives.events.slide.SlideDirective,
			                           com.jwebmp.core.base.angular.directives.events.sort.SortDirective,
			                           com.jwebmp.core.base.angular.directives.events.spin.SpinDirective,
			                           com.jwebmp.core.base.angular.directives.events.start.StartDirective,
			                           com.jwebmp.core.base.angular.directives.events.stop.StopDirective,
			                           com.jwebmp.core.base.angular.directives.events.unselected.UnselectedDirective,
			                           com.jwebmp.core.base.angular.directives.events.update.UpdateDirective,
			                           com.jwebmp.core.base.angular.directives.events.click.ClickDisabledDirective;

	provides IPageConfigurator with com.jwebmp.core.base.angular.AngularPageConfigurator;

	opens com.jwebmp.core.base.angular.servlets to com.google.guice, com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.angular.implementations to com.google.guice, com.fasterxml.jackson.databind;

	opens com.jwebmp.core.base.angular.directives.events.response to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.activate to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.beforeactivate to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.beforeclose to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.beforeload to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.beforestop to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.blur to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.buttonclick to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.cancel to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.change to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.checked to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.click to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.close to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.complete to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.create to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.deactivate to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.drag to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.dragstart to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.dragstop to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.drop to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.dropout to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.dropover to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.focus to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.keydown to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.keypressed to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.keyup to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.load to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mousedown to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mouseenter to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mousemove to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mouseout to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mouseover to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.mouseup to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.open to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.receive to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.remove to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.resize to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.resizestart to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.resizestop to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.rightclick to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.search to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.select to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.selected to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.selecting to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.slide to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.sort to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.spin to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.start to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.stop to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.submit to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.unselected to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives.events.update to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;


	opens com.jwebmp.core.base.angular to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.directives to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.controllers to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.factories to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.forms to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.forms.enumerations to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.modules to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.core.base.angular.configurations to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;

	opens com.jwebmp.core.base.angular.services to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;

}
