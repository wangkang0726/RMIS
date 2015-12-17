var rmis = angular.module("rmis",[]);
rmis.controller("mainCtrl",function($scope, $http){
	$scope.main = true;
	$scope.pagePara = {};
	$http.get("/menus").success(function(data){
		$scope.menu = data;
		$scope.curr = data[0];
		$scope.mainUrl = "view/"+$scope.curr.url;
	});
		
	//
	$scope.changeMenu = function(item){
		$scope.main = true;
		$scope.curr = item;
		$scope.mainUrl = "view/"+item.url;
	}
	
	$scope.goDetail = function(url,para){
		$scope.main = false;
		$scope.pagePara = para;
		$scope.secondUrl = "view/"+url
	}
	$scope.backMain = function(){
		$scope.main = true;
	}
	$scope.goAdd = function(url){
		$scope.main = false;
		$scope.secondUrl = "view/"+url
	}
});