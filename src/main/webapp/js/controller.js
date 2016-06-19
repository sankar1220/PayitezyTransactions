function HeaderController ($scope,$rootScope,$location,$state) {
	/*console.log("
 _______  _______ _________                   _______  ______  _________
(  ___  )(  ____ )\__   __/|\     /||\     /|(  ____ \(  __  \ \__   __/
| (   ) || (    )|   ) (   | )   ( || )   ( || (    \/| (  \  )   ) (   
| (___) || (____)|   | |   | (___) || |   | || (__    | |   ) |   | |   
|  ___  ||     __)   | |   |  ___  |( (   ) )|  __)   | |   | |   | |   
| (   ) || (\ (      | |   | (   ) | \ \_/ / | (      | |   ) |   | |   
| )   ( || ) \ \__   | |   | )   ( |  \   /  | (____/\| (__/  )___) (___
|/     \||/   \__/   )_(   |/     \|   \_/   (_______/(______/ \_______/
                                                                        ");*/
	$scope.getSearchWindow=function(key){

$rootScope.key=key;
		$('input[name="productsSearch"]').focus();
		$('input[name="productsSearch"]').val(key);
		$('#modal-fullscreen').modal('show');
		
	}

/*$scope.getProductsFromAPI = function(key){
console.log(key)
}
*/

$scope.gotSelected=function(event){
/*	window.location.href='/rechargePage';
$(event.currentTarget).parents('.top_right').find('.o').removeClass('selected_li');
$(event.currentTarget).addClass('selected_li');*/
}

$scope.setSessionVariables=function(user,id){
	$rootScope.userName=user;
	$rootScope.userId=id;


}	
}


function ProductSearchController($scope,$rootScope,$http){
	$scope.searchKeywords = $rootScope.key;
$scope.getProductsFromAPI = function(key){
	
	if(key.length>3){
		$(".searchResults").html('<div class="text-center"><img src="/common/img/duck.gif" /></div>');
		$http({
			url : "/searchresults?searchkey="+key,
			method : "GET",
		}).success(function(data){

$(".searchResults").html('');
$(".searchResults").html(data);

		}).error(function(){

		});
	}
}
}


function MenuController($scope){

	$scope.menuStatus = true
$scope.toggleSnapdealMenu = function(){
$scope.menuStatus = !$scope.menuStatus
}
}


function MobileRechargeController($scope,$rootScope,$http,$state,processReqService){
	$rootScope.paymentsModalShowStatus = false;
$scope.getMobileRechargePlans = function(){
	$rootScope.rechargeMobileNumber = $scope.rechargeMobileNumber; 
	if($scope.rechargeMobileNumber.length>=10){
		$('#BillPaymentsModal').modal('show');
		$rootScope.paymentsModalShowStatus = true;
		BillTicketPaymentsModalWindowController($scope,$rootScope,processReqService);
	}
}

$scope.getDatacard=function(data){
	alert("dfdfd");
	var c=$scope.datacard_type;
}


$scope.show_tab=function(event){

		if($(event.currentTarget).children().attr('href')=="#mbl"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_1');
	};
		if($(event.currentTarget).children().attr('href')=="#dth"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_2');
	};
	if($(event.currentTarget).children().attr('href')=="#datacard"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_3');
	};
	if($(event.currentTarget).children().attr('href')=="#landline"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_4');
	};
	
	if($(event.currentTarget).children().attr('href')=="#electricity"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_5');
	};
	
	if($(event.currentTarget).children().attr('href')=="#bus"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_6');
	};
	
	if($(event.currentTarget).children().attr('href')=="#train"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_7');
	};
	
	if($(event.currentTarget).children().attr('href')=="#flights"){
			var find_var=$(event.currentTarget).parents('.page-content').find('.banner ').attr('class');
	$(event.currentTarget).parents('.page-content').find('.banner ').removeClass(find_var);
			$(event.currentTarget).parents('.page-content').find('#tab_img ').addClass('page-section banner').addClass('default_8');
	};
}

 $scope.getPlans=function(event){

 	if($scope.recharge_type =="prepaid_recharge"){

 	if($scope.number>1234567890){

 		$http({
 			url:"/prepaidMobileRechargePlan/plans/"+$scope.numberCircle+"/"+$scope.operator,
 			method:"GET",
 			header:{
 				'Content-Type':"application/json",
 				'Accept':"application.json"
 			}

 		}).success(function(data){
 			
 			$scope.pre_recharge_type = {};

for(var i in data){
var k = $scope.pre_recharge_type[data[i].recharge_type];
if(typeof k!="object"){
$scope.pre_recharge_type[data[i].recharge_type] = [];
$scope.pre_recharge_type[data[i].recharge_type].push(data[i]);
}else{
$scope.pre_recharge_type[data[i].recharge_type].push(data[i]);

}

}
$scope.twog = $scope.pre_recharge_type['2G Data'];
$scope.threeg = $scope.pre_recharge_type['3G Data'];
$scope.ft = $scope.pre_recharge_type['Full Talktime'];
$scope.isd = $scope.pre_recharge_type['ISD'];
$scope.l = $scope.pre_recharge_type['Local'];
$scope.other = $scope.pre_recharge_type['Other'];
$scope.roaming = $scope.pre_recharge_type['Roaming'];
$scope.sms = $scope.pre_recharge_type['SMS'];
$scope.std = $scope.pre_recharge_type['STD'];
$scope.tu = $scope.pre_recharge_type['Top up'];


console.log($scope.pre_recharge_type);


 		}).error(function(error){
 			alert("error");
 		})

 		
 		$(event.currentTarget).parents('#recharge_tab').find('.recharge_plans').addClass('show');
 		$(event.currentTarget).parents('#recharge_tab').find('.recharge_ads').addClass('hide');	
 		}else{
 		$(event.currentTarget).parents('#recharge_tab').find('.recharge_plans').removeClass('show');
 		
 		}
 	}else{
 			$(event.currentTarget).parents('#recharge_tab').find('.recharge_plans').removeClass('show');
 			$(event.currentTarget).parents("#recharge_tab").find('.brw_plans').addClass('hide');




 	}

 		if($scope.number.length>=4){


 			 			$http({
 				url:"/mobileOperator/operator/"+$scope.number,
 				method:"GET",

 				header:{
  'Content-Type': "application/json",
  'Accept': "application/json"
}

 			}).success(function(data){

 				
$scope.numberCircle=data.circle;
 					$scope.numberOperator = data.operator;
$scope.operator=data.operator;
$scope.operatorarray={};
if($scope.operator == "402880cb54a406510154a406e8920000"){
	$scope.aoperator="Airtel";
	$scope.operatorarray.finaloperator=$scope.aoperator;
}
if($scope.operator == "402880cb54a40bd70154a40c34200000"){
	$scope.voperator="Vodafone";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae27e7560000"){
	$scope.voperator="BSNL TopUp";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae28544a0001"){
	$scope.voperator="Reliance CDMA";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae018e0154ae2547760000"){
	$scope.voperator="Reliance GSM";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54a417130154a41bf1390001"){
	$scope.voperator="Aircel";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54a4034f0154a403967e0000"){
	$scope.voperator="Idea";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3ed8e40004"){
	$scope.voperator="Tata Indicom";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "10"){
	$scope.voperator="Loop Mobile";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3f31f50005"){
	$scope.voperator="Tata Docomo";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3f814b0006"){
	$scope.voperator="Virgin CDMA";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3fa79e0007"){
	$scope.voperator="MTS";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3fcac60008"){
	$scope.voperator="Virgin GSM";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae3fef6c0009"){
	$scope.voperator="Uninor";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.operator == "402880cb54ae26b90154ae401abc000a"){
	$scope.voperator="Videocon";
	$scope.operatorarray.finaloperator=$scope.voperator;
}


 			}).error(function(error){

 			})
$(event.currentTarget).parents('.srh-brd').find('.form-control_select1').trigger('focus');
$(event.currentTarget).parents('.srh-brd').find('.prenumber_input').trigger('focus');
 		}else{
 			$(event.currentTarget).parents('.srh-brd').find('.form-control_select1').val('');

 		$(event.currentTarget).parents("#recharge_tab").find('.brw_plans').removeClass('hide');

 		}

 		/*$(event.currentTarget).parents('.srh-brd').find('.form-control_select1').text();*/
 	
 }

 $scope.getPrepaidMobileRecharge=function(data) {

	$scope.rechrgedata={};
	$scope.rechrgedata['number']=$scope.number;
	$scope.rechrgedata['operator']=$scope.operator;
	$scope.rechrgedata['circle']=$scope.numberCircle;
	$scope.rechrgedata['amount']=$scope.amount;
	if($rootScope.userName!= null){
		
	$http({
		url:"/mobileRecharge/createPrepaidMobileRecharge",
		method:"POST",
		data:$scope.rechrgedata

	}).success(function(rechargedata){

		alert("Success:Successfully completed recharge");

	}).error(function(error){
			alert("Error:Please check the details");
	})

}else{
	window.location = '/login';
}

}



/*Postpaid Link*/
$scope.getPostpaidMobileBillPayment = function(data){
	$scope.mobilebilldata={};
	$scope.mobilebilldata['number']=$scope.postpaidnumber;
	$scope.mobilebilldata['operator']=$scope.postpaidoperator;
	$scope.mobilebilldata['circle']=$scope.numberCircle;
	$scope.mobilebilldata['amount']=$scope.billamount;
	if($rootScope.userName!= null){
		
	$http({
		url:"/mobileRecharge/createPostpaidMobileBillPayment",
		method:"POST",
		data:$scope.mobilebilldata

	}).success(function(data){

		alert("Success:Successfully completed recharge");

	}).error(function(error){
			alert("Error:Please check the details");
	})

}else{
	window.location = '/login';
}
}

$scope.getRechargeValue=function(data){

$scope.amount=$(event.currentTarget).text();
$(event.currentTarget).parents('.srh-brd').find('.amt').trigger('focus');
}


}
function BillTicketPaymentsModalWindowController($scope,$rootScope,processReqService){

$scope.rechargeMobileNumber = $rootScope.rechargeMobileNumber;
processReqService.processReq('http://api.datayuge.in/v6/mnp?apikey=aZciW2VAYLi3N6NkSUA3qRSBnyGt1A0A&number='+$scope.rechargeMobileNumber,'GET','',success,error);

var success = function(data){

$scope.rechargeOperator = data.operator;

}
var error = function(){
	alert("error");
}

}

function DatacardController($scope,$rootScope,processReqService,$http){
$scope.getDataCardPlans = function(event){
		
		if($scope.datacard_recharge_type =="prepaid_datacard"){

 	if($scope.datanumber>1234567890){
 		
 		$(event.currentTarget).parents('#datacard').find('.datacard_recharge_plans').addClass('show');
 		$(event.currentTarget).parents('#datacard').find('.recharge_ads').addClass('hide');	

 		}else{
 		$(event.currentTarget).parents('#datacard').find('.datacard_recharge_plans').removeClass('show');
 		
 		}
 	}else{
 			$(event.currentTarget).parents('#datacard').find('.datacard_recharge_plans').removeClass('show');
 			$(event.currentTarget).parents("#datacard").find('.brw_plans').addClass('hide');
 	}

if($scope.datanumber.length>=4){

 			 			$http({
 				url:"/mobileOperator/operator/"+$scope.datanumber,
 				method:"GET",

 				header:{
  'Content-Type': "application/json",
  'Accept': "application/json"
}

 			}).success(function(data){

 					$scope.numberOperator = data.operator;
$scope.datacard_operator=data.operator;
$scope.operatorarray={};
if($scope.datacard_operator == "1"){
	$scope.aoperator="Airtel";
	$scope.operatorarray.finaloperator=$scope.aoperator;
}
if($scope.datacard_operator == "2"){
	$scope.voperator="Vodafone";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "3"){
	$scope.voperator="BSNL TopUp";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "4"){
	$scope.voperator="Reliance CDMA";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "5"){
	$scope.voperator="Reliance GSM";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "6"){
	$scope.voperator="Aircel";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "8"){
	$scope.voperator="Idea";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "9"){
	$scope.voperator="Tata Indicom";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "10"){
	$scope.voperator="Loop Mobile";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "11"){
	$scope.voperator="Tata Docomo";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "12"){
	$scope.voperator="Virgin CDMA";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "13"){
	$scope.voperator="MTS";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "14"){
	$scope.voperator="Virgin GSM";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "16"){
	$scope.voperator="Uninor";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
if($scope.datacard_operator == "17"){
	$scope.voperator="Videocon";
	$scope.operatorarray.finaloperator=$scope.voperator;
}
$scope.numberCircle=data.circle;

 			}).error(function(error){

 			})

 		}else{
 			$(event.currentTarget).parents('.srh-brd').find('.form-control__datacard_select').val('');

 		$(event.currentTarget).parents("#datacard").find('.brw_plans').removeClass('hide');

 		}

	}

}

function DthPaymentController($scope,$rootScope,processReqService){
	$scope.getDthPlans = function(data){

			$(event.currentTarget).parents('#dth').find('.dth_payments_plans').addClass('show');
 
 		
	}
}

function LoginController($scope,$http,$rootScope){

	$scope.getRegisterNewUser= function(data){
		$scope.userDetails=data;
		$scope.userDetails['userType']='CUSTOMER';
		$scope.userDetails['status']='INACTIVE';
			$http({
 				url:"/users/create",
 				method:"POST",
 				data:$scope.userDetails,
 				header:{
  'Content-Type': "application/json",
  'Accept': "application/json"
}

 			}).success(function(data){
 				alert('Successfully Created');
 			}).error(function(){
 				alert('Error in Creating user');
 			});
	}
}



angular
	.module('Payitezy')
	.controller('HeaderController',HeaderController)
	.controller('ProductSearchController',ProductSearchController)
	.controller('MenuController',MenuController)
	.controller('MobileRechargeController',MobileRechargeController)
	.controller('BillTicketPaymentsModalWindowController',BillTicketPaymentsModalWindowController)
	.controller('DatacardController',DatacardController)
	.controller('DthPaymentController',DthPaymentController)
	.controller('LoginController',LoginController);
