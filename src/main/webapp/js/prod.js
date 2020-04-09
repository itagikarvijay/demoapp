function loadProductList() {
	AJAX_GET_URL = 'http://localhost:8080/all';
	$.ajax({
		url : AJAX_GET_URL,
		contentType : "application/json",
		type : "GET",
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			populateTable(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error');
			$("#errorMsg").innerHTML("error");
		}
	});

}

function bySearch() {
	let sku = $("#skuId").val(),
	AJAX_GET_URL = 'http://localhost:8080/search/products';
	param = {
		brand : $("#brandId").val(),
		category : $("#catId").val(),
		colour : $("#colourId").val(),
		size : $("#sizeId").val()
	};
	$.ajax({
		url : AJAX_GET_URL,
		contentType : "application/json",
		data : JSON.stringify(param),
		type : "POST",
		success : function(data, textStatus, jqXHR) {
			console.log(data);
			populateTable(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#errorMsg").innerHTML("error");
		}
	});
}

function populateTable(data) {
	var table = $("#tranList tbody");
	table.empty();
	table.append("<tr>" + "<th>Brand</th>" + "<th>Category</th>"
			+ "<th>Size</th>" + "<th>In.Stock</th>" + "<th>Price</th>"
			+ "<th>Sku</th>" + "<th>Colour</th>" + "</tr>");
	$.each(data, function(idx, elem) {
		table.append("<tr>" + "<td>" + elem.brand + "</td>" + "<td>"
				+ elem.category + "</td>" + "<td>" + elem.size + "</td>"
				+ "<td>" + elem.quantity + "</td>" + "<td>" + elem.price
				+ "</td>" + "<td>" + elem.sku + "</td>" + "<td>" + elem.colour
				+ "</td>" + "</tr>");
	});
}
