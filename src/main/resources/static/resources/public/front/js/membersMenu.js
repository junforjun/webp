/**
 *
 */
$(function(){
  $("#menu").hover(function(){
    $('ul:first',this).show();
  }, function(){
    $('ul:first',this).hide();
  });