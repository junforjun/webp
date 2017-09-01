var mapLoaded = false;

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
			enableHighAccuracy : false,
			maximumAge : 0,
			timeout : Infinity
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

function initAutocomplete() {
	mapLoaded = true;
	var map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : -33.8688,
			lng : 151.2195
		},
		zoom : 13,
		mapTypeId : 'roadmap'
	});

	// Create the search box and link it to the UI element.
	var input = document.getElementById('pac-input');
	var searchBox = new google.maps.places.SearchBox(input);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	// Bias the SearchBox results towards current map's viewport.
	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());
	});

	var markers = [];
	// Listen for the event fired when the user selects a prediction and
	// retrieve
	// more details for that place.
	searchBox.addListener('places_changed', function() {
		var places = searchBox.getPlaces();

		if (places.length == 0) {
			return;
		}

		// Clear out the old markers.
		markers.forEach(function(marker) {
			marker.setMap(null);
		});
		markers = [];

		// For each place, get the icon, name and location.
		var bounds = new google.maps.LatLngBounds();
		places.forEach(function(place) {
			if (!place.geometry) {
				console.log("Returned place contains no geometry");
				return;
			}
			var icon = {
				url : place.icon,
				size : new google.maps.Size(71, 71),
				origin : new google.maps.Point(0, 0),
				anchor : new google.maps.Point(17, 34),
				scaledSize : new google.maps.Size(25, 25)
			};

			// Create a marker for each place.
			markers.push(new google.maps.Marker({
				map : map,
				icon : icon,
				title : place.name,
				position : place.geometry.location
			}));

			if (place.geometry.viewport) {
				// Only geocodes have viewport.
				bounds.union(place.geometry.viewport);
			} else {
				bounds.extend(place.geometry.location);
			}
		});
		map.fitBounds(bounds);
	});
}

/**
 * on Function
 */
$(function() {
	$(".dropdown-menu li a").click(
			function() {
				var selText = $(this).text();
				$(this).parents('.btn-group').find('.dropdown-toggle').html(
						selText + '<span class="caret"></span>');
			});
})

$(function (){
	$("#mapCheck").click(
		function() {
			var checked = $(this).is(":checked");
			if (checked) {
				jQuery('#mapDiv').show();
				if(!mapLoaded) {
					jQuery('#map').html("<script src='https://maps.googleapis.com/maps/api/js?key=AIzaSyDx8Vpd0HQOU577Ik8IrNHAa5YzI_Lw_ng&libraries=places&callback=initAutocomplete' async defer></script>");
				}
			} else {
				jQuery('#mapDiv').hide();
			}  
		});
})

tinymce.init({
			selector : 'textarea',
			height : 500,
			theme : 'modern',
			plugins : [
					'advlist autolink lists link image charmap print preview hr anchor pagebreak',
					'searchreplace wordcount visualblocks visualchars code fullscreen',
					'insertdatetime media nonbreaking save table contextmenu directionality',
					'emoticons template paste textcolor colorpicker textpattern imagetools codesample toc help' ],
			toolbar1 : 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
			toolbar2 : 'print preview media | forecolor backcolor emoticons | codesample help',
			image_advtab : true,
			templates : [ {
				title : 'Test template 1',
				content : 'Test 1'
			}, {
				title : 'Test template 2',
				content : 'Test 2'
			} ],
			content_css : [
					'//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
					'//www.tinymce.com/css/codepen.min.css' ]
});

function writePost(level) {
	jQuery.ajax({
		type : "POST",
		url : "/writePost/",
		data : {
			"title" : $("#title").val(),
			"isMapIncluded" : $("#mapCheck").is(":checked"),
			"categoryCode" : $("#category").find('option:selected').val(),
			"contents" : tinyMCE.get("contents").getContent()
		},

		success : function(data) {

			if (data.startsWith("[")) {
				alert(data);
			} else {
				redirect("/" + data);
			}
		},
		complete : function(data) {
		},
		error : function(xhr, status, error) {
			alert("server error" + status);
		}
	});

}

