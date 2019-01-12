import com.jwebmp.core.base.angular.controllers.JWAngularController;
import com.jwebmp.core.base.angular.directives.events.activate.OnActivate;
import com.jwebmp.core.base.angular.directives.events.beforeactivate.OnBeforeActivate;
import com.jwebmp.core.base.angular.directives.events.beforeclose.OnBeforeClose;
import com.jwebmp.core.base.angular.directives.events.beforeload.OnBeforeLoad;
import com.jwebmp.core.base.angular.directives.events.beforestop.OnBeforeStop;
import com.jwebmp.core.base.angular.directives.events.blur.OnBlur;
import com.jwebmp.core.base.angular.directives.events.buttonclick.OnButtonClick;
import com.jwebmp.core.base.angular.directives.events.cancel.OnCancel;
import com.jwebmp.core.base.angular.directives.events.change.OnChange;
import com.jwebmp.core.base.angular.directives.events.checked.OnChecked;
import com.jwebmp.core.base.angular.directives.events.click.OnClicked;
import com.jwebmp.core.base.angular.directives.events.close.OnClose;
import com.jwebmp.core.base.angular.directives.events.complete.OnComplete;
import com.jwebmp.core.base.angular.directives.events.create.OnCreate;
import com.jwebmp.core.base.angular.directives.events.deactivate.OnDeActivate;
import com.jwebmp.core.base.angular.directives.events.drag.OnDrag;
import com.jwebmp.core.base.angular.directives.events.dragstart.OnDragStart;
import com.jwebmp.core.base.angular.directives.events.dragstop.OnDragStop;
import com.jwebmp.core.base.angular.directives.events.drop.OnDrop;
import com.jwebmp.core.base.angular.directives.events.dropout.OnDropOut;
import com.jwebmp.core.base.angular.directives.events.dropover.OnDropOver;
import com.jwebmp.core.base.angular.directives.events.focus.OnFocus;
import com.jwebmp.core.base.angular.directives.events.keydown.OnKeyDown;
import com.jwebmp.core.base.angular.directives.events.keypressed.OnKeyPressed;
import com.jwebmp.core.base.angular.directives.events.keyup.OnKeyUp;
import com.jwebmp.core.base.angular.directives.events.load.OnLoad;
import com.jwebmp.core.base.angular.directives.events.mousedown.OnMouseDown;
import com.jwebmp.core.base.angular.directives.events.mouseenter.OnMouseEnter;
import com.jwebmp.core.base.angular.directives.events.mousemove.OnMouseMove;
import com.jwebmp.core.base.angular.directives.events.mouseout.OnMouseOut;
import com.jwebmp.core.base.angular.directives.events.mouseover.OnMouseOver;
import com.jwebmp.core.base.angular.directives.events.mouseup.OnMouseUp;
import com.jwebmp.core.base.angular.directives.events.open.OnOpen;
import com.jwebmp.core.base.angular.directives.events.receive.OnReceive;
import com.jwebmp.core.base.angular.directives.events.remove.OnRemove;
import com.jwebmp.core.base.angular.directives.events.resize.OnResize;
import com.jwebmp.core.base.angular.directives.events.resizestart.OnResizeStart;
import com.jwebmp.core.base.angular.directives.events.resizestop.OnResizeStop;
import com.jwebmp.core.base.angular.directives.events.response.OnResponse;
import com.jwebmp.core.base.angular.directives.events.rightclick.OnRightClick;
import com.jwebmp.core.base.angular.directives.events.search.OnSearch;
import com.jwebmp.core.base.angular.directives.events.select.OnSelect;
import com.jwebmp.core.base.angular.directives.events.selected.OnSelected;
import com.jwebmp.core.base.angular.directives.events.selecting.OnSelecting;
import com.jwebmp.core.base.angular.directives.events.slide.OnSlide;
import com.jwebmp.core.base.angular.directives.events.sort.OnSort;
import com.jwebmp.core.base.angular.directives.events.spin.OnSpin;
import com.jwebmp.core.base.angular.directives.events.start.OnStart;
import com.jwebmp.core.base.angular.directives.events.stop.OnStop;
import com.jwebmp.core.base.angular.directives.events.submit.OnSubmit;
import com.jwebmp.core.base.angular.directives.events.unselected.OnUnselected;
import com.jwebmp.core.base.angular.directives.events.update.OnUpdate;
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

	provides com.jwebmp.core.events.activate.IOnActivateService with OnActivate;
	provides com.jwebmp.core.events.beforeactivate.IOnBeforeActivateService with OnBeforeActivate;
	provides com.jwebmp.core.events.beforeclose.IOnBeforeCloseService with OnBeforeClose;
	provides com.jwebmp.core.events.beforeload.IOnBeforeLoadService with OnBeforeLoad;
	provides com.jwebmp.core.events.beforestop.IOnBeforeStopService with OnBeforeStop;
	provides com.jwebmp.core.events.blur.IOnBlurService with OnBlur;
	provides com.jwebmp.core.events.buttonclick.IOnButtonClickService with OnButtonClick;
	provides com.jwebmp.core.events.cancel.IOnCancelService with OnCancel;
	provides com.jwebmp.core.events.change.IOnChangeService with OnChange;
	provides com.jwebmp.core.events.checked.IOnCheckedService with OnChecked;
	provides com.jwebmp.core.events.click.IOnClickService with OnClicked;
	provides com.jwebmp.core.events.close.IOnCloseService with OnClose;
	provides com.jwebmp.core.events.complete.IOnCompleteService with OnComplete;
	provides com.jwebmp.core.events.create.IOnCreateService with OnCreate;
	provides com.jwebmp.core.events.deactivate.IOnDeActivateService with OnDeActivate;
	provides com.jwebmp.core.events.drag.IOnDragService with OnDrag;
	provides com.jwebmp.core.events.dragstart.IOnDragStartService with OnDragStart;
	provides com.jwebmp.core.events.dragstop.IOnDragStopService with OnDragStop;
	provides com.jwebmp.core.events.drop.IOnDropService with OnDrop;
	provides com.jwebmp.core.events.dropout.IOnDropOutService with OnDropOut;
	provides com.jwebmp.core.events.dropover.IOnDropOverService with OnDropOver;
	provides com.jwebmp.core.events.focus.IOnFocusService with OnFocus;
	provides com.jwebmp.core.events.keydown.IOnKeyDownService with OnKeyDown;
	provides com.jwebmp.core.events.keypressed.IOnKeyPressedService with OnKeyPressed;
	provides com.jwebmp.core.events.keyup.IOnKeyUpService with OnKeyUp;
	provides com.jwebmp.core.events.load.IOnLoadService with OnLoad;
	provides com.jwebmp.core.events.mousedown.IOnMouseDownService with OnMouseDown;
	provides com.jwebmp.core.events.mouseenter.IOnMouseEnterService with OnMouseEnter;
	provides com.jwebmp.core.events.mousemove.IOnMouseMoveService with OnMouseMove;
	provides com.jwebmp.core.events.mouseout.IOnMouseOutService with OnMouseOut;
	provides com.jwebmp.core.events.mouseover.IOnMouseOverService with OnMouseOver;
	provides com.jwebmp.core.events.mouseup.IOnMouseUpService with OnMouseUp;
	provides com.jwebmp.core.events.open.IOnOpenService with OnOpen;
	provides com.jwebmp.core.events.receive.IOnReceiveService with OnReceive;
	provides com.jwebmp.core.events.remove.IOnRemoveService with OnRemove;
	provides com.jwebmp.core.events.resize.IOnResizeService with OnResize;
	provides com.jwebmp.core.events.resizestart.IOnResizeStartService with OnResizeStart;
	provides com.jwebmp.core.events.resizestop.IOnResizeStopService with OnResizeStop;
	provides com.jwebmp.core.events.response.IOnResponseService with OnResponse;
	provides com.jwebmp.core.events.rightclick.IOnRightClickService with OnRightClick;
	provides com.jwebmp.core.events.search.IOnSearchService with OnSearch;
	provides com.jwebmp.core.events.select.IOnSelectService with OnSelect;
	provides com.jwebmp.core.events.selected.IOnSelectedService with OnSelected;
	provides com.jwebmp.core.events.selecting.IOnSelectingService with OnSelecting;
	provides com.jwebmp.core.events.slide.IOnSlideService with OnSlide;
	provides com.jwebmp.core.events.sort.IOnSortService with OnSort;
	provides com.jwebmp.core.events.spin.IOnSpinService with OnSpin;
	provides com.jwebmp.core.events.start.IOnStartService with OnStart;
	provides com.jwebmp.core.events.stop.IOnStopService with OnStop;
	provides com.jwebmp.core.events.submit.IOnSubmitService with OnSubmit;
	provides com.jwebmp.core.events.unselected.IOnUnSelectedService with OnUnselected;
	provides com.jwebmp.core.events.update.IOnUpdateService with OnUpdate;


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
