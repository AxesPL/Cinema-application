$(document).ready(function(){
    var date_input=$('input[name="date"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    date_input.datepicker({
        format: 'dd-mm-yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    })
})
angular.module('app', [])
    .controller('ShowingController', function($http) {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10) {
        dd = '0'+dd
    }
    if(mm<10) {
        mm = '0'+mm
    }
    var dateshow = dd+'-'+mm+'-'+yyyy;
    console.log(dateshow);
    function refreshDate() {
        var button = document.getElementById("refresh-button");
        button.onclick = function () {
            var input = document.getElementById("date");
            dateshow=input.value;
            console.log(dateshow);
            url = "http://localhost:8080/api/showings/showingdate/"+dateshow;
            refreshData();
        }
    }
    refreshDate();
    var vm = this;
    var url="http://localhost:8080/api/showings/showingdate/"+dateshow;
    function refreshData() {
        $http({
            method: 'GET',
            url: url
        }).then(function success(response) {
            vm.showings = response.data;
            console.log(vm.showings);
        }, function error(response) {
            console.log('API error ' + response.status);
        });
    }
    vm.appName = 'Showing Manager';
 refreshData();
});

