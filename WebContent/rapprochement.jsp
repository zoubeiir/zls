<!DOCTYPE HTML>
<html>
<head>

<title>IAM - RAPPROCHEMENT DES FACTURES</title>
<link rel="shortcut icon" href="images/favicon.ico">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/css/style.css" rel='stylesheet' type='text/css' />
 
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>  
    <script src="js/xlsx.core.min.js" type="text/javascript"></script>  
    <script src="js/xls.core.min.js" type="text/javascript"></script>  
    
    <script type="text/javascript">
    
    function cleanOldOption(combo){
    	document.getElementById(combo).options.length = 0;
    }
    function ExportToTable(combo) { 
    	
    	
    	
        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.xlsx|.xls)$/;  
        /*Checks whether the file is a valid excel file*/  
        if (regex.test($("#excelfile").val().toLowerCase())) {  
            var xlsxflag = false; /*Flag for checking whether excel is .xls format or .xlsx format*/  
            if ($("#excelfile").val().toLowerCase().indexOf(".xlsx") > 0) {  
                xlsxflag = true;  
            }  
            /*Checks whether the browser supports HTML5*/  
            if (typeof (FileReader) != "undefined") {  
                var reader = new FileReader();  
                reader.onload = function (e) {  
                    var data = e.target.result;  
                    /*Converts the excel data in to object*/  
                    if (xlsxflag) {  
                        var workbook = XLSX.read(data, { type: 'binary' });  
                    }  
                    else {  
                        var workbook = XLS.read(data, { type: 'binary' });  
                    }  
                    /*Gets all the sheetnames of excel in to a variable*/  
                    var sheet_name_list = workbook.SheetNames;  
     
                    var cnt = 0; /*This is used for restricting the script to consider only first sheet of excel*/  
                    sheet_name_list.forEach(function (y) { /*Iterate through all sheets*/  
                        /*Convert the cell value to Json*/  
                        if (xlsxflag) {  
                            var exceljson = XLSX.utils.sheet_to_json(workbook.Sheets[y]);  
                        }  
                        else {  
                            var exceljson = XLS.utils.sheet_to_row_object_array(workbook.Sheets[y]);  
                        }  
                        if (exceljson.length > 0 && cnt == 0) {  
                            BindTable(combo,exceljson, '#exceltable');  
                            cnt++;  
                        }  
                    });  
                    $('#exceltable').show();  
                }  
                if (xlsxflag) {/*If excel file is .xlsx extension than creates a Array Buffer from excel*/  
                    reader.readAsArrayBuffer($("#excelfile")[0].files[0]);  
                }  
                else {  
                    reader.readAsBinaryString($("#excelfile")[0].files[0]);  
                }  
            }  
            else {  
                alert("Sorry! Your browser does not support HTML5!");  
            }  
        }  
        else {  
            alert("Please upload a valid Excel file!");  
        }  
    }  
    
    
    function BindTable(combo,jsondata, tableid) {/*Function used to convert the JSON array to Html Table*/  
        var columns = BindTableHeader(jsondata, tableid); /*Gets all the column headings of Excel*/ 
        
        for (var i = 0; i < columns.length; i++) {
        	var addtocombo = addCombo(combo,columns[i],i);
        }
        
//         for (var i = 0; i < jsondata.length; i++) {  
//             var row$ = $('<tr/>');  
//             for (var colIndex = 0; colIndex < columns.length; colIndex++) {  
//                 var cellValue = jsondata[i][columns[colIndex]];  
//                 if (cellValue == null)  
//                     cellValue = "";  
//                 row$.append($('<td/>').html(cellValue));  
//             }  
//             $(tableid).append(row$);  
//         }  
    }  
    function BindTableHeader(jsondata, tableid) {/*Function used to get all column names from JSON and bind the html table header*/  
        var columnSet = [];  
        var headerTr$ = $('<tr/>');  
        for (var i = 0; i < jsondata.length; i++) {  
            var rowHash = jsondata[i];  
            for (var key in rowHash) {  
                if (rowHash.hasOwnProperty(key)) {  
                    if ($.inArray(key, columnSet) == -1) {/*Adding each unique column names to a variable array*/  
                        columnSet.push(key);  
                        headerTr$.append($('<th/>').html(key));
//                         var addtocombo = addCombo('combo',rowHash);
                    }  
                }  
            }  
        }  
        $(tableid).append(headerTr$);  
        return columnSet;  
    } 
    
    function addCombo(combo,txtCombo,i) {
// 		var textb = document.getElementById(txtCombo);
		var combo = document.getElementById(combo);
		
		var option = document.createElement("option");
		option.text = txtCombo;
		option.value = i;
// 		option.name="combo";
// 		option.id="combo"
		try {
			combo.add(option, null); //Standard 
		}catch(error) {
			combo.add(option); // IE only
		}
// 		textb.value = "";
	}
    function addComboVide(combo) {
// 		var textb = document.getElementById(txtCombo);
		var combo = document.getElementById(combo);
		
		var option = document.createElement("option");
		option.text = 'Aucun';
		option.value = '';
// 		option.name="combo";
// 		option.id="combo"
// 		option.selected=true
		try {
			combo.add(option, null); //Standard 
		}catch(error) {
			combo.add(option); // IE only
		}
// 		textb.value = "";
	}
    </script>
    

	
	

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	<script>
		 new WOW().init();
	</script>
	
	<% 
	if( request!=null || session!=null){
	String username = (String) session.getAttribute("login");
	if(username==null || username==""|| username=="0"){
		response.sendRedirect("index.jsp");
// 		username==null || username==""
		}
	}else{
		
		response.sendRedirect("index.jsp");
	}
	
	%>
	
</head> 
<body class="sticky-header left-side-collapsed"  onload="initMap()">
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav row">
					<li data-slide="1" class="col-12 col-sm-2"><a  href="accueil.jsp" title=""><span class="icon icon-home" style="color: "></span> <span class="text" style="color:  ;">ACCUEIL</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="ligne.jsp" title=""><span class="icon icon-phone" style="color: "></span> <span class="text" style="color: ">LIGNES</span></a></li>
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="localite.jsp" title=""><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.jsp" title=""><span class="icon icon-gears" style="color: brown"></span> <span class="text" style="color: brown">RAPPROCHEMENT</span></a></li>
<!-- 					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="facture.jsp" title=""><span class="icon icon-leaf" style="color: "></span> <span class="text" style="color: ">FACTURE</span></a></li> -->
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title=""><span class="icon icon-file"style="color: " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.jsp" title=""><span class="icon icon-ticket" style="color: "></span> <span class="text" style="color: ">PARAMETRAGE</span></a></li>
					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="Logout" title=""><span class="icon icon-signout"style="color: " ></span> <span class="text" style="color: ">SE DECONNECTER</span></a></li>
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
		

	<div class="container">
    
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Rapprochement</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal" action="GestionRapprochement" method="post" enctype="multipart/form-data">
							
								
								
								
								
								
								
								
								
<!-- 							<div class="panel-footer"> -->
							
<!-- 						 </div> -->
<!-- 						 <div class="panel-footer"> -->
<!-- 						 </div> -->
						 <div class="bs-example" data-example-id="form-validation-states-with-icons">
						  		<div class="form-group">
									<label for="exampleInputFile" style="color:white">File input</label>
									<input type="file" id="excelfile" name="excelfile" style="color:white" onchange="cleanOldOption('combo');addComboVide('combo');ExportToTable('combo');cleanOldOption('tarif');addComboVide('tarif');ExportToTable('tarif');">
									<p class="help-block"></p>
						  		</div>
						  		
						  		<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color:white">Nom du fichier</label>
									<div class="col-sm-8">
										<input autocomplete="off" type="text" class="form-control1" id="focusedinput" placeholder="" name="fileName" value="Rapprochement" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
								<label class="col-sm-2 control-label" style="color:white">Numero de la ligne</label>
								<div class="col-sm-8">
									<select  class="form-control1" name="combo" id="combo" >
										<option value="" >Aucun</option>
									</select>
								</div></div>
								
								<div class="form-group">
								<label class="col-sm-2 control-label" style="color:white">Tarif</label>
								<div class="col-sm-8">
									<select  class="form-control1" name="tarif" id="tarif">
										<option value="" >Aucun</option>
									</select>
								</div></div>
<!-- 						  		<div class="panel-footer"> -->
									<div class="row">
										<div class="col-sm-8 col-sm-offset-2">
										<br><br>
											<button class="btn-success btn" type="submit" >Rapprocher</button>
<!-- 											<button class="btn-default btn" type="submit" name="A">Cancel</button> -->
<!-- 											<button class="btn-default btn" type="submit" name="A" >Annuler</button> -->
<!-- 											<button class="btn-inverse btn" type="submit" name="A" > Annuler </button> -->
										</div>
									</div>
<!-- 							 	</div> -->
						  	</div>
							</form>
						</div>
					</div>
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>

				</div>
			</div>
<!-- 		</div> -->
	</div>
	

</body>

<!-- SCRIPTS -->
<script src="js/html5shiv.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script src="js/script.js"></script>

<!-- wxc -->
</html>