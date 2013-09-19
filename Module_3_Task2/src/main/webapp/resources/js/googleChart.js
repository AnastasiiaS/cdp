var yearData;
var year;

$(document).ready(function() {
	$.ajax({
		type : "POST",
		url : "stat/getYearData",
		dataType : "json",
		success : function(data) {
			yearData = data;
			console.log("yearData " + yearData);
			showMap();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(xhr.status);
			alert(thrownError);
		}
	});

});

function showMap() {
	var elList = $('#years_list');
	$.each(yearData.citiesStatistics, function(key, val) {
		elList.append($("<option></option>").attr("value", key).text(key));
	});
	var listLength = elList[0].length;
	var lastYear = elList[0][listLength - 1].value;
	elList.val(lastYear);
	showMapByYear(lastYear);
}

function showMapByYear(year) {
	google.load('visualization', '1', {
		'callback' : drawMarkersMap,
		'packages' : [ 'geochart' ]
	});
	
	google.setOnLoadCallback(drawMarkersMap);
	console.log("year " + year);
	
	function drawMarkersMap() {
		var jsonData = yearData.citiesStatistics[year];
		var arr = [];
		arr.push([ 'City', 'Employees' ]);
		$.each(jsonData.statisticsByCities, function(key, val) {
			var array = [ key ];
			array.push(val.employeesQuantity[0]);
			arr.push(array);
		});
		console.log("arr " + arr);
		var data = google.visualization.arrayToDataTable(arr);

		var options = {
			title : year,
			region : 'world',
			displayMode : 'markers',
			colorAxis : {
				colors : [ 'green', 'blue' ]
			}
		};

		var chart = new google.visualization.GeoChart(document
				.getElementById('geo_chart'));
		chart.draw(data, options);

		google.visualization.events.addListener(chart, 'select', function() {
			var selection = chart.getSelection()[0];
			var selectionRow = selection.row;
			console.log("selectionRow " + selectionRow);
			cityName = arr[selectionRow + 1][0];
			console.log("cityName " + cityName);
			drowChartByCity(cityName);
		});

	}
}
