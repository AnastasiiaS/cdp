var citiesData;
var cityName;

$(document).ready(function() {
	$.ajax({
		type : "POST",
		url : "stat/getCitiesData",
		dataType : "json",
		success : function(data) {
			citiesData = data;
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(xhr.status);
			alert(thrownError);
		}
	});

});

function drowChartByCity(cityName) {
	google.load("visualization", "1", {
		"callback" : drawChart,
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);

	$('#statistics').html('Statistics');
	$('#chart_stat_by_city').css('box-shadow',
			'0 0 40px rgba(248, 248, 218, 1)');

}

function drawChart() {

	var jsonData = citiesData.data[cityName];
	var arr = [];
	arr.push([ 'Year', '1qt', '2qt', '3qt', '4qt' ]);
	$.each(jsonData.emplStat, function(key, val) {
		var array = [ key ];
		$.each(val.employeesQuantity, function(k, v) {
			array.push(v);
		});
		if (array.length < 5) {
			array.push(null);
		}
		arr.push(array);
	});

	var data = google.visualization.arrayToDataTable(arr);

	var options = {
		title : 'Company Performance in ' + cityName,
		hAxis : {
			title : 'Year',
			titleTextStyle : {
				color : 'red'
			}
		},
		vAxis : {
			title : 'Employees',
		}
	};

	var chart = new google.visualization.ColumnChart(document
			.getElementById("chart_stat_by_city"));
	chart.draw(data, options);
}