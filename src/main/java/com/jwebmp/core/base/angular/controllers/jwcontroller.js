jw.afterInit = function () {
};

function getParametersObject() {
    try {
        var search = location.search.substring(1);
        return dataObject = JSON.parse('{"' + decodeURI(search).replace(/"/g, '\\"').replace(/&/g, '","').replace(/=/g, '":"') + '"}');
    } catch (err) {
        return {};
    }
}

JW_APP_NAME.controller('JW_APP_CONTROLLER', function ($scope
    , $compile
    , $parse
    , $timeout
    , $rootScope,
                                                      CONTROLLER_INSERTIONS
) {
    var self = this;
    self.jw = window.jw;
    jw.env.controller = self; //give external access to the body controller
    jw.env.scope = $scope;
    jw.angularLoading = true;

    /**
     * The event object that gets sent through
     * @param {type} $event jquery event
     * @param {type} compID the component ID to assign to a faux event
     * @returns {Object} The Event DTO
     */
    self.getEventObject = function ($event,compID) {
        var newEvent = {};
        if ($event !== undefined && $event !== null) {
            newEvent.altKey = $event.altKey;
            newEvent.ctrlKey = $event.ctrlKey;
            newEvent.bubbles = $event.bubbles;
            newEvent.cancelable = $event.cancelable;
            newEvent.clientX = $event.clientX;
            newEvent.clientY = $event.clientY;
            newEvent.componentID = $event.currentTarget.id;
            newEvent.detail = $event.detail;
            newEvent.eventPhase = $event.eventPhase;
            newEvent.metaKey = $event.metaKey;
            newEvent.offsetX = $event.offsetX;
            newEvent.offsetY = $event.offsetY;
            newEvent.pageX = $event.pageX;
            newEvent.pageY = $event.pageY;
            newEvent.screenX = $event.screenX;
            newEvent.screenY = $event.screenY;
            newEvent.shiftKey = $event.shiftKey;
            newEvent.type = $event.type;
            newEvent.data = $event.data;
            newEvent.target = $event.target.id;
            newEvent.which = $event.which;
            newEvent.parameters = getParametersObject();
        } else {
            newEvent.type = 'async';
            if(compID !== undefined && compID !== null)
                newEvent.componentID = compID;
            else {
                newEvent.componentID = 'body';
                newEvent.target = 'body';
            }
        }
        return newEvent;
    };

    self.makeCall = function(article){
        let bdy =  $('body');

        if(jw.websocket !== undefined && jw.websocket && jw.websocket.connected) {
            jw.websocket.newMessageNow('ajax', {"article": JSON.stringify(article)});
        }
        else {
            BEFORE_AJAX_CALL;
            $.ajax({
                type: "POST",
                url: "jwajax" + window.location.search,
                data: JSON.stringify(article),
                dataType: "json",
                contentType: 'application/json',
                mimeType: 'application/json',
                asynch: true,
                cache: true,
                beforeSend: function (xhr) {
                    try {
                        if (window.Pace) {
                            window.Pace.options.maxProgressPerFrame = 0.2;
                            window.Pace.stop();
                            window.Pace.start();
                            jw.isLoading = true;
                        }
                    } catch (e) {
                    }
                },
                converters: {
                    'json': true
                },
                success: function (result, status, xhr) {
                    try {
                        jw.actions.processResponse(result, $scope, $parse, $timeout, $compile, $rootScope);
                    } catch (e) {
                        console.log("Error in processing response : " + result);
                        console.log(e);
                    }
                    try {
                        jw.isLoading = false;
                        if (window.Pace) {
                            window.Pace.stop();
                            bdy.removeClass('pace-running');
                            bdy.removeClass('pace-done');
                            $(".loader").hide();
                        }
                    } catch (e) {
                    }
                },
                fail: function (xhr, textStatus, errorThrown) {
                    var err = eval("(" + xhr.responseText + ")");
                    if (BootstrapDialog) {
                        BootstrapDialog.show({
                            title: "Server Error",
                            message: "An error was encountered in the connection between the server and the client<br>" + textStatus + "<br>" + err + "<br>" + errorThrown,
                            type: BootstrapDialog.TYPE_DANGER,
                            buttons: [{
                                label: 'Close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                        });
                    }
                    try {
                        jw.isLoading = false;
                        if (window.Pace) {
                            window.Pace.stop();
                            bdy.removeClass('pace-running');
                            bdy.removeClass('pace-done');
                            $(".loader").hide();
                        }
                    } catch (e) {
                    }
                },
                complete: function (jqXHR, textStatus) {
                    try {
                        if (window.Pace) {
                            window.Pace.stop();
                            bdy.removeClass('pace-running');
                            bdy.removeClass('pace-done');
                            $(".loader").hide();
                        }
                    } catch (e) {
                    } finally {
                        jw.isLoading = false;
                        jw.angularLoading = false;
                        $("#preloader").remove();
                        $(".splashscreen").hide();
                        $(".loader").hide();
                    }
                }
            })
            AFTER_AJAX_CALL;
        }
    }

    self.makeEmptyArticle = function(compID,className,dataVariables){
        var article = {};
        article.parameters = getParametersObject();
        article.componentId = compID;
        article.eventType = 'undefined';
        article.eventTypeFrom = 'undefined';
        article.datetime = new Date();
        article.value = self.getEventObject(undefined,compID);
        article.eventId = compID;
        article.className = className;
        if (window.location.hash)
            article.hashbang = window.location.hash.substr(1);
        else
            article.hashbang = "";
        article.variableData = [];

        for (var i = 0; i < dataVariables.length; i++) {
            var arrItem = dataVariables[i];
            var jsonVariable = {};
            try {
                var data = $scope.$eval(arrItem);
                if (data !== 'undefined') {
                    jsonVariable.variableName = arrItem;
                    jsonVariable.variableText = data;
                    jsonVariable.$jwid = data.$jwid;
                    article.variableData.push(jsonVariable);
                }
            } catch (e) {
                jsonVariable.variableName = arrItem;
                jsonVariable.variableText = null;
                jsonVariable.$jwid = null;
                article.variableData.push(jsonVariable);
            }
        }
        return article;
    };

    /**
     * Loads up the initial variables into angular
     * @returns {undefined}
     */
    $scope._init = function () {

        var initData = self.makeEmptyArticle('body',undefined,[]);
        initData.parameters = getParametersObject();
        initData.parameters['objectId'] = 'body';
        initData.localStorage = jw.localstorage;
        initData.sessionStorage = jw.sessionstorage;

        jw.isLoading = true;
        try {
            if (window.Modernizr) {
                $scope.Modernizr = window.Modernizr;
                initData.modernizr = window.Modernizr;
            }
        } catch (e) {
            console.warn("modernizr not enabled");
        }

        BEFORE_INIT_CALL;
        self.makeCall(initData);
        AFTER_INIT_CALL;
    };

    $scope._init();

    /**
     * Performs a post send to the server
     * @param {type} $event
     * @param {type} dataVariables
     * @param {type} eventId
     *
     * @returns $.ajax
     */

    self.perform = function ($event, dataVariables, eventId, className) {
        jw.isLoading = true;
        if (window.Pace) {
            window.Pace.options.maxProgressPerFrame = 0.2;
            window.Pace.stop();
            window.Pace.start();
        }

        if(jw.websocket !== undefined && jw.websocket)
        {
            if(!jw.websocket.connected)
                jw.websocket.reconnect();
        }

        var eventStuff = self.getEventObject($event);
        var element = $event == null ? 'body' : $event.currentTarget.id;
        var article = self.makeEmptyArticle(element,className,dataVariables);
        article.eventType = eventStuff.type;
        article.eventTypeFrom = eventStuff.type;
        article.value = eventStuff;
        article.eventId = eventId;
        if (window.location.hash)
            article.hashbang = window.location.hash.substr(1);

        self.makeCall(article);
    };

    jw.perform = self.perform;

    JW_SCOPE_INSERTIONS;
    JW_WATCHERS;
}); //end of controller
