<!DOCTYPE HTML>

<%@page import="entity.dao.LocaliteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Localite"%>
<%@page import="java.util.List"%>
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
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.jsp" title=""><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.jsp" title=""><span class="icon icon-phone" style="color: brown"></span> <span class="text" style="color: brown">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.jsp" title=""><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.jsp" title=""><span class="icon icon-ticket" style="color: "></span> <span class="text" style="color: ">PARAMETRAGE</span></a></li>
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title=""><span class="icon icon-file"style=" " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
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
	
	
					<h3 class="blank1">Ajout d'une localité</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="LocaliteAjout" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code localité</label>
									<div class="col-sm-8">
										<input autocomplete="off" list="sugg" maxlength="50" type="text" name="codeLocalite" class="form-control1" id="focusedinput" placeholder="" value=""  style="width:50%" required="required">
										
										<datalist id="sugg">
									
										<%
										List<Localite> listeLigne = new ArrayList<Localite>();
										LocaliteDAO ligneDAO = new LocaliteDAO();
										listeLigne = ligneDAO.findAll();
										
										for(int i = 0 ; i< listeLigne.size() ; i++){
										
										%>
    									<option value="<%= listeLigne.get(i).getCode().replace("  ", "") %>">
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
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Nomination</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="nom" class="form-control1" id="focusedinput" placeholder="" value=""   > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse postale</label>
									<div class="col-sm-8">
										<input autocomplete="off" maxlength="100" type="text" name="adressePostale" class="form-control1" id="focusedinput" placeholder="" value=""   >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse IP</label>
									<div class="col-sm-8">
										<input autocomplete="off" maxlength="20" type="text" name="adresseIP" class="form-control" id="adresseIP"   style="width:50%" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Responsable</label>
									<div class="col-sm-8">
										<input autocomplete="off" maxlength="50" type="text" name="responsable" class="form-control1" id="focusedinput" placeholder="" value=""  style="width:50%" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-sm-2 control-label" style="color: white">Type de localité</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<select   class="form-control1" name="localite"> -->
<!-- 											<option></option> -->
<!-- 											<option>Branche</option> -->
<!-- 											<option>SiÃ¨ge</option> -->
											
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								
								
								</br>
								
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


</body>
</html>