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