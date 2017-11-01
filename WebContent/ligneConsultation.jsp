

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="entite.Ligne" %>
<%@ page import="javax.servlet.http.HttpServletRequest.*" %>
<%@page import="entite.Type"%>
<%@page import="entite.dao.TypeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entite.Localite"%>
<%@page import="java.util.List"%>
<%@page import="staticReference.EtatStatic"%>
<%@page import="entite.LiaisonTypeForfait"%>



<%-- <% List<Facture> listeFacture = (List<Facture>) (request.getSession().getAttribute("listeFacture"));%> --%>
<% Ligne ligne = (Ligne) (request.getSession().getAttribute("ligne"));%>
<% List<LiaisonTypeForfait> listeLiaisonTypeForfait = (List<LiaisonTypeForfait>) (request.getSession().getAttribute("listeLiaisonTypeForfait"));%>

<%-- <% Porteur porteur = (Porteur) (request.getSession().getAttribute("porteur"));%> --%>



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
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.html" title="Next Section"><span class="icon icon-user" style="color: brown"></span> <span class="text" style="color: brown">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.html" title="Next Section"><span class="icon icon-phone" style="color: "></span> <span class="text" style="color: ">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.html" title="Next Section"><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.html" title="Next Section"><span class="icon icon-ticket" style="color: "></span> <span class="text" style="color: ">PARAMETRAGE</span></a></li>
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-file"style="color: " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
    <div class="container">
    
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Consultation d'une ligne</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="GestionLigne" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Numéro ligne</label>
									<div class="col-sm-8">
										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= ligne.getNumero() %>"  style="width:50% ; background-color: grey;color:white;" readonly="readonly" >
									</div>
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white; width: 20%;">Numéro ligne</label> -->
<!-- 									<div class="col-sm-8">  -->
<!-- 										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="+212" style="width: 20%"> -->
<!-- 									</div> -->
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Frais</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="number" step="100" min="0" name="fraisLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" style="width:50%" > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Date de création</label>
									<div class="col-sm-8">
									<div id="datetimepicker" class="input-append date"> 
      								<input type="date" value="<%= ligne.getDateCreation()%>" readonly="readonly" style="background-color: grey;color:white;"></input>
      								<span class="add-on">
        								<i data-time-icon="icon-qsd" data-date-icon="icon-qsd" ></i>
      								</span>
    							</div>
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								
								
								
<!-- 								<div class="form-group"> -->
<!-- <!-- 								<div id="datetimepicker" class="input-append date"> --> 
<!--       								<input type="text"></input> -->
<!--       								<span class="add-on"> -->
<!--         								<i data-time-icon="icon-time" data-date-icon="icon-calendar"></i> -->
<!--       								</span> -->
<!--     							</div> -->
								
								
								
								
								
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="color: white">Localit�</label>
									<div class="col-sm-8">
										<select   class="form-control1" name="localite" style="background-color: grey;color:white;" >
											
											<%if(ligne.getLocalite()!=null){ %>
											<option value="" 	><%= ligne.getLocalite().getCode()%></option>
											<%} %>
											
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="color: white">Type</label>
									<div class="col-sm-8">
										<select   class="form-control1" name="type" style="background-color: grey;color:white;">
											 
											
											<%if(ligne.getType()!=null){ %>
											<option  ><%= ligne.getType().getCode() %></option>
											<%} %>
											
										</select>
									</div>
								</div>
								
										<div class="form-group" name="toutForfait">
										
											<% 
											if(listeLiaisonTypeForfait !=null && listeLiaisonTypeForfait.size()>0){
											for(int i = 0 ; i < listeLiaisonTypeForfait.size() ; i++ ){
											%>
											<div class="form-group"   id="<%=listeLiaisonTypeForfait.get(i).getType().getId()%>" name="forfaitCout" >
											<label for="focusedinput" class="col-sm-2 control-label" style="color:white">Co�t <%= listeLiaisonTypeForfait.get(i).getForfait().getCode() %></label>
											
											<div class="col-sm-8"> 
												<input type="text"  name="coutForfait" id="coutForfait" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= listeLiaisonTypeForfait.get(i).getForfait().getCout()%>" style="width:50%;background-color: grey;color:white;" readonly="readonly">
											</div>
											<div class="col-sm-2 jlkdfj1">
											<p class="help-block"></p>
											</div>
											</div>
											<%
											}
											}
											%>
											</div>

								<div class="form-group">
									<label for="radio" class="col-sm-2 control-label" style="color: white">Etat</label>
									<div class="col-sm-8">
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" <% if(EtatStatic.ETAT_OPERATIONNEL.compareTo(ligne.getEtat())==0){ %> checked="checked" <% } %> value="0" disabled="disabled">Opérationnelle</label></div>
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" <% if(EtatStatic.ETAT_RESILIE.compareTo(ligne.getEtat())==0){ %> checked="checked" <% } %> value="1" disabled="disabled">Résiliée</label></div>
<!-- 										<div class="radio-inline"><label><input name="test" type="radio" disabled="" value=""> En cours de résiliation</label></div> -->
										
									</div>
								</div>
								
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
									<button class="btn-success btn" href="" type="submit" name="M" >Modifier</button>
									<button class="btn-default btn" type="submit" name="R" >Retour</button>
								</div>
								</div>
								
							</form>
						</div>
					</div>
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>
  
					
						
			
	</div>
	</div></div>
  
					
						
			


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