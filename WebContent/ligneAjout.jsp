<!DOCTYPE HTML>
<%@page import="entity.dao.LigneDAO"%>
<%@page import="entity.Ligne"%>
<%@page import="entity.LiaisonTypeForfait"%>
<%@page import="entity.dao.LiaisonTypeForfaitDAO"%>
<%@page import="entity.Forfait"%>
<%@page import="entity.dao.ForfaitDAO"%>
<%@page import="entity.Type"%>
<%@page import="entity.dao.TypeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Localite"%>
<%@page import="java.util.List"%>
<%@page import="entity.dao.LocaliteDAO"%>
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
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	<script>
		 new WOW().init();
	</script>
<!-- <link href="css/combine.css" rel="stylesheet"> -->
<!--     <link rel="stylesheet" type="text/css" media="screen" -->
<!--      href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css"> -->
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
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.jsp" title=""><span class="icon icon-user" style="color: brown"></span> <span class="text" style="color: brown">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.jsp" title=""><span class="icon icon-phone" style="color: "></span> <span class="text" style="color: ">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.jsp" title=""><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
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
			
			
			
							<% 
							String errorMessage = (String) request.getAttribute("errorMessage");
     if(errorMessage!=null){
	%>
	<div style="color: red border: 1px solid;
margin: 10px 0px;
padding:15px 10px 15px 50px;
background-repeat: no-repeat;
background-position: 10px center;
color: #D8000C;
background-color: #FFBABA;
background-image: url('img/error.png');
" > Erreur : 
	<%= errorMessage %>
	</div>
	
	<%} %>
			
				<h3 class="blank1">Ajout d'une ligne</h3>
				<div class="tab-content">

					<div class="tab-pane active" id="horizontal-form">
						<form class="form-horizontal"  method="post" action="LigneAjout" >
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Numéro ligne</label>
								<div class="col-sm-8">
									<input type="text" list="sugg" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="" value="+212"  style="width:50%" autocomplete="off">
									<datalist id="sugg">
									
										<%
										List<Ligne> listeLigne = new ArrayList<Ligne>();
										LigneDAO ligneDAO = new LigneDAO();
										listeLigne = ligneDAO.findAll();
										
										for(int i = 0 ; i< listeLigne.size() ; i++){
										
										%>
    									<option value="+<%= listeLigne.get(i).getNumero()%>">
<!--     									<option value="Red"> -->
<!--     									<option value="Green"> -->
<!--     									<option value="Blue"> -->
<!--     									<option value="White"> -->
    									<% } %>
									</datalist>
								</div>
								<div class="col-sm-2 jlkdfj1">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Date de création</label>
								<div class="col-sm-8">
									
										<select    name="jour" style="width: 10%"> 
										
											<option value="JJ" selected> JJ </option>
      										<option value="01"> 01 </option>
      										<option value="02"> 02 </option>
      										<option value="03"> 03 </option>
      										<option value="04"> 04 </option>
      										<option value="05"> 05 </option>
      										<option value="06"> 06 </option>
      										<option value="07"> 07 </option>
      										<option value="08"> 08 </option>
      										<option value="09"> 09 </option>
      										<option value="10"> 10 </option>
      										<option value="11"> 11 </option>
      										<option value="12"> 12 </option>
      										<option value="13"> 13 </option>
      										<option value="14"> 14 </option>
      										<option value="15"> 15 </option>
      										<option value="16"> 16 </option>
      										<option value="17"> 17 </option>
      										<option value="18"> 18 </option>
      										<option value="19"> 19 </option>
      										<option value="20"> 20 </option>
      										<option value="21"> 21 </option>
      										<option value="22"> 22 </option>
      										<option value="23"> 23 </option>
      										<option value="24"> 24 </option>
      										<option value="25"> 25 </option>
      										<option value="26"> 26 </option>
      										<option value="27"> 27 </option>
      										<option value="28"> 28 </option>
      										<option value="29"> 29 </option>
      										<option value="30"> 30 </option>
      										<option value="31"> 31 </option>
      										
      										
      									</select>
      									
      									<select    name="mois" style="width: 20%"> 
      									
      										<option value="MM" selected> MM </option>
      										<option value="01"> janvier </option>
      										<option value="02"> Février </option>
      										<option value="03"> Mars </option>
      										<option value="04"> Avril </option>
      										<option value="05"> Mai </option>
      										<option value="06"> Juin </option>
      										<option value="07"> Juillet </option>
      										<option value="08"> Aout </option>
      										<option value="09"> Septembre </option>
      										<option value="10"> Octobre </option>
      										<option value="11"> Novembre </option>
      										<option value="12"> Décembre </option>
      									</select>
      									
      									<select    name="annee" style="width: 20%"> 
      										<option value="AAAA" selected> AAAA </option>
      										<option value="1999"> 1999 </option>
      										<option value="2000"> 2000 </option>
      										<option value="2001"> 2001 </option>
      										<option value="2002"> 2002 </option>
      										<option value="2003"> 2003 </option>
      										<option value="2004"> 2004 </option>
      										<option value="2005"> 2005 </option>
      										<option value="2006"> 2006 </option>
      										<option value="2007"> 2007 </option>
      										<option value="2008"> 2008 </option>
      										<option value="2009"> 2009 </option>
      										<option value="2010"> 2010 </option>
      										<option value="2011"> 2011 </option>
      										<option value="2012"> 2012 </option>
      										<option value="2013"> 2013 </option>
      										<option value="2014"> 2014 </option>
      										<option value="2015"> 2015 </option>
      										<option value="2016"> 2016 </option>
      										<option value="2017"> 2017 </option>
      										<option value="2018" > 2018 </option>
<!--       										<option value="2019"> 2019 </option> -->
<!--       										<option value="2020"> 2020 </option> -->
      										
      									</select>
    								
								</div>
								<div class="col-sm-2 jlkdfj1">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="color: white">Localité</label>
								<div class="col-sm-8">
									<select   class="form-control1" name="localite" id ="localite">
									<option id="vide" value=""  selected="selected" > Aucun </option>
											<% 
											LocaliteDAO localiteDAO = new LocaliteDAO();
											List<Localite> listeLocalite = new ArrayList<Localite>();
											listeLocalite = localiteDAO.findAll();
											if(listeLocalite.size()>0){
											for(int i = 0 ; i < listeLocalite.size() ; i++ ){
											%>
											<option value="<%= listeLocalite.get(i).getId()%>" ><%= listeLocalite.get(i).getCode() %></option>
											<%
											}
											}
											%>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" style="color: white">Type</label>
								<div class="col-sm-8">
									<select   class="form-control1" name="type">
										<option id="vide" value=""  selected="selected" onclick="azedfg(0);"> Aucun </option>
											<% 
											TypeDAO typeDAO = new TypeDAO();
											List<Type> listeType = new ArrayList<Type>();
											listeType = typeDAO.findAll();
											if(listeType.size()>0){
											for(int i = 0 ; i < listeType.size() ; i++ ){
											%>
											<option value="<%=listeType.get(i).getId()%>" 
											onclick="azedfg(<%=listeType.get(i).getId()%>);" >
											<%= listeType.get(i).getCode() %></option>
											<%
											}
											}
											%>
									</select>
								</div>
							</div>
							<div class="form-group" >
										<% 
											LiaisonTypeForfaitDAO liaisonTypeForfaitDAO = new LiaisonTypeForfaitDAO();
											List<LiaisonTypeForfait> listeLiaisonTypeForfait = new ArrayList<LiaisonTypeForfait>();
											listeLiaisonTypeForfait = liaisonTypeForfaitDAO.findAll();
											if(listeLiaisonTypeForfait.size()>0){
											for(int i = 0 ; i < listeLiaisonTypeForfait.size() ; i++ ){
											%>
											<div class="form-group"  style="display: none;" id="<%=listeLiaisonTypeForfait.get(i).getType().getId()%>" name="forfaitCout" >
											<label for="focusedinput" class="col-sm-2 control-label" style="color:white"><%= listeLiaisonTypeForfait.get(i).getForfait().getCode() %></label>
											<div class="col-sm-8"> 
												<input type="text"  name="coutForfait" id="coutForfait" class="form-control1" id="focusedinput" placeholder="" value="<%= listeLiaisonTypeForfait.get(i).getForfait().getCout()%>" style="width:50%;background-color: grey;color:white;" readonly="readonly">
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
							<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button>
									<button class="btn-success btn" type="submit" name="V" >Valider</button>
									<button class="btn-default btn" type="submit" name="A" >Annuler</button>
									<button class="btn-inverse btn" >Réinitialiser</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="bs-example" data-example-id="form-validation-states">
  				</div>
			</div>
		</div>
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
	<script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
     </script>  
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
    <script type="text/javascript">
      $('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy',
//         language: 'pt-BR'
      });
    </script>
<script type="text/javascript">
	function azedfg(identifiant) {
		var elementById = document.getElementsByName('forfaitCout');
		for(var elements = 0 ; elements<elementById.length;elements++){
			if(elementById[elements].id == identifiant){
				elementById[elements].style.display='block';
			}else{
				elementById[elements].style.display='none';
			}
		}
	}
</script>
<script type="text/javascript">
	$('#localite').html($('#localite').children('option').sort(function (x, y) {
    	return $(x).text().toUpperCase() < $(y).text().toUpperCase() ? -1 : 1;
	}));
	$('#localite').get(0).selectedIndex = 0;
</script>
</html>