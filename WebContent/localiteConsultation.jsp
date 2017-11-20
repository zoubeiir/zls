<!DOCTYPE HTML>






<%@page import="entity.Ligne"%>
<%@page import="java.util.List"%>
<%@page import="entity.Localite"%>
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
 
<% Localite localite = (Localite) request.getSession().getAttribute("localite");
List<Ligne> listeLigne = (List<Ligne>) request.getSession().getAttribute("listeLigne");


%>


<!--     Fonts and icons     -->
    <link href="css/css/css/css/font-awesome.min.css" rel="stylesheet">


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
					<h3 class="blank1">Consultation d'une localité</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="GestionLocalite" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Code localité</label>
									<div class="col-sm-8">
										<input type="text" name="codeLocalite" class="form-control1" id="focusedinput" placeholder="" value="<%= localite.getCode() %>"  style="width:50%; background-color: grey; " readonly="readonly" >
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
										<input type="text" name="adressePostale" class="form-control1" id="focusedinput" placeholder="" value="<%= localite.getAdressePostale() %>"  style=" background-color: grey; " readonly="readonly"   >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Adresse IP</label>
									<div class="col-sm-8">
										<input type="text" name="adresseIP" class="form-control1" id="focusedinput" placeholder="" value="<%= localite.getAdresseIP() %>"  style="width:50%; background-color: grey; " readonly="readonly" >
									</div>
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Responsable</label>
									<div class="col-sm-8">
										<input type="text" name="responsable" class="form-control1" id="focusedinput" placeholder="" value="<%= localite.getResponsable() %>"  style="width:50%; background-color: grey; " readonly="readonly" >
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
<!-- 											<option>Siège</option> -->
											
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								
								
								</br>
	
	
	
	
	
	
	
	
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
									<button class="btn-success btn"  type="submit" name="M" >Modifier</button>
									<button class="btn-default btn" type="submit" name="R" >Retour</button>
								</div>
								</div>
								
							</form>
						</div>
					</div>
					
					<div class="bs-example" data-example-id="form-validation-states">
    
  </div>
  
  
  
					
		<% if(listeLigne!=null){
	if(listeLigne.size()>0){ %>

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
                							<tr>
<!--                 								<th></th> -->
                								<th>Numéro ligne</th>
                								<th>date de création</th>
                								<th>localite</th>
                								<th>type</th>
                								<th class="disabled-sorting text-right">Actions</th>
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
                							
                							
											<%for(int i=0; i<listeLigne.size(); i++) { %>
										<tr style="background-color: white">
<%-- 											<td><input type="checkbox" name="checkbox" value="<%= listeLigne.get(i).getNumero() %>" ></td> --%>
											<td><%= listeLigne.get(i).getNumero() %></td>
											<td><%= listeLigne.get(i).getDateCreation() %></td>
<%-- 											<td><%= listeLigne.get(i).getFrais() %></td> --%>
    										<td><%= listeLigne.get(i).getLocalite().getCode() %></td>
    										<td><%= listeLigne.get(i).getType().getCode() %></td>
    										<td class="text-right">
       											<a href="GestionLigne?numeroLigne=<%=listeLigne.get(i).getNumero().replace("+", "%2B") %>" class="btn btn-simple btn-info btn-icon like"><i class="fa fa-info"></i></a>
       											<a href="GestionLigne?numeroLigne=<%=listeLigne.get(i).getNumero().replace("+", "%2B")%>&mf=m" class="btn btn-simple btn-warning btn-icon edit"><i class="fa fa-edit"></i></a>
<!--        											<a href="#" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-times"></i></a> -->
   	 										</td>
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
<% }} %>				
			
	</div>
	</div></div>





</body>
</html>