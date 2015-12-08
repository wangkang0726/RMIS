var rmis = angular.module("rmis",[]);
rmis.controller("mainCtrl",function($scope, $http){
	$scope.main = true;
	$http.get("/menus").success(function(data){
		$scope.menu = data;
	});
	$scope.mainUrl = "view/welcome.html"
		
	//
	$scope.changeMenu = function(item){
		$scope.mainUrl = "view/"+item.url;
	}
	
	$scope.goDetail = function(url){
		$scope.main = false;
		$scope.secondUrl = "view/"+url
	}
	$scope.backMain = function(){
		$scope.main = true;
	}
});