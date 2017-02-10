'use strict';
 
angular.module('myApp').controller('SupplierController', ['$scope', 'SupplierService', function($scope, SupplierService) {
    var self = this;
    self.supplier={id:null,name:'',address:'',email:'',mobileno:''};
    self.suppliers=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllSuppliers();
 
    function fetchAllSuppliers(){
    	SupplierService.fetchAllSuppliers()
            .then(
            function(d) {
                self.suppliers = d;
            },
            function(errResponse){
                console.error('Error while fetching Suppliers');
            }
        );
    }
 
    function createSupplier(supplier){
    	SupplierService.createSupplier(supplier)
            .then(
            fetchAllSuppliers,
            function(errResponse){
                console.error('Error while creating Supplier');
            }
        );
    }
 
    function updateSupplier(supplier, id){
    	SupplierService.updateUser(supplier, id)
            .then(
            fetchAllSuppliers,
            function(errResponse){
                console.error('Error while updating Supplier');
            }
        );
    }
 
    function deleteSupplier(id){
    	SupplierService.deleteSupplier(id)
            .then(
            fetchAllSuppliers,
            function(errResponse){
                console.error('Error while deleting Supplier');
            }
        );
    }
 
    function submit() {
        if(self.supplier.id===null){
            console.log('Saving New Supplier', self.supplier);
            createSupplier(self.supplier);
        }else{
            updateSupplier(self.supplier, self.supplier.id);
            console.log('Supplier updated with id ', self.supplier.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.suppliers.length; i++){
            if(self.suppliers[i].id === id) {
                self.supplier = angular.copy(self.suppliers[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.supplier.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteSupplier(id);
    }
 
 
    function reset(){
        self.supplier={id:null,name:'',address:'',email:'',mobileno:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);