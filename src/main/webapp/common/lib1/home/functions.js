(function($) {
	"use strict";
	
	/*  [ Left menu trigger ]
	- - - - - - - - - - - - - - - - - - - - */
	$( '.menu-trigger' ).on('click', function() {
		$( '#left-menu .menu' ).toggleClass( 'active' );
	});

	/*  [ Shop cart ]
	- - - - - - - - - - - - - - - - - - - - */
/*	$( '.shop-cart' ).on( 'click', function() {
		$( 'body' ).toggleClass( 'shop-cart-open' );
		$( '.shop-item' ).toggleClass( 'active' );
	});*/

	/*  [ Responsive menu ]
	- - - - - - - - - - - - - - - - - - - - */
	$( '.mobile-menu' ).dlmenu();

	/*  [ Sticky menu ]
	- - - - - - - - - - - - - - - - - - - - */
	$( '#site-header .bot' ).scrollFix({
		fixClass: 'sticky',
	});

	/*  [ Custom RTL Menu ]
	- - - - - - - - - - - - - - - - - - - - */
	$( '.sub-menu li' ).hover( function() {
		var sub_menu = $( this ).find( ' > .sub-menu' );
		if ( sub_menu.length ) {
			if ( sub_menu.outerWidth() > ( $( window ).outerWidth() - sub_menu.offset().left ) ) {
				$( this ).addClass( 'rtl' );
			}
		}
	});

})(jQuery);