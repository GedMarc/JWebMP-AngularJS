JW_APP_NAME.controller('JW_APP_CONTROLLER', function ($scope
    , $compile
    , $parse
    , $timeout
    , $rootScope,
                                                      CONTROLLER_INSERTIONS
) {
    var self = this;
    self.jw = window.jw;
    jw.env.controller = self;
    jw.env.scope = $scope;
    jw.angularLoading = true;


    $scope.headers = {};
    $scope.headers.useragent = jw.useragent;
    $scope.headers.referer = jw.referer;
    $scope.headers.myIP = jw.myIP;

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
        if(jw.websocket !== undefined && jw.websocket && jw.websocket.connected) {
            if (window.Pace) {
                window.Pace.start();
                jw.isLoading = true;
            }
            try {
                jw.websocket.newMessage('ajax', {"article": JSON.stringify(article)});
            }catch(e)
            {
                if (window.Pace) {
                    window.Pace.stop();
                    jw.isLoading = false;
                }
            }
            if (window.Pace) {
                window.Pace.stop();
                jw.isLoading = false;
            }
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

        let uniqueChars = [];
        dataVariables.forEach((c) => {
            if (!uniqueChars.includes(c)) {
                uniqueChars.push(c);
            }
        });

        for (var i = 0; i < uniqueChars.length; i++) {
            var arrItem = uniqueChars[i];
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
    jw.makeCall = self.makeCall;
    jw.makeEmptyArticle = self.makeEmptyArticle;

   // jw.perform = self.perform;

    JW_SCOPE_INSERTIONS;
    JW_WATCHERS;
}); //end of controller