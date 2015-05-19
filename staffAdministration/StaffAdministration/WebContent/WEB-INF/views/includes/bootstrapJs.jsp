
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script src="../js/jquery.bootstrap.newsbox.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.6.0/bootstrap-table.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script
	src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/metisMenu/2.0.0/metisMenu.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.7.0/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.7.0/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.7.0/locale/bootstrap-table-en-US.min.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<script src="http://code.highcharts.com/highcharts.js"></script>

<script src="http://code.highcharts.com/modules/exporting.js"></script>

<script src="includes/js/modernizr-2.6.2.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/metisMenu/2.0.0/metisMenu.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>

<script>
	function buildTable($el, cells, rows) {
		var i, j, row, columns = [], data = [];

		for (i = 0; i < cells; i++) {
			columns.push({
				field : 'field' + i,
				title : 'Cell' + i
			});
		}
		for (i = 0; i < rows; i++) {
			row = {};
			for (j = 0; j < cells; j++) {
				row['field' + j] = 'Row-' + i + '-' + j;
			}
			data.push(row);
		}
		$el.bootstrapTable('destroy').bootstrapTable({
			columns : columns,
			data : data
		});
	}

	$(function() {
		buildTable($('#table'), 50, 50);
	});
</script>

