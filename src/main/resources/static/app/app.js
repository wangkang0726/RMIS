var rmis = angular.module("rmis",[]);
rmis.controller("mainCtrl",function($scope, $http){
	$scope.curr = 'main';
	$http.get("/menus").success(function(data){
		$scope.menu = data;
	});
	$scope.mainUrl = "view/welcome.html"
		
	//
	$scope.changeMenu = function(item){
		$scope.mainUrl = "view/"+item.url;
	}
	
	$scope.goDetail = function(url){
		$scope.curr = 'second';
		$scope.secondUrl = "view/"+url
	}
});