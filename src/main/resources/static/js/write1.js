
function initMap() {

	if (navigator.geolocation) { // GPS를 지원하면
	    navigator.geolocation.getCurrentPosition(function(position) {
	      var uluru = {
	    			lat : position.coords.latitude,
	    			lng : position.coords.longitude
	    		};
	        var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 15,
				center : uluru
			});
			var marker = new google.maps.Marker({
				position : uluru,
				map : map
			});

	    }, function(error) {
	      console.error(error);
	    }, {
	      enableHighAccuracy: false,
	      maximumAge: 0,
	      timeout: Infinity
	    });
	  } else {
			$.getJSON("http://ip-api.com/json/?callback=?", function(data) {
		        var uluru = {
		    			lat : data.lat,
		    			lng : data.lon
		    		};
		        var map = new google.maps.Map(document.getElementById('map'), {
					zoom : 15,
					center : uluru
				});
				var marker = new google.maps.Marker({
					position : uluru,
					map : map
				});
			});
	  }
}
/**
 * on Function
 */
$(function (){
	$(".dropdown-menu li a").click(
		function() {
			var selText = $(this).text();

			$(this).parents('.btn-group').find('.dropdown-toggle').html(
					selText + ' <span class="caret"></span>');
		});
})



tinymce.init({
		  selector: 'textarea',
		  height: 500,
		  theme: 'modern',
		  plugins: [
		    'advlist autolink lists link image charmap print preview hr anchor pagebreak',
		    'searchreplace wordcount visualblocks visualchars code fullscreen',
		    'insertdatetime media nonbreaking save table contextmenu directionality',
		    'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc help'
		  ],
		  toolbar1: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
		  toolbar2: 'print preview media | forecolor backcolor emoticons | codesample help',
		  image_advtab: true,
		  templates: [
		    { title: 'Test template 1', content: 'Test 1' },
		    { title: 'Test template 2', content: 'Test 2' }
		  ],
		  content_css: [
		    '//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
		    '//www.tinymce.com/css/codepen.min.css'
		  ]
		 });

