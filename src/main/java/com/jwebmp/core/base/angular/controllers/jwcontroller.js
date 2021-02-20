jw.afterInit = function () {
};

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

    jw.env.parse = $parse;
    jw.env.timeout = $timeout;
    jw.env.rootScope = $rootScope;

    self.perform = jw.perform;
    self.makeCall = jw.makeCall;


    JW_SCOPE_INSERTIONS;
    JW_WATCHERS;
}); //end of controller
