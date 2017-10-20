<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
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
<title>Easy Admin Panel an Admin Panel Category Flat Bootstrap Responsive Website Template | Forms :: w3layouts</title>
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



<link href="css/combine.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
     
     
	
</head> 

<body class="sticky-header left-side-collapsed"  onload="initMap()">
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav row">
					<li data-slide="1" class="col-12 col-sm-2"><a  href="accueil.html" title="Next Section"><span class="icon icon-home" style=";background-image: none;text-shadow : none "></span> <span class="text" style="color: grey ;">ACCUEIL</span></a></li>
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.html" title="Next Section"><span class="icon icon-phone" style="color: brown"></span> <span class="text" style="color: brown">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="porteur.html" title="Next Section"><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">PORTEURS</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.html" title="Next Section"><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="facture.html" title="Next Section"><span class="icon icon-leaf" style="color: "></span> <span class="text" style="color: ">FACTURE</span></a></li>
					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-file"style=" " ></span> <span class="text" style="color: ">Extraction</span></a></li>
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
    <div class="container">
    
			<div id="page-wrapper">
				<div class="graphs">
					<h3 class="blank1">Ajout d'une ligne</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="LigneAjout" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Numéro ligne</label>
									<div class="col-sm-8">
										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="+212"  style="width:50%">
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
      								<input type="date"></input>
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
										<select   class="form-control1" name="localite">
											<% 
											LocaliteDAO localiteDAO = new LocaliteDAO();
											List<Localite> listeLocalite = new ArrayList<Localite>();
											listeLocalite = localiteDAO.findAll();
											if(listeLocalite.size()>0){
											for(int i = 0 ; i < listeLocalite.size() ; i++ ){
												
											
											
											
											%>
											
											<option value="" ><%= listeLocalite.get(i).getCode() %></option>
											
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
											<% 
											TypeDAO typeDAO = new TypeDAO();
											List<Type> listeType = new ArrayList<Type>();
											listeType = typeDAO.findAll();
											if(listeType.size()>0){
											for(int i = 0 ; i < listeType.size() ; i++ ){
												
											
											
											
											%>
											
											<option value="<%=listeType.get(i).getId()%>" 
											onclick="azedfg(<%=listeType.get(i).getId()%>);fillCouts(0,'coutForfait');fillCouts(<%=listeType.get(i).getCout()%>,'coutType')" >
											<%= listeType.get(i).getCode() %></option>
											
											<%
											}
											}
											%>
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Cout Type</label>
									<div class="col-sm-8">
										<input type="text"  name="coutType"  id="coutType" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" style="width:50%;background-color: grey;color:white;" readonly="readonly">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								
								<div class="form-group">
									<label class="col-sm-2 control-label" style="color: white">Forfait</label>
									<div class="col-sm-8">
										<select class="form-control1" name="forfait" id="forfait">
											<option id="vide" value="" onclick="fillCouts(0,'coutForfait')" > Aucun </option>
<% 
											ForfaitDAO forfaitDAO = new ForfaitDAO();
											List<Forfait> listeForfait = new ArrayList<Forfait>();
											listeForfait = forfaitDAO.findAll();
											if(listeForfait.size()>0){
											for(int i = 0 ; i < listeForfait.size() ; i++ ){
												
											
											
											
											%>
											
											<option id="<%=listeForfait.get(i).getType().getId()%>"
											name="<%=listeForfait.get(i).getType().getId()%>"
											 value="<%=listeForfait.get(i).getId()%>" style="display: none;"
											 onclick="fillCouts(<%= listeForfait.get(i).getCout() %>,'coutForfait')">
											 <%= listeForfait.get(i).getCode() %></option>
											
											<%
											}
											}
											%>
											
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Cout Forfait</label>
									<div class="col-sm-8">
										<input type="text"  name="coutForfait" id="coutForfait" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" style="width:50%;background-color: grey;color:white;" readonly="readonly">
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								
								
								<div class="form-group">
									<label for="radio" class="col-sm-2 control-label" style="color: white">Etat</label>
									<div class="col-sm-8">
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" checked="checked" value="0">Opérationnelle</label></div>
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" value="1">Résiliée</label></div>
<!-- 										<div class="radio-inline"><label><input name="test" type="radio" disabled="" value=""> En cours de résiliation</label></div> -->
										
									</div>
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
	</div></div>



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
<!--     <script type="text/javascript" -->
<!--      src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"> -->
<!--     </script> -->
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

	var select = document.getElementById("forfait");
	var length = select.options.length;
	for (i = 0; i < length; i++) {
	  select.options[i].style.display='none';
	}
	document.getElementById("vide").style.display='block';
	document.getElementById("vide").selected='true';
	var elementById = document.getElementsByName(identifiant);
	
	for(var elements = 0 ; elements<elementById.length;elements++)
		elementById[elements].style.display='block';
	
}

function fillCouts(cout,identifiantCout){
	document.getElementById(identifiantCout).value=cout;
}
</script>
</body>
</html>