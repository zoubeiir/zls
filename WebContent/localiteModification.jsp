

<%@page import="entite.dao.LiaisonTypeForfaitDAO"%>
<%@page import="entite.dao.LocaliteDAO"%>
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



<% Localite localite = (Localite) request.getSession().getAttribute("localite"); %>



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
					<h3 class="blank1">Modification d'une localit�</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="GestionLocalite" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code localit�</label>
									<div class="col-sm-8">
										<input type="text" name="codeLocalite" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= localite.getCode() %>"  style="width:50%; background-color: grey; " readonly="readonly" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Nomination</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="text" name="nom" class="form-control1" id="focusedinput" placeholder="Default Input" value=""   > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse postale</label>
									<div class="col-sm-8">
										<input type="text" name="adressePostale" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= localite.getAdressePostale() %>"  style=" "   >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse IP</label>
									<div class="col-sm-8">
										<input type="text" name="adresseIP" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= localite.getAdresseIP() %>"  style="width:50%; " >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Responsable</label>
									<div class="col-sm-8">
										<input type="text" name="responsable" class="form-control1" id="focusedinput" placeholder="Default Input" value="<%= localite.getResponsable() %>"  style="width:50%; " >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-sm-2 control-label" style="color: white">Type de localit�</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<select   class="form-control1" name="localite"> -->
<!-- 											<option></option> -->
<!-- 											<option>Branche</option> -->
<!-- 											<option>Si�ge</option> -->
											
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
									<button class="btn-success btn" type="submit" name="V" >Valider</button>
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
	
	




<link href="css/combine.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
     
     



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
   











    
</html>