

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="entity.Ligne" %>
<%@ page import="javax.servlet.http.HttpServletRequest.*" %>
<%@page import="entity.Type"%>
<%@page import="entity.dao.TypeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Localite"%>
<%@page import="java.util.List"%>
<%@page import="staticReference.EtatStatic"%>
<%@page import="entity.LiaisonTypeForfait"%>



<%-- <% List<Facture> listeFacture = (List<Facture>) (request.getSession().getAttribute("listeFacture"));%> --%>
<% Ligne ligne = (Ligne) (request.getSession().getAttribute("ligne"));%>
<% List<LiaisonTypeForfait> listeLiaisonTypeForfait = (List<LiaisonTypeForfait>) (request.getSession().getAttribute("listeLiaisonTypeForfait"));%>

<%-- <% Porteur porteur = (Porteur) (request.getSession().getAttribute("porteur"));%> --%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<!-- 					<li data-slide="6" class="col-12 col-sm-2"><a id="menu-link-6" href="#slide-6" title=""><span class="icon icon-file"style="color: " ></span> <span class="text" style="color: ">Extraction</span></a></li> -->
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
					<h3 class="blank1">Consultation d'une ligne</h3>
						<div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal"  method="post" action="GestionLigne" >
								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label" style="color: white ;">Numéro ligne</label>
									<div class="col-sm-8">
										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="" value="<%= ligne.getNumero() %>"  style="width:50% ; background-color: grey;color:white;" readonly="readonly" >
									</div>
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white; width: 20%;">Numéro ligne</label> -->
<!-- 									<div class="col-sm-8">  -->
<!-- 										<input type="text" name="numeroLigne" class="form-control1" id="focusedinput" placeholder="" value="+212" style="width: 20%"> -->
<!-- 									</div> -->
									<div class="col-sm-2 jlkdfj1">
										<p class="help-block"></p>
									</div>
								</div>
								
<!-- 								<div class="form-group"> -->
<!-- 									<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Frais</label> -->
<!-- 									<div class="col-sm-8"> -->
<!-- 										<input type="number" step="100" min="0" name="fraisLigne" class="form-control1" id="focusedinput" placeholder="" value="0" style="width:50%" > -->
<!-- 									</div> -->
<!-- 									<div class="col-sm-2 jlkdfj1"> -->
<!-- 										<p class="help-block"></p> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								
								
								<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label" style="color: white">Date de création</label>
								<div class="col-sm-8">
									
									<% if(ligne.getDateCreation()!=null){ 
									String date = ligne.getDateCreation().toString();
									String year = date.substring(0, 4);
									String mounth = date.substring(5, 7);
									String day = date.substring(8, 10);
									
									
									%>
										
										<select    name="jour"  style="background-color: grey;color:white;width: 10%" disabled="disabled"> 
      										<option value="01" <% if(day.equals("01")){ %> selected="selected"<%} %>> 01 </option>
      										<option value="02" <% if(day.equals("02")){ %> selected="selected"<%} %>> 02 </option>
      										<option value="03" <% if(day.equals("03")){ %> selected="selected"<%} %>> 03 </option>
      										<option value="04" <% if(day.equals("04")){ %> selected="selected"<%} %>> 04 </option>
      										<option value="05" <% if(day.equals("05")){ %> selected="selected"<%} %>> 05 </option>
      										<option value="06" <% if(day.equals("06")){ %> selected="selected"<%} %>> 06 </option>
      										<option value="07" <% if(day.equals("07")){ %> selected="selected"<%} %>> 07 </option>
      										<option value="08" <% if(day.equals("08")){ %> selected="selected"<%} %>> 08 </option>
      										<option value="09" <% if(day.equals("09")){ %> selected="selected"<%} %>> 09 </option>
      										<option value="10" <% if(day.equals("10")){ %> selected="selected"<%} %>> 10 </option>
      										<option value="11" <% if(day.equals("11")){ %> selected="selected"<%} %>> 11 </option>
      										<option value="12" <% if(day.equals("12")){ %> selected="selected"<%} %>> 12 </option>
      										<option value="13" <% if(day.equals("13")){ %> selected="selected"<%} %>> 13 </option>
      										<option value="14" <% if(day.equals("14")){ %> selected="selected"<%} %>> 14 </option>
      										<option value="15" <% if(day.equals("15")){ %> selected="selected"<%} %>> 15 </option>
      										<option value="16" <% if(day.equals("16")){ %> selected="selected"<%} %>> 16 </option>
      										<option value="17" <% if(day.equals("17")){ %> selected="selected"<%} %>> 17 </option>
      										<option value="18" <% if(day.equals("18")){ %> selected="selected"<%} %>> 18 </option>
      										<option value="19" <% if(day.equals("19")){ %> selected="selected"<%} %>> 19 </option>
      										<option value="20" <% if(day.equals("20")){ %> selected="selected"<%} %>> 20 </option>
      										<option value="21" <% if(day.equals("21")){ %> selected="selected"<%} %>> 21 </option>
      										<option value="22" <% if(day.equals("22")){ %> selected="selected"<%} %>> 22 </option>
      										<option value="23" <% if(day.equals("23")){ %> selected="selected"<%} %>> 23 </option>
      										<option value="24" <% if(day.equals("24")){ %> selected="selected"<%} %>> 24 </option>
      										<option value="25" <% if(day.equals("25")){ %> selected="selected"<%} %>> 25 </option>
      										<option value="26" <% if(day.equals("26")){ %> selected="selected"<%} %>> 26 </option>
      										<option value="27" <% if(day.equals("27")){ %> selected="selected"<%} %>> 27 </option>
      										<option value="28" <% if(day.equals("28")){ %> selected="selected"<%} %>> 28 </option>
      										<option value="29" <% if(day.equals("29")){ %> selected="selected"<%} %>> 29 </option>
      										<option value="30" <% if(day.equals("30")){ %> selected="selected"<%} %>> 30 </option>
      										<option value="31" <% if(day.equals("31")){ %> selected="selected"<%} %>> 31 </option>
      										
      									</select>
      									
      									<select    name="mois" style="background-color: grey;color:white;width: 20%" disabled="disabled"> 
      										<option value="01" <% if(mounth.equals("01")){ %> selected="selected"<%} %>> janvier </option>
      										<option value="02" <% if(mounth.equals("02")){ %> selected="selected"<%} %>> Février </option>
      										<option value="03" <% if(mounth.equals("03")){ %> selected="selected"<%} %>> Mars </option>
      										<option value="04" <% if(mounth.equals("04")){ %> selected="selected"<%} %>> Avril </option>
      										<option value="05" <% if(mounth.equals("05")){ %> selected="selected"<%} %>> Mai </option>
      										<option value="06" <% if(mounth.equals("06")){ %> selected="selected"<%} %>> Juin </option>
      										<option value="07" <% if(mounth.equals("07")){ %> selected="selected"<%} %>> Juillet </option>
      										<option value="08" <% if(mounth.equals("08")){ %> selected="selected"<%} %>> Août </option>
      										<option value="09" <% if(mounth.equals("09")){ %> selected="selected"<%} %>> Septembre </option>
      										<option value="10" <% if(mounth.equals("10")){ %> selected="selected"<%} %>> Octobre </option>
      										<option value="11" <% if(mounth.equals("11")){ %> selected="selected"<%} %>> Novembre </option>
      										<option value="12" <% if(mounth.equals("12")){ %> selected="selected"<%} %>> Décembre </option>
      									</select>
      									
      									<select    name="annee" style="background-color: grey;color:white;width: 20%" disabled="disabled"> 
      										<option value="1999" <% if(year.equals("1999")){ %> selected="selected"<%} %>> 1999 </option>
      										<option value="2000" <% if(year.equals("2000")){ %> selected="selected"<%} %>> 2000 </option>
      										<option value="2001" <% if(year.equals("2001")){ %> selected="selected"<%} %>> 2001 </option>
      										<option value="2002" <% if(year.equals("2002")){ %> selected="selected"<%} %>> 2002 </option>
      										<option value="2003" <% if(year.equals("2003")){ %> selected="selected"<%} %>> 2003 </option>
      										<option value="2004" <% if(year.equals("2004")){ %> selected="selected"<%} %>> 2004 </option>
      										<option value="2005" <% if(year.equals("2005")){ %> selected="selected"<%} %>> 2005 </option>
      										<option value="2006" <% if(year.equals("2006")){ %> selected="selected"<%} %>> 2006 </option>
      										<option value="2007" <% if(year.equals("2007")){ %> selected="selected"<%} %>> 2007 </option>
      										<option value="2008" <% if(year.equals("2008")){ %> selected="selected"<%} %>> 2008 </option>
      										<option value="2009" <% if(year.equals("2009")){ %> selected="selected"<%} %>> 2009 </option>
      										<option value="2010" <% if(year.equals("2010")){ %> selected="selected"<%} %>> 2010 </option>
      										<option value="2011" <% if(year.equals("2011")){ %> selected="selected"<%} %>> 2011 </option>
      										<option value="2012" <% if(year.equals("2012")){ %> selected="selected"<%} %>> 2012 </option>
      										<option value="2013" <% if(year.equals("2013")){ %> selected="selected"<%} %>> 2013 </option>
      										<option value="2014" <% if(year.equals("2014")){ %> selected="selected"<%} %>> 2014 </option>
      										<option value="2015" <% if(year.equals("2015")){ %> selected="selected"<%} %>> 2015 </option>
      										<option value="2016" <% if(year.equals("2016")){ %> selected="selected"<%} %>> 2016 </option>
      										<option value="2017" <% if(year.equals("2017")){ %> selected="selected"<%} %>> 2017 </option>
      										<option value="2018" <% if(year.equals("2018")){ %> selected="selected"<%} %>> 2018 </option>
<!--       										<option value="2019"> 2019 </option> -->
<!--       										<option value="2020"> 2020 </option> -->
      										
      									</select>
      									<% }else{ %>
      										<select    name="jour" style="background-color: grey;color:white;width: 10%" disabled="disabled"> 
										
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
      									
      									<select    name="mois" style="background-color: grey;color:white;width: 20%" disabled="disabled"> 
      									
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
      									
      									<select    name="annee" style="background-color: grey;color:white;width: 20%" disabled="disabled"> 
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
      									<% }%>
    								
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
									<label class="col-sm-2 control-label" style="color: white">Localité</label>
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
											<label for="focusedinput" class="col-sm-2 control-label" style="color:white">Cout <%= listeLiaisonTypeForfait.get(i).getForfait().getCode() %></label>
											
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

								<div class="form-group">
									<label for="radio" class="col-sm-2 control-label" style="color: white">Etat</label>
									<div class="col-sm-8">
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" <% if(EtatStatic.ETAT_OPERATIONNEL.compareTo(ligne.getEtat())==0){ %> checked="checked" <% } %> value="0" disabled="disabled">Opérationnelle</label></div>
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" <% if(EtatStatic.ETAT_RESILIE.compareTo(ligne.getEtat())==0){ %> checked="checked" <% } %> value="1" disabled="disabled">Résiliée</label></div>
										<div class="radio-inline"><label style="color: white"><input name="etat" type="radio" <% if(EtatStatic.ETAT_CESSION.compareTo(ligne.getEtat())==0){ %> checked="checked" <% } %> value="2" disabled="disabled">Cession</label></div>
<!-- 										<div class="radio-inline"><label><input name="test" type="radio" disabled="" value=""> En cours de résiliation</label></div> -->
										
									</div>
								</div>
								
								<div class="row"  style="width:80%">
								<div class="col-sm-8 col-sm-offset-2" >
									
									<button class="btn-success btn" type="submit" name="M" >Modifier</button>
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
		    searchPlaceholder: "Recherche",
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