'use strict';
 
angular.module('myApp').controller('SignupController', ['$scope', 'SignupService', function($scope, SignupService) {
    
    $scope.user={id:null,username:'',address:'',email:''};
    $scope.users=[];
 
    $scope.submit = submit;
    //$scope.edit = edit;
    //$scope.remove = remove;
    //$scope.reset = reset; 
 
 
    fetchAllUsers();
 
    function fetchAllUsers(){
        SignupService.fetchAllUsers()
            .then(
            function(d) {
                $scope.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user){
        SignupService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
 
    function submit() {
		if ($scope.user.id === null) {
			createUser($scope.user);
		
		} else {

			console.log('User updated with id ', $scope.user.id);
		}
	}
    
 
}]);