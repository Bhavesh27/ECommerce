'use strict';
 
angular.module('myApp').factory('SupplierService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:9080/ECommerce/supplier/';
 
    var factory = {
        fetchAllUsers: fetchAllSuppliers,
        createUser: createSupplier,
        updateUser:updateSupplier,
        deleteUser:deleteSupplier
    };
 
    return factory;
 
    function fetchAllSuppliers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Suppliers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createSupplier(supplier) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, supplier)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Suppliers');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateSupplier(supplier, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, supplier)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Supplier');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteSupplier(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Supplier');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);