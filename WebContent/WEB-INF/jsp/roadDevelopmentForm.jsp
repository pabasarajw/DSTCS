<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
  #mapCanvas {
    width: 620px;
    height: 520px;
    float: left;
  }
  #infoPanel {
    float: left;
    margin-left: 10px;
  }
  #infoPanel div {
    margin-bottom: 5px;
  }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Road Development Form</title>

<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link href="<c:url value="/resources/css/jquery.filthypillow.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/moment.js" />"></script>
<script src="<c:url value="/resources/js/jquery.filthypillow.js" />"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
var geocoder = new google.maps.Geocoder();

function geocodePosition(pos,loc) {
  geocoder.geocode({
    latLng: pos
  }, function(responses) {
    if (responses && responses.length > 0) {
      updateMarkerAddress(responses[0].formatted_address,loc);
    } else {
      updateMarkerAddress('Cannot determine address at this location.',loc);
    }
  });
}

function updateMarkerStatus(str,loc) {
	if(loc == 'from'){
		document.getElementById('markerStatus1').innerHTML = str;
	}else{
		document.getElementById('markerStatus2').innerHTML = str;
	}
}

function updateMarkerPosition(latLng,loc) {
	if(loc == 'from'){
		document.getElementById('fLatitude').value = latLng.lat();
		document.getElementById('fLongitude').value = latLng.lng();
	}else{
		document.getElementById('tLatitude').value = latLng.lat();
		document.getElementById('tLongitude').value = latLng.lng();
	}
}

function updateMarkerAddress(str,loc) {
	if(loc == 'from'){
		document.getElementById('fAddress').value = str;
	}else{
		document.getElementById('tAddress').value = str;
	}
}

function initialize() {
  var latLng1 = new google.maps.LatLng(6.9270786, 79.861243);
  var latLng2 = new google.maps.LatLng(6.928079747856545, 79.85883974072271);
  
  var map = new google.maps.Map(document.getElementById('mapCanvas'), {
    zoom: 8,
    center: latLng1,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });
  
  var marker1 = new google.maps.Marker({
    position: latLng1,
    title: 'Point A',
    map: map,
    draggable: true
  });
  
  var marker2 = new google.maps.Marker({
	    position: latLng2,
	    title: 'Point B',
	    map: map,
	    draggable: true
	  });
  
  // Update current position info.
  updateMarkerPosition(latLng1,"from");
  geocodePosition(latLng1,"from");
  
  updateMarkerPosition(latLng2,"to");
  geocodePosition(latLng2,"to");
  
  // Add dragging event listeners.
  google.maps.event.addListener(marker1, 'dragstart', function() {
    updateMarkerAddress('Dragging...',"from");
  });
  
  google.maps.event.addListener(marker1, 'drag', function() {
    updateMarkerStatus('Dragging...',"from");
    updateMarkerPosition(marker1.getPosition(),"from");
  });
  
  google.maps.event.addListener(marker1, 'dragend', function() {
    updateMarkerStatus('Drag ended',"from");
    geocodePosition(marker1.getPosition(),"from");
  });
  
  google.maps.event.addListener(marker2, 'dragstart', function() {
	    updateMarkerAddress('Dragging...',"to");
  });
  
  google.maps.event.addListener(marker2, 'drag', function() {
	    updateMarkerStatus('Dragging...',"to");
	    updateMarkerPosition(marker2.getPosition(),"to");
  });
  
  google.maps.event.addListener(marker2, 'dragend', function() {
    updateMarkerStatus('Drag ended',"to");
    geocodePosition(marker2.getPosition(),"to");
  });
}

// Onload handler to fire off the app.
google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>

	<div id="mapCanvas"></div>
	<div id="infoPanel">
  	<span style="color: green;">${msg}</span>
	<h2>Road Development Information</h2>
	<form:form method="POST" action="/DSTCS/saveroaddevelopmentinfo.html">
	   <table>
		    <tr>
		        <td>From Location</td>
		        <td><div id="markerStatus1"><i>Click and drag the Point A.</i></div></td>
		    </tr>
		    <tr>
		        <td><form:label path="fLatitude">Latitude</form:label></td>
		        <td><form:input path="fLatitude" id="fLatitude"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="fLongitude">Longitude</form:label></td>
		        <td><form:input path="fLongitude" id="fLongitude"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="fAddress">Address</form:label></td>
		        <td><form:textarea path="fAddress" id="fAddress"/></td>
		    </tr>
		    <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		    </tr>
		    <tr>
		        <td>To Location</td>
		        <td><div id="markerStatus2"><i>Click and drag the Point B.</i></div></td>
		    </tr>
		    <tr>
		        <td><form:label path="tLatitude" >Latitude</form:label></td>
		        <td><form:input path="tLatitude" id="tLatitude"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="tLongitude">Longitude</form:label></td>
		        <td><form:input path="tLongitude" id="tLongitude"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="tAddress">Address</form:label></td>
		        <td><form:textarea path="tAddress" id="tAddress"/></td>
		    </tr>
		    <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		    </tr>
		    <tr>
		        <td><form:label path="fromDate">From Date</form:label></td>
		        <td><form:input path="fromDate"  class="filthypillow-1"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="toDate">To Date</form:label></td>
		        <td><form:input path="toDate" class="filthypillow-2" /></td>
		    </tr>
		    <tr>
		        <td><form:label path="level">Level</form:label></td>
		        <td>
		        	<form:radiobutton path="level" value="high" checked="checked" />High
		        	<form:radiobutton path="level" value="middle" />Middle
		        	<form:radiobutton path="level" value="low" />Low
		        </td>
		    </tr>
		    <tr>
		        <td><form:label path="description">Description</form:label></td>
		        <td><form:textarea path="description" /></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>  
	</form:form>
	</div>
	<script type="text/javascript">
	    var $fp1 = $( ".filthypillow-1" );
	    initializeCalendar($fp1);
	    
	    var $fp2 = $( ".filthypillow-2" );
	    initializeCalendar($fp2);
	    
	    function initializeCalendar($fp){
	    	var now = moment( ).subtract( "days", 1 );
			$fp.filthypillow( { 
			  minDateTime: function( ) {
			    return now;
			  } 
			} );
			$fp.on( "focus", function( ) {
			  $fp.filthypillow( "show" );
			} );
			$fp.on( "fp:save", function( e, dateObj ) {
			  $fp.val( dateObj.format( "MMM DD YYYY hh:mm A" ) );
			  $fp.filthypillow( "hide" );
			} );
	    }
    </script> 
</body>
</html>