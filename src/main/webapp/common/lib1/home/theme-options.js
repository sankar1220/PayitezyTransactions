(function($) {

	function woorockets_option_reset_CLICK(){
		return false;
	}

	$(document).ready(function($) {     
		woorockets_style_switch_INIT();
		$('.choose-color a.brown').addClass('active');
	});

	function woorockets_style_switch_INIT(){   
		
		// Color Change
		
		$("a.brown" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/brown.css");
			return false;
		});
		
		$("a.orange" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/orange.css");
			return false;
		});
		
		$("a.blue" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/blue.css");
			return false;
		});
		
		$("a.green" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/green.css");
			return false;
		});
		
		$("a.yellow" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/yellow.css");
			return false;
		});

		$("a.red" ).click(function(){
			$("#wooplus-colors" ).attr("href", "css/colors/red.css");
			return false;
		});
		
		$('.choose-color a').click(function(e){
			e.preventDefault();
			$(this).parent().parent().find('a').removeClass('active');
			$(this).addClass('active');
		});
		// Reset
		$('a.reset').click(function(e){
			$('.color.brown').trigger('click');
		});
	}

	$(window).load(function() {
		// Switcher Layout
		$('#theme-option').animate({
			left: '-200px'
		});
			
		$('.open-close-button').click(function(e){
			e.preventDefault();
			var div = $('#theme-option');
			if (div.css('left') === '-200px') {
				$('#theme-option').animate({
					left: '0px'
				}); 
			} else {
				$('#theme-option').animate({
					left: '-200px'
				});
			}
		});
	});

})(jQuery);