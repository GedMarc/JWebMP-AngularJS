JW_APP_NAME.directive('websocket', ['$rootScope', '$interval', '$timeout', function ($rootScope, $interval, $timeout) {
    return {
        restrict: 'A',
        scope: {
            websocketGroup: '@websocketGroup',
            websocketData: '@websocketData'
        },

        controllerAs: 'vm',
        //bindToController: true,
        controller: ['$http', '$rootScope', '$scope', function ($http, $rootScope, $scope) {
            var vm = this;
            alert('adding to web socket group');
            jw.websocket.newMessage('AddToWebSocketGroup', {
                'websocketGroup': $scope.websocketGroup,
                'sessionid': jw.sessionstorage['sessionid'],
                'jwamsmk': jw.localstorage['jwamsmk'],
                'headers': jw.headers,
                'data': $scope.websocketData
            });

        }],

        link: function ($scope, element, attrs) {

            element.on('$destroy', function () {
                try {
                    alert('remving from web socket group');
                    jw.websocket.newMessage('RemoveFromWebSocketGroup', {
                        'websocketGroup': $scope.websocketGroup,
                        'sessionid': jw.sessionstorage['sessionid'],
                        'jwamsmk': jw.localstorage['jwamsmk'],
                        'headers': jw.headers,
                        'data': $scope.websocketData
                    });
                } catch (e) {

                }
            });

        }
    };
}]);
