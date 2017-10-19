<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
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
				<h3 class="blank1" style="color: white">Ajout d'une ligne</h3>
				<h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>
					<h4 class="font-thin"><span class="font-semibold"></span></h4>
				<div class="tab-content">
					<div class="tab-pane active" id="horizontal-form">
						<form class="form-horizontal"  method="post" action="LigneAjout" >
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label" style="color : white">Num�ro ligne</label>
								<div class="col-sm-8">
									<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="+212" >
								</div>
								<div class="col-sm-2 jlkdfj1">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label" style="color : white">Frais</label>
								<div class="col-sm-8">
									<input type="number" step="100" min="0" name="fraisLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" >
								</div>
<!-- 								<div class="col-sm-2 jlkdfj1"> -->
<!-- 									<p class="help-block" style="color : white">MAD</p> -->
<!-- 								</div> -->
							</div>
							<div class="form-group">
								<label for="radio" class="col-sm-2 control-label" style="color : white">Etat</label>
								<div class="col-sm-8">
									<div class="radio-inline"><label><input name="etat" type="radio" checked="checked" value="0">Opérationnelle</label></div>
									<div class="radio-inline"><label><input name="etat" type="radio" value="1">Résiliée</label></div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-8 col-sm-offset-2">
									<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button>
									<button class="btn-success btn" type="submit" name="V" >Valider</button>
									<button class="btn-default btn" type="submit" name="A" >Annuler</button>
									<button class="btn-inverse btn" style="color : grey">Réinitialiser</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="bs-example" data-example-id="form-validation-states">
  				</div>
  			</div>
  		</div></div>
  		
  		
  		
<!--   		<h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>  -->
<!-- 					<h4 class="font-thin"><span class="font-semibold"></span></h4> -->
<!-- <h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>  -->
<!-- 					<h4 class="font-thin"><span class="font-semibold"></span></h4> -->
<!-- <h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>  -->
<!-- 					<h4 class="font-thin"><span class="font-semibold"></span></h4> -->
<!-- <h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>  -->
<!-- 					<h4 class="font-thin"><span class="font-semibold"></span></h4> -->
<!-- <h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>  -->
<!-- 					<h4 class="font-thin"><span class="font-semibold"></span></h4> -->
  		
  		
  		
<!-- 		<div class="container"> -->
<!-- 			<div id="contact-row-4" class="row"> -->
<!-- 				<div class="col-sm-1 hidden-sm">&nbsp;</div> -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a href="ligne.html"><i class="icon icon-phone"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">LIGNES</span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="porteur.html"><i class="icon icon-user"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">PORTEURS</span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="rapprochement.html"><i class="icon icon-gears"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">RAPPROCHEMENTS<br></span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="facture.html"><i class="icon icon-ticket"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">FACTURES</span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="#"><i class="icon icon-aze"></i></a></p> -->
<!-- 					<span class="hover-text font-light "></span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-sm-1 hidden-sm">&nbsp;</div> -->
<!-- 			</div>/row -->
<!-- 		</div>/container -->
		
<!-- 		<div class="container"> -->
<!-- 			<div id="contact-row-4" class="row"> -->
<!-- 				<div class="col-sm-1 hidden-sm">&nbsp;</div> -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a href="accueil.html"><i class="icon icon-home"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">ACCUEIL</span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="index.html"><i class="icon icon-signout"></i></a></p> -->
<!-- 					<span class="hover-text font-light ">SE DECONNECTER</span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="rapprochement.html"><i class="icon icon-gearss"></i></a></p> -->
<!-- 					<span class="hover-text font-light "><br></span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="facture.html"><i class="icon icon-tickset"></i></a></p> -->
<!-- 					<span class="hover-text font-light "></span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a  href="#"><i class="icon icon-aze"></i></a></p> -->
<!-- 					<span class="hover-text font-light "></span> -->
<!-- 				</div>/col12 -->
<!-- 				<div class="col-sm-1 hidden-sm">&nbsp;</div> -->
<!-- 			</div>/row -->
<!-- 		</div>/container -->
<!-- 	</div>/slide1 -->
	
<!--     <section> -->
<!-- 		<div id="page-wrapper"> -->
<!-- 			<div class="graphs"> -->
<!-- 				<h3 class="blank1">Ajout d'une ligne</h3> -->
<!-- 				<div class="tab-content"> -->
<!-- 					<div class="tab-pane active" id="horizontal-form"> -->
<!-- 						<form class="form-horizontal"  method="post" action="LigneAjout" > -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="focusedinput" class="col-sm-2 control-label">Numéro ligne</label> -->
<!-- 								<div class="col-sm-8"> -->
<!-- 									<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="+212" > -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-2 jlkdfj1"> -->
<!-- 									<p class="help-block"></p> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="focusedinput" class="col-sm-2 control-label">Frais</label> -->
<!-- 								<div class="col-sm-8"> -->
<!-- 									<input type="number" step="100" min="0" name="fraisLigne" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" > -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-2 jlkdfj1"> -->
<!-- 									<p class="help-block">MAD</p> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="radio" class="col-sm-2 control-label" >Etat</label> -->
<!-- 								<div class="col-sm-8"> -->
<!-- 									<div class="radio-inline"><label><input name="etat" type="radio" checked="checked" value="0">Opérationnelle</label></div> -->
<!-- 									<div class="radio-inline"><label><input name="etat" type="radio" value="1">Résiliée</label></div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="row"> -->
<!-- 							<div class="col-sm-8 col-sm-offset-2"> -->
<!-- 								<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button> -->
<!-- 								<button class="btn-success btn" type="submit" name="V" >Valider</button> -->
<!-- 								<button class="btn-default btn" type="submit" name="A" >Annuler</button> -->
<!-- 								<button class="btn-inverse btn" >Réinitialiser</button> -->
<!-- 							</div> -->
<!-- 							</div> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="bs-example" data-example-id="form-validation-states"> -->
<!--   				</div> -->
<!--   			</div> -->
<!--   		</div> -->
<!-- 	</section> -->
<!-- </div> -->
</body>
</html>