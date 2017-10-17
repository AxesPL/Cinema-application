angular.module('appTicket', ['ngRoute'])
    .config(function ($routeProvider, $locationProvider) {
        $routeProvider.when('/tickets/:showingid', {
            controller: 'TicketController'
        });
        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
    })
    .controller('TicketController', ['$route','$http' ,'$routeParams','$location',
        function ($route, $http, $routeParams,$location){
            var vm = this;
            var showingid =  $location.search().showingid;


            console.log(showingid);
            var url="http://localhost:8080/api/tickets/"+showingid;
            function refreshData() {
                $http({
                    method: 'GET',
                    url: url
                }).then(function success(response) {
                    vm.tickets = response.data;
                    console.log(vm.tickets);
                }, function error(response) {
                    console.log('API error ' + response.status);
                });
            }
            vm.appName = 'Ticket Manager';
            refreshData();
        }]);