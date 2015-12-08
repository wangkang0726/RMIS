var rmis = angular.module("rmis",[]);
rmis.controller("mainCtrl",function($scope, $http){
	$http.get("/menus").success(function(data){
		$scope.menu = data;
	});
	$scope.url = "view/welcome.html"
		
	//
	$scope.changeMenu = function(item){
		$scope.url = "view/"+item.url;
	}
	
	$scope.goDetail = function(url){
		alert(url);
		$scope.url = "view/"+url
	}
});