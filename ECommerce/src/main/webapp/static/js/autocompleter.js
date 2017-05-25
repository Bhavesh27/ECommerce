$(document).ready(function() {
	$(function() {
		$("#search").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : window.location.href + "SearchController",
					type : "GET",
					data : {
						term : request.term
					},
					contentType: "application/json; charset=utf-8",
					dataType : "json",
					success : function(data) {
						response(data);
					}
				});
			}
		});
	});
});
