$(function(){
	
	switch($("#hdnMenu").val()) {
	case "About Us":
		$("#about").addClass("active");
		break;
	case "Contact Us":
		$("#contact").addClass("active");
		break;	
	default:
		$("#home").addClass("active");
		break;
	
	}
	
	
});