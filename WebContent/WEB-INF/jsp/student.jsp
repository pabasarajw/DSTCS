<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link href="<c:url value="/resources/css/jquery.filthypillow.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/moment.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.filthypillow.js" />"></script>
    <style>
      body {
        margin-top: 100px;
      }
    </style>
</head>
<body>
 <div class="filthypillow"></div>   
<h2>Student Information</h2>
<form:form method="POST" action="/DSTCS/addStudent.html">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" class="filthypillow-1"/></td>
    </tr>
    <tr>
        <td><form:label path="age">Age</form:label></td>
        <td><form:input path="age" class="filthypillow-2"/></td>
    </tr>
    <tr>
        <td><form:label path="id">id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
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