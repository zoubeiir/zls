<%@page import="hibernateEntity.Porteur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="hibernateEntity.Facture"%>
<%@ page import="hibernateEntity.Ligne" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest.*" %>



<% List<Facture> listeFacture = (List<Facture>) (request.getSession().getAttribute("listeFacture"));%>
<% Ligne ligne = (Ligne) (request.getSession().getAttribute("ligne"));%>
<% Porteur porteur = (Porteur) (request.getSession().getAttribute("porteur"));%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Easy Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/css/style.css" rel='stylesheet' type='text/css' />

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	<script>
		 new WOW().init();
	</script>
	
	
</head> 

<body class="sticky-header left-side-collapsed"  onload="initMap()">
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav row">
					<li data-slide="1" class="col-12 col-sm-2"><a  href="accueil.html" title="Next Section"><span class="icon icon-home" style="color: "></span> <span class="text" style="color:  ;">ACCUEIL</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="ligne.html" title="Next Section"><span class="icon icon-phone" style="color: brown"></span> <span class="text" style="color: brown">LIGNES</span></a></li>
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="porteur.html" title="Next Section"><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">PORTEURS</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.html" title="Next Section"><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="facture.html" title="Next Section"><span class="icon icon-leaf" style="color: "></span> <span class="text" style="color: ">FACTURE</span></a></li>
					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-file"style="color: " ></span> <span class="text" style="color: ">Extraction</span></a></li>
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
    <div class="container">
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Ligne</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="LigneAjout" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Numéro ligne</label>
									<div class="col-sm-8">
										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= ligne.getNumeroLigne() %>" readonly="readonly">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Frais</label>
									<div class="col-sm-8">
										<input type="text" name="fraisLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= ligne.getFrais() %>" readonly="readonly">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block">MAD</p>
									</div>
								</div>
								<div class="form-group">
									<label for="radio" class="col-sm-2 control-label" style="color: white">Etat</label>
									<div class="col-sm-8">
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" checked="" value="1">Opérationnelle</label></div>
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" value="2">Résiliée</label></div>
<!-- 										<div class="radio-inline"><label><input name="test" type="radio" disabled="" value=""> En cours de résiliation</label></div> -->
									</div>
								</div>
							</form>
						</div>
					</div>
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>
  
					
						
			
	</section>
	
<!-- <br><br><br><br><br><br><br>=============================<br><br><br><br><br><br>	 -->



    <section>
    
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Porteur</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal">
							
							
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Code</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" value="<% if(porteur!=null){ %><%= porteur.getNom() %><%}%>" readonly="readonly">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>
  
					
						
			
	</section>
	
	
	
	
<!-- <br><br><br><br><br><br><br>=============================<br><br><br><br><br><br>	 -->
	
	
	
	
	
<% if(listeFacture!=null){ %>

<section>
    
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Factures</h3>
				</div>
			</div>
</section>

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
                                <form method="post" action="GestionLigne">
                					<table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                						<thead>
                							<tr >
<!--                 								<th></th> -->
                								<th style="color: white">Facture</th>
                								<th style="color: white">Ligne</th>
                								<th style="color: white">Mois</th>
                								<th style="color: white">Année</th>
                								<th style="color: white">Frais</th>
<!--                 								<th class="disabled-sorting text-right">Actions</th> -->
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
                							
                							
											<%for(int i=0; i<listeFacture.size(); i++) {%>
										<tr>
<%-- 											<td><input type="checkbox" name="checkbox" value="<%= listeFacture.get(i).getNumeroLigne() %>" ></td> --%>
											<td><%= listeFacture.get(i).getIdFacture() %></td>
											<td><%= listeFacture.get(i).getLigne().getNumeroLigne() %></td>
    										<td><%= listeFacture.get(i).getMois() %></td>
    										<td><%= listeFacture.get(i).getAnnee() %></td>
    										<td><%= listeFacture.get(i).getFrais() %></td>
<!--     										<td class="text-right"> -->
<%--        											<a href="GestionLigne?numeroLigne=<%=listeLigne.get(i).getNumeroLigne() %>" class="btn btn-simple btn-info btn-icon like"><i class="fa fa-info"></i></a> --%>
<!--        											<a href="#" class="btn btn-simple btn-warning btn-icon edit"><i class="fa fa-edit"></i></a> -->
<!--        											<a href="#" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-times"></i></a> -->
<!--    	 										</td> -->
										</tr>
											<% } %>



                							
                						</tbody>
                					</table>
<!--                 					<button class="btn btn-simple btn-danger btn-icon remove" type="submit">Supprimer la selection</button> -->
                					</form>
        				        </div>
                            </div><!-- end content-->

            </div>
        </div>
</div>
    </div>
</div>
<% } %>
</div>



</body>

<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
    <script src="css/css/css/css/jquery.min.js" type="text/javascript"></script>
    <script src="css/css/css/css/jquery-ui.min.js" type="text/javascript"></script>
	<script src="css/css/css/css/bootstrap.min.js" type="text/javascript"></script>
		<!--  Plugin for DataTables.net  -->
	<script src="css/css/css/css/jquery.datatables.js"></script>
	
	
	
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