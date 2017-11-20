<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
<title>IAM - RAPPROCHEMENT DES FACTURES</title>
<link rel="shortcut icon" href="images/favicon.ico">
  
  
  
      <link rel="stylesheet" href="cssIndex/style.css">

  <%
	if( request!=null || session!=null){
	String username = (String) session.getAttribute("login");
	if(username!=null && username!="" && username!="0"){
		
			response.sendRedirect("accueil.jsp");
		}
			
	}
	
	%>
  
</head>

<body>
  <div class="login-page">
  <div class="form" >
  <center><img src="img/attawfiq.png" alt="Mountain View"></center>
  <p></p>
    <form class="login-form" method="post" action="Auth">
      <input type="text" placeholder="username" name="username" required="required"/>
      <input type="password" placeholder="password" name="password" required="required"/>
      <p></p>
      <button>login</button>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
