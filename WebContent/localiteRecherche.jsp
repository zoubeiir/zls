<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@page import="java.util.ArrayList"%>
<%@page import="entite.Localite"%>
<%@page import="java.util.List"%>
<%@page import="entite.dao.LocaliteDAO"%>



<%-- <% List<Ligne> listeLocalite = (List<Ligne>) (request.getSession().getAttribute("listeLocalite"));%> --%>




<!DOCTYPE HTML>
<html>
<head>
<title>Easy Admin Panel an Admin Panel Category Flat Bootstrap Responsive Website Template | Forms :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/css/style.css" rel='stylesheet' type='text/css'  media="all"/>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">


 
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- Custom Theme files -->
<link href="css/css/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--js-->



<!--     Fonts and icons     -->
    <link href="css/css/css/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="css/css/css/css/pe-icon-7-stroke.css" rel="stylesheet" />
	
	    <!-- Bootstrap core CSS     -->
    <link href="css/css/css/css/bootstrap.min.css" rel="stylesheet" />


	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	<script>
		 new WOW().init();
	</script>
	
	
<!-- 	<link href="css/combine.css" rel="stylesheet"> -->
<!--     <link rel="stylesheet" type="text/css" media="screen" -->
<!--      href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css"> -->
     
     
     
</head> 
<body class="sticky-header left-side-collapsed"  onload="initMap()">
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav row">
					<li data-slide="1" class="col-12 col-sm-2"><a  href="accueil.html" title="Next Section"><span class="icon icon-home" style="color: "></span> <span class="text" style="color:  ;">ACCUEIL</span></a></li>
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.html" title="Next Section"><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.html" title="Next Section"><span class="icon icon-phone" style="color: brown"></span> <span class="text" style="color: brown">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.html" title="Next Section"><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.html" title="Next Section"><span class="icon icon-ticket" style="color: "></span> <span class="text" style="color: ">PARAMETRAGE</span></a></li>
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-file"style="color: " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
		

<!-- 	<div class="container"> -->
    
<!-- 			<div id="page-wrapper"> -->
<!-- 				<div class="graphs"> -->
<!-- 					<h3 class="blank1">Recherche d'une localité</h3> -->
<!-- 						<div class="tab-content"> -->
<!-- 						<div class="tab-pane active" id="horizontal-form"> -->
<!-- 							<form class="form-horizontal"  method="post" action="LigneAjout" > -->
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code localité</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="codeLocalite" class="form-control1" id="focusedinput" placeholder="Default Input" value=""  style="width:50%" > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Nomination</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="nom" class="form-control1" id="focusedinput" placeholder="Default Input" value=""   > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse postale</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="adressePostale" class="form-control1" id="focusedinput" placeholder="Default Input" value=""   > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse IP</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="adresseIP" class="form-control1" id="focusedinput" placeholder="Default Input" value=""  style="width:50%" > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Responsable</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="responsable" class="form-control1" id="focusedinput" placeholder="Default Input" value=""  style="width:50%" > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-sm-2 control-label" style="color: white">Type de localité</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<select   class="form-control1" name="localite"> -->
<!-- 											<option></option> -->
<!-- 											<option>Branche</option> -->
<!-- 											<option>Siège</option> -->
											
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								
								
<!-- 								</br> -->
								
<!-- 								<div class="row"  style="width:80%"> -->
<!-- 								<div class="col-sm-8 col-sm-offset-2" > -->
									
<!-- 									<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button> -->
<!-- 									<button class="btn-success btn" type="submit" name="V" >Valider</button> -->
<!-- 									<button class="btn-default btn" type="submit" name="A" >Annuler</button> -->
<!-- 									<button class="btn-inverse btn" >Réinitialiser</button> -->
<!-- 								</div> -->
<!-- 								</div> -->
								
<!-- 							</form> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<div class="bs-example" data-example-id="form-validation-states"> -->
    
<!--   </div> -->
  
					
						
			
<!-- 	</div> -->
<!-- 	</div></div> -->


<% 
											LocaliteDAO localiteDAO = new LocaliteDAO();
											List<Localite> listeLocalite = new ArrayList<Localite>();
											listeLocalite = localiteDAO.findAll();
// 											 if(listeLocalite.size()>0){
		 %>
<div class="container">
<div class="content">
            <div class="container-fluid">

                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="content">
								<div class="toolbar">
	                                <!--        Here you can write extra buttons/actions for the toolbar              -->
	                            </div>
                                <div class="fresh-datatables">
                                <form method="post" action="GestionLocalite">
                					<table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                						<thead>
                							<tr >
                								<th></th>
                								<th style="color: white">localité</th>
                								<th style="color: white">adressePostale</th>
                								<th style="color: white">adresseIP</th>
                								<th style="color: white">Responsable</th>
                								<th style="color: white" class="disabled-sorting text-right">Actions</th>
                							</tr>
                						</thead>
<!--                 						<tfoot> -->
<!--                 							<tr> -->
<!--                 								<th>Name</th> -->
<!--                 								<th>Position</th> -->
<!--                 								<th>Office</th> -->
<!--                 								<th>Age</th> -->
<!--                 								<th>Start date</th> -->
<!--                 								<th class="text-right">Actions</th> -->
<!--                 							</tr> -->
<!--                 						</tfoot> -->
                						<tbody>
                							
                							
											<%for(int i = 0 ; i < listeLocalite.size() ; i++ ){ %>
										<tr style="background-color: white">
										<td></td>
<%-- 											<td><input type="checkbox" name="checkbox" value="<%= listeLocalite.get(i).getNumero() %>" ></td> --%>
											<td><%= listeLocalite.get(i).getCode() %></td>
											<td><%= listeLocalite.get(i).getAdressePostale() %></td>
<%-- 											<td><%= listeLocalite.get(i).getFrais() %></td> --%>
    										<td> <%= listeLocalite.get(i).getAdresseIP() %> </td>
    										<td> <%= listeLocalite.get(i).getResponsable() %> </td>
    										<td class="text-right">
       											<a href="GestionLocalite?codeLocalite=<%=listeLocalite.get(i).getCode().replace("+", "%2B") %>" class="btn btn-simple btn-info btn-icon like"><i class="fa fa-info"></i></a>
       											<a href="GestionLocalite?codeLocalite=<%=listeLocalite.get(i).getCode().replace("+", "%2B")%>&mf=m" class="btn btn-simple btn-warning btn-icon edit"><i class="fa fa-edit"></i></a>
<!--        											<a href="#" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-times"></i></a> -->
   	 										</td>
										</tr>
											<% } %>



                							
                						</tbody>
                					</table>
                					</form>
        				        </div>
                            </div><!-- end content-->

            </div>
        </div>
</div>
    </div>
</div></div>
											<%
// 											}
											%>

</body>

<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
    <script src="css/css/css/css/jquery.min.js" type="text/javascript"></script>
    <script src="css/css/css/css/jquery-ui.min.js" type="text/javascript"></script>
	<script src="css/css/css/css/bootstrap.min.js" type="text/javascript"></script>
		<!--  Plugin for DataTables.net  -->
	<script src="css/css/css/css/jquery.datatables.js"></script>
	
	<!-- SCRIPTS -->
<!-- <script src="js/html5shiv.js"></script> -->
<!-- <script src="js/jquery-1.10.2.min.js"></script> -->
<!-- <script src="js/jquery-migrate-1.2.1.min.js"></script> -->
<!-- <!-- <script src="js/bootstrap.min.js"></script> --> -->
<!-- <script src="js/jquery.easing.1.3.js"></script> -->
<!-- <script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script> -->
<!-- <script src="js/script.js"></script> -->
	
	
	<script type="text/javascript">
    $(document).ready(function() {
		$('#datatables').DataTable({
		    "pagingType": "full_numbers",
		    "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		    responsive: true,
		    language: {
		    search: "_INPUT_",
		    searchPlaceholder: "Search records",
		    }
		});
		var table = $('#datatables').DataTable();
		// Edit record
		table.on( 'click', '.edit', function () {
		    $tr = $(this).closest('tr');
		    var data = table.row($tr).data();
		    alert( 'You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.' );
		} );
		// Delete a record
		table.on( 'click', '.remove', function (e) {
		    $tr = $(this).closest('tr');
		    table.row($tr).remove().draw();
		    e.preventDefault();
		} );
		//Like record
		table.on( 'click', '.like', function () {
		    alert('You clicked on Like button');
		});
	});
    </script>
    
	
</html>