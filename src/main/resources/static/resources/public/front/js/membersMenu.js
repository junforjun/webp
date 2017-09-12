/**
 *
 */

$(function(){
  $("#menu").hover(
		  function(){
			 $('.myclnd').slideDown(500);
		  },
		  function(){
			 $('.myclnd').slideUp(500);
		  }
  );
});
//	$('.pass').focus(function(){
//		$('.pw-help').slideDown(500);
//	}).blur(function(){
//		$('.pw-help').slideUp(500);
//	});