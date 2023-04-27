$(function() {
	var socket = new SockJS('/stocks-example');
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/stocks', function(message) {
			var stock = JSON.parse(message.body);
			updateStockTable(stock);
		});
	});

	function updateStockTable(stocks) {
		for (var i = 0; i < stocks.length; i++) {
                var stock = stocks[i];
                var tableRow = $('#stock-table').find('tr#' + stock.name);

                if (tableRow.length === 0) {
                    tableRow = $('<tr>').attr('id', stock.name).appendTo('#stock-table tbody');
                    tableRow.append($('<td>').text(stock.name));
                    tableRow.append($('<td>').text(stock.price));
                } else {
                    tableRow.find('td:last-child').text(stock.price);
                }
            }
        }
});