<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/style/style.css" />
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript" src="resources/js/showStat.js"></script>
<script type="text/javascript" src="resources/js/googleChart.js"></script>

</head>

<body>
	<div class="wrap">

		<div class="header">
			<h1>EPAM</h1>
		</div>

		<h3>
			Select year <select id=years_list
				onchange="showMapByYear(options[this.selectedIndex].value)"></select>
		</h3>

		<div class="home_center_content">
			<div class="home_center_content">
				<div class="box1">
					<h2>Epam offices</h2>
					<div id="geo_chart"></div>
					<div>
						<p>To see history of development, choose one of offices from
							the map.</p>
					</div>
				</div>
				<div class="box2">
					<h2 id="statistics"></h2>
					<div id="chart_stat_by_city"></div>
				</div>
			</div>
		</div>
	</div>
</html>