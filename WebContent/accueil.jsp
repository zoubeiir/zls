<!doctype html>
<html>
<head lang="en">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>IAM - RAPPROCHEMENT DES FACTURES</title> 
	<meta name="description" content="BlackTie.co - Free Handsome Bootstrap Themes" />	    
	<meta name="keywords" content="themes, bootstrap, free, templates, bootstrap 3, freebie,">
	<meta property="og:title" content="">
	
<!-- 	icon de l'onglet -->
	<link rel="shortcut icon" href="images/favicon.ico">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	
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
<body>
	<div class="navbar navbar-fixed-top" data-activeslide="1">
		<div class="container">
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav row">
					<li data-slide="1" class="col-12 col-sm-2"><a  href="accueil.jsp" title=""><span class="icon icon-home" style="color: brown"></span> <span class="text" style="color: brown ;">ACCUEIL</span></a></li>
					<li data-slide="3" class="col-12 col-sm-2"><a id="menu-link-3" href="ligne.jsp" title=""><span class="icon icon-user" style="color: "></span> <span class="text" style="color: ">LIGNES</span></a></li>
					<li data-slide="2" class="col-12 col-sm-2"><a id="menu-link-2" href="localite.jsp" title=""><span class="icon icon-phone" style="color: "></span> <span class="text" style="color: ">LOCALITES</span></a></li>
					<li data-slide="4" class="col-12 col-sm-2"><a id="menu-link-4" href="rapprochement.jsp" title=""><span class="icon icon-gears" style="color: "></span> <span class="text" style="color: ">RAPPROCHEMENT</span></a></li>
					<li data-slide="5" class="col-12 col-sm-2"><a id="menu-link-5" href="parametrage.jsp" title=""><span class="icon icon-ticket" style="color: "></span> <span class="text" style="color: ">PARAMETRAGE</span></a></li>
					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="Logout" title=""><span class="icon icon-signout"style="color: " ></span> <span class="text" style="color: ">SE DECONNECTER</span></a></li>
				</ul>
<!-- 				<div class="row"> -->
<!-- 					<div class="col-sm-2 active-menu"></div> -->
<!-- 				</div> -->
			</div><!-- /.nav-collapse -->
		</div><!-- /.container -->
	</div><!-- /.navbar -->
	
	<!-- === MAIN Background === -->
	<div class="slide story" id="slide-1" data-slide="1">
		<div class="container">
			<div id="home-row-1" class="row clearfix">
				<div class="col-12">
					<h1 class="font-semibold"><span class="font-thin">&nbsp;</span></h1>
					<h4 class="font-thin"><span class="font-semibold"></span></h4>
					<h4 class="font-thin"><span class="font-semibold">IAM - RAPPROCHEMENT DES FACTURES</span></h4>
				</div><!-- /col-12 -->
			</div><!-- /row -->
		</div><!-- /container -->
		<div class="container">
			<div id="contact-row-4" class="row">
				<div class="col-sm-2 hidden-sm">&nbsp;</div>
				
				<div class="col-12 col-sm-2 with-hover-text">
					<p><a  href="ligne.jsp"><i class="icon icon-phone"></i></a></p>
					<span class="hover-text font-light ">LIGNES<br></span>
				</div><!-- /col12 -->
				<div class="col-12 col-sm-2 with-hover-text">
					<p><a  href="localite.jsp"><i class="icon icon-home"></i></a></p>
					<span class="hover-text font-light ">LOCALITE</span>
				</div><!-- /col12 -->
				
				<div class="col-12 col-sm-2 with-hover-text">
					<p><a  href="rapprochement.jsp"><i class="icon icon-gears"></i></a></p>
					<span class="hover-text font-light ">RAPPROCHEMENT</span>
				</div><!-- /col12 -->
				<div class="col-12 col-sm-2 with-hover-text">
					<p><a  href="parametrage.jsp"><i class="icon icon-ticket"></i></a></p>
					<span class="hover-text font-light "> PARAMETRAGE TYPE/FORFAIT</span>
				</div><!-- /col12 -->
				
<!-- 				<div class="col-12 col-sm-2 with-hover-text"> -->
<!-- 					<p><a href="Logout"><i class="icon icon-signout"></i></a></p> -->
<!-- 					<span class="hover-text font-light "> DECONNECTION </span> -->
<!-- 				</div>/col12 -->
				
				<div class="col-sm-1 hidden-sm">&nbsp;</div>
			</div><!-- /row -->
		</div><!-- /container -->
		
		
	</div><!-- /slide1 -->
</body>

<!-- SCRIPTS -->
<script src="js/html5shiv.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<!-- <script src="js/bootstrap.min.js"></script> -->
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script src="js/script.js"></script>

</html>