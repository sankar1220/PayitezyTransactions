
function processReqService($http){
        this.processReq= function(url,type,data,success,error){
                $http({
                url:url,
                method:type,
                data:data,
                headers:{
                            'Content-Type': "application/json",
                            'Accept': "application/json"
                        }

                }).success(success).error(error);
                // if(success){
                //     swal({   title: "Success!",   text: "success",   type: "success",   confirmButtonText: "Success" });
                // }else{
                //      swal({   title: "Error!",   text: "err",   type: "err",   confirmButtonText: "err" });
                // }
                
            };

           this.search=function(){

           }; 
}
function processReqSirenFactory($http){
    return {
            processReq:function(url,type,data,success,error){
                $http({
                url:url,
                method:type,
                data:data,
                headers:{
                                      'Content-Type': "application/vnd.siren+json",
                                      'Accept': "application/vnd.siren+json"
                                }

                }).success(success)
                .error(error);
            },
            search:function(){

            }
        }
}

function baseURL(){
    return {
        IP:"http://192.168.0.111:8085"
    }
}
function nospace(){
     return function (value) {
        return (!value) ? '' : value.replace(/ /g, '');
    }
}



/**
 *
 * Pass all functions into module
 */
angular
    .module('Payitezy')
   
    .service('processReqService',processReqService)
    
    .service('baseURL',baseURL)
    .filter('nospace',nospace);
 
