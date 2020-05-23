module com.jwebmp.core.angularjs {
	requires com.jwebmp.core;
	requires java.validation;
	requires java.logging;
	requires com.guicedee.logmaster;
	requires com.google.guice;
	requires com.guicedee.guicedinjection;
	requires com.google.guice.extensions.servlet;
	requires com.guicedee.guicedservlets;
	requires com.fasterxml.jackson.annotation;
	requires com.jwebmp.interception;
	requires com.fasterxml.jackson.databind;
	requires org.apache.commons.io;
	requires org.apache.commons.lang3;
	requires java.servlet;
	requires com.guicedee.guicedservlets.websockets;

	exports com.jwebmp.core.base.angular;
	exports com.jwebmp.core.base.angular.directives;
	exports com.jwebmp.core.base.angular.controllers;
	exports com.jwebmp.core.base.angular.factories;
	exports com.jwebmp.core.base.angular.forms;
	exports com.jwebmp.core.base.angular.forms.enumerations;
	exports com.jwebmp.core.base.angular.modules;
	exports com.jwebmp.core.base.angular.configurations;

	exports com.jwebmp.core.base.angular.services;

	provides com.jwebmp.core.base.angular.services.IAngularControllerScopeStatement with com.jwebmp.core.base.angular.implementations.WebSocketControllerStatement;

	provides com.jwebmp.core.events.activate.IOnActivateService with com.jwebmp.core.base.angular.directives.events.activate.OnActivate;
	provides com.jwebmp.core.events.beforeactivate.IOnBeforeActivateService with com.jwebmp.core.base.angular.directives.events.beforeactivate.OnBeforeActivate;
	provides com.jwebmp.core.events.beforeclose.IOnBeforeCloseService with com.jwebmp.core.base.angular.directives.events.beforeclose.OnBeforeClose;
	provides com.jwebmp.core.events.beforeload.IOnBeforeLoadService with com.jwebmp.core.base.angular.directives.events.beforeload.OnBeforeLoad;
	provides com.jwebmp.core.events.beforestop.IOnBeforeStopService with com.jwebmp.core.base.angular.directives.events.beforestop.OnBeforeStop;
	provides com.jwebmp.core.events.blur.IOnBlurService with com.jwebmp.core.base.angular.directives.events.blur.OnBlur;
	provides com.jwebmp.core.events.buttonclick.IOnButtonClickService with com.jwebmp.core.base.angular.directives.events.buttonclick.OnButtonClick;
	provides com.jwebmp.core.events.cancel.IOnCancelService with com.jwebmp.core.base.angular.directives.events.cancel.OnCancel;
	provides com.jwebmp.core.events.change.IOnChangeService with com.jwebmp.core.base.angular.directives.events.change.OnChange;
	provides com.jwebmp.core.events.checked.IOnCheckedService with com.jwebmp.core.base.angular.directives.events.checked.OnChecked;
	provides com.jwebmp.core.events.click.IOnClickService with com.jwebmp.core.base.angular.directives.events.click.OnClicked;
	provides com.jwebmp.core.events.close.IOnCloseService with com.jwebmp.core.base.angular.directives.events.close.OnClose;
	provides com.jwebmp.core.events.complete.IOnCompleteService with com.jwebmp.core.base.angular.directives.events.complete.OnComplete;
	provides com.jwebmp.core.events.create.IOnCreateService with com.jwebmp.core.base.angular.directives.events.create.OnCreate;
	provides com.jwebmp.core.events.deactivate.IOnDeActivateService with com.jwebmp.core.base.angular.directives.events.deactivate.OnDeActivate;
	provides com.jwebmp.core.events.drag.IOnDragService with com.jwebmp.core.base.angular.directives.events.drag.OnDrag;
	provides com.jwebmp.core.events.dragstart.IOnDragStartService with com.jwebmp.core.base.angular.directives.events.dragstart.OnDragStart;
	provides com.jwebmp.core.events.dragstop.IOnDragStopService with com.jwebmp.core.base.angular.directives.events.dragstop.OnDragStop;
	provides com.jwebmp.core.events.drop.IOnDropService with com.jwebmp.core.base.angular.directives.events.drop.OnDrop;
	provides com.jwebmp.core.events.dropout.IOnDropOutService with com.jwebmp.core.base.angular.directives.events.dropout.OnDropOut;
	provides com.jwebmp.core.events.dropover.IOnDropOverService with com.jwebmp.core.base.angular.directives.events.dropover.OnDropOver;
	provides com.jwebmp.core.events.focus.IOnFocusService with com.jwebmp.core.base.angular.directives.events.focus.OnFocus;
	provides com.jwebmp.core.events.keydown.IOnKeyDownService with com.jwebmp.core.base.angular.directives.events.keydown.OnKeyDown;
	provides com.jwebmp.core.events.keypressed.IOnKeyPressedService with com.jwebmp.core.base.angular.directives.events.keypressed.OnKeyPressed;
	provides com.jwebmp.core.events.keyup.IOnKeyUpService with com.jwebmp.core.base.angular.directives.events.keyup.OnKeyUp;
	provides com.jwebmp.core.events.load.IOnLoadService with com.jwebmp.core.base.angular.directives.events.load.OnLoad;
	provides com.jwebmp.core.events.mousedown.IOnMouseDownService with com.jwebmp.core.base.angular.directives.events.mousedown.OnMouseDown;
	provides com.jwebmp.core.events.mouseenter.IOnMouseEnterService with com.jwebmp.core.base.angular.directives.events.mouseenter.OnMouseEnter;
	provides com.jwebmp.core.events.mousemove.IOnMouseMoveService with com.jwebmp.core.base.angular.directives.events.mousemove.OnMouseMove;
	provides com.jwebmp.core.events.mouseout.IOnMouseOutService with com.jwebmp.core.base.angular.directives.events.mouseout.OnMouseOut;
	provides com.jwebmp.core.events.mouseover.IOnMouseOverService with com.jwebmp.core.base.angular.directives.events.mouseover.OnMouseOver;
	provides com.jwebmp.core.events.mouseup.IOnMouseUpService with com.jwebmp.core.base.angular.directives.events.mouseup.OnMouseUp;
	provides com.jwebmp.core.events.open.IOnOpenService with com.jwebmp.core.base.angular.directives.events.open.OnOpen;
	provides com.jwebmp.core.events.receive.IOnReceiveService with com.jwebmp.core.base.angular.directives.events.receive.OnReceive;
	provides com.jwebmp.core.events.remove.IOnRemoveService with com.jwebmp.core.base.angular.directives.events.remove.OnRemove;
	provides com.jwebmp.core.events.resize.IOnResizeService with com.jwebmp.core.base.angular.directives.events.resize.OnResize;
	provides com.jwebmp.core.events.resizestart.IOnResizeStartService with com.jwebmp.core.base.angular.directives.events.resizestart.OnResizeStart;
	provides com.jwebmp.core.events.resizestop.IOnResizeStopService with com.jwebmp.core.base.angular.directives.events.resizestop.OnResizeStop;
	provides com.jwebmp.core.events.response.IOnResponseService with com.jwebmp.core.base.angular.directives.events.response.OnResponse;
	provides com.jwebmp.core.events.rightclick.IOnRightClickService with com.jwebmp.core.base.angular.directives.events.rightclick.OnRightClick;
	provides com.jwebmp.core.events.search.IOnSearchService with com.jwebmp.core.base.angular.directives.events.search.OnSearch;
	provides com.jwebmp.core.events.select.IOnSelectService with com.jwebmp.core.base.angular.directives.events.select.OnSelect;
	provides com.jwebmp.core.events.selected.IOnSelectedService with com.jwebmp.core.base.angular.directives.events.selected.OnSelected;
	provides com.jwebmp.core.events.selecting.IOnSelectingService with com.jwebmp.core.base.angular.directives.events.selecting.OnSelecting;
	provides com.jwebmp.core.events.slide.IOnSlideService with com.jwebmp.core.base.angular.directives.events.slide.OnSlide;
	provides com.jwebmp.core.events.sort.IOnSortService with com.jwebmp.core.base.angular.directives.events.sort.OnSort;
	provides com.jwebmp.core.events.spin.IOnSpinService with com.jwebmp.core.base.angular.directives.events.spin.OnSpin;
	provides com.jwebmp.core.events.start.IOnStartService with com.jwebmp.core.base.angular.directives.events.start.OnStart;
	provides com.jwebmp.core.events.stop.IOnStopService with com.jwebmp.core.base.angular.directives.events.stop.OnStop;
	provides com.jwebmp.core.events.submit.IOnSubmitService with com.jwebmp.core.base.angular.directives.events.submit.OnSubmit;
	provides com.jwebmp.core.events.unselected.IOnUnSelectedService with com.jwebmp.core.base.angular.directives.events.unselected.OnUnselected;
	provides com.jwebmp.core.events.update.IOnUpdateService with com.jwebmp.core.base.angular.directives.events.update.OnUpdate;


	uses com.jwebmp.core.base.angular.services.IAngularDirective;
	uses com.jwebmp.core.base.angular.services.IAngularControllerScopeStatement;
	uses com.jwebmp.core.base.angular.services.IAngularModule;
	uses com.jwebmp.core.base.angular.services.IAngularConfigurationScopeStatement;
	uses com.jwebmp.core.base.angular.services.IAngularConfiguration;
	uses com.jwebmp.core.base.angular.services.IAngularController;
	uses com.jwebmp.core.base.angular.services.IAngularFactory;

	uses com.guicedee.guicedservlets.websockets.services.IWebSocketAuthDataProvider;

	provides com.jwebmp.core.base.angular.services.IAngularModule with com.jwebmp.core.base.angular.modules.AngularMessagesModule;
	provides com.jwebmp.core.base.angular.services.IAngularController with com.jwebmp.core.base.angular.controllers.JWAngularController;

	provides com.guicedee.guicedinjection.interfaces.IGuiceDefaultBinder with com.jwebmp.core.base.angular.implementations.AngularJSServicesBindings;

	provides com.jwebmp.core.databind.IOnDataBindCloak with com.jwebmp.core.base.angular.implementations.AngularJSOnCloak;
	provides com.jwebmp.core.databind.IOnDataBind with com.jwebmp.core.base.angular.implementations.AngularJSOnBind;


	provides com.guicedee.guicedservlets.services.IGuiceSiteBinder with com.jwebmp.core.base.angular.implementations.AngularJSSiteBinder;
	provides com.jwebmp.core.services.IDynamicRenderingServlet with com.jwebmp.core.base.angular.implementations.AngularJSDynamicScriptRenderer;

	provides com.jwebmp.core.base.angular.services.IAngularDirective with com.jwebmp.core.base.angular.directives.events.activate.ActivateDirective,
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

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.core.base.angular.AngularPageConfigurator;

	opens com.jwebmp.core.base.angular.servlets to com.google.guice, com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.angular.implementations to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;

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
