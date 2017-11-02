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



<!-- <link href="css/combine.css" rel="stylesheet"> -->
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
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.html" title="Next Section"><span class="icon icon-phone" style="color: "></span> <span class="text" style="color: ">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.html" title="Next Section"><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.html" title="Next Section"><span class="icon icon-ticket" style="color: brown"></span> <span class="text" style="color: brown">PARAMETRAGE</span></a></li>
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title="Next Section"><span class="icon icon-file"style=" " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
				</ul>
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	<div class="slide story"  data-slide="1">
	</div>
    <div class="container">
    
<!-- 			<div id="page-wrapper"> -->
<!-- 				<div class="graphs"> -->
<!-- 					<h3 class="blank1">Ajout de Type/Forfait</h3> -->
<!-- 						<div class="tab-content"> -->
<!-- 						<div class="tab-pane active" id="horizontal-form"> -->
							<form class="form-horizontal"  method="post" action="" >

								<div class="form-group">
									<label class="col-sm-2 control-label" style="color: white">Ajout de</label>
									<div class="col-sm-8">
										<select   class="form-control1" name="localite" id ="localite">
										
											
											<option value="" onclick="showNothing()"> Selectionner </option>
											<option value="" onclick="showType()"> Type </option>
											<option value="" onclick="showForfait()"> Forfait </option>
											
											
											
										</select>
									</div>
								</div>




								
							</form>
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<div class="bs-example" data-example-id="form-validation-states"> -->
    
<!--   </div> -->
  
					
						
			
	</div>
<!-- 	</div></div> -->
	



<div class="container" id="type" style="display: none;" >
    
<!-- 			<div id="page-wrapper"> -->
<!-- 				<div class="graphs"> -->
<!-- 					<h3 class="blank1">Ajout d'une localité</h3> -->
<!-- 						<div class="tab-content"> -->
<!-- 						<div class="tab-pane active" id="horizontal-form"> -->
							<form class="form-horizontal"  method="post" action="Parametrage" >
								
									<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code type</label>
									<div class="col-sm-8">
										<input type="text" name="codeType" class="form-control1" id="focusedinput" placeholder="Default Input" value=""  style="width:50%" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>






								
								
								
<!-- 								</br> -->
								
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
<!-- 									<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button> -->
									<button class="btn-success btn" type="submit" name="AType" >Ajouter</button>
									<button class="btn-default btn" type="submit" name="A" >Annuler</button>
<!-- 									<button class="btn-inverse btn" >Réinitialiser</button> -->
								</div>
								</div>
								
							</form>
<!-- 						</div> -->
<!-- 					</div> -->
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div></div>
  
  
  
  
  
  
  <div class="container" id="forfait" style="display: none;" >
    
<!-- 			<div id="page-wrapper"> -->
<!-- 				<div class="graphs"> -->
<!-- 					<h3 class="blank1">Ajout d'une localité</h3> -->
<!-- 						<div class="tab-content"> -->
<!-- 						<div class="tab-pane active" id="horizontal-form"> -->
							<form class="form-horizontal"  method="post" action="Parametrage" >
								

								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code forfait</label>
									<div class="col-sm-8">
										<input type="text" name="codeForfait" class="form-control1" id="focusedinput" placeholder="Default Input" value=""  style="width:50%" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>


								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Cout forfait</label>
									<div class="col-sm-8">
										<input type="number" step="100" min="0" name="coutForfait" class="form-control1" id="focusedinput" placeholder="Default Input" value="0" style="width:50%" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>


								
								
								
<!-- 								</br> -->
								
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
<!-- 									<button class="btn-success btn" type="submit" name="VN">Valider et nouvel ajout</button> -->
									<button class="btn-success btn" type="submit" name="AForfait" >Ajouter</button>
									<button class="btn-default btn" type="submit" name="A" >Annuler</button>
<!-- 									<button class="btn-inverse btn" >Réinitialiser</button> -->
								</div>
								</div>
								
							</form>
<!-- 						</div> -->
<!-- 					</div> -->
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>
  
					
						
			
	</div>
<!-- 	</div></div> -->



<!-- SCRIPTS -->
<script src="js/html5shiv.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script src="js/script.js"></script>

<script type="text/javascript">
function showNothing(){

	var type = document.getElementById('type');
	type.style.display='none';
	
	var forfait = document.getElementById('forfait');
	forfait.style.display='none';
	
}
function showType(){
	
	var type = document.getElementById('type');
	type.style.display='block';
	
	var forfait = document.getElementById('forfait');
	forfait.style.display='none';
	
}
function showForfait(){
	
	var type = document.getElementById('type');
	type.style.display='none';
	
	var forfait = document.getElementById('forfait');
	forfait.style.display='block';
	
}

</script>



</body>
</html>