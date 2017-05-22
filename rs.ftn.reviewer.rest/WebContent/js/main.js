/**
 * 
 */

var rootURL = "../rs.ftn.reviewer.rest/rest/proizvodi/add";
var rootURL2 = "../rs.ftn.reviewer.rest/rest/proizvodi/getGroup";


$(document).on('submit', '.productsform', function(e) {
	e.preventDefault();
	console.log("add product");
//	var id = $(this).find("input[name=id]").val();
	var name = $(this).find("input[name=naziv]").val();
	$.ajax({
		type : 'POST',
		url : rootURL,
		contentType : 'application/json',
		dataType : "text",
		data : formToJSON(name),
		success : function(data) {
			toastr.options = {
					  "closeButton": true,
					  "debug": false,
					  "newestOnTop": false,
					  "progressBar": false,
					  "positionClass": "toast-top-right",
					  "preventDuplicates": false,
					  "onclick": null,
					  "showDuration": "300",
					  "hideDuration": "1000",
					  "timeOut": "5000",
					  "extendedTimeOut": "1000",
					  "showEasing": "swing",
					  "hideEasing": "linear",
					  "showMethod": "fadeIn",
					  "hideMethod": "fadeOut"
					}
			toastr.info('Proizvod [ ' + data + '] uspesno dodat u korpu.');

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("AJAX ERROR: " + errorThrown);
		}
	});
});

//Helper function to serialize all the form fields into a JSON string
function formToJSON(name) {
	return JSON.stringify({
		"name" : name
	});
}