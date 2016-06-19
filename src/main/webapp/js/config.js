

function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {

	$urlRouterProvider.otherwise("/Homepage/Main");

	$ocLazyLoadProvider.config({
		// Set to true if you want to see what and when is dynamically loaded
		debug: false
	});

	$stateProvider
		.state('Homepage',{
			abstract:true,
			url:"/Homepage",
			templateUrl:"templates/HomeFragment.html"
		})
		.state('Homepage.Main',{
			url:"/Main",
			templateUrl:"templates/MainSliderFragment.html"
		})
		.state('Products',{
			abstract:true,
			url:"/ProductsList",
			templateUrl:"templates/HomeFragment.html"
		})
		.state('Products.Category',{
			url:"/Category",
			templateUrl:"templates/ProductsFragment.html"
		})
		
		
	
}

angular
	.module('Payitezy')
	.config(config)
	.run(function($rootScope,$state){
		$rootScope.$state=$state;
	});