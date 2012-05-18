<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	
	<title>Eric Vidal</title>
	<meta name="description" content="Blog d'Eric Vidal">
	<meta name="author" content="E.VIDAL">	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="/favicon.ico">
	<link rel="apple-touch-icon" href="/apple-touch-icon.png">
	<link rel="stylesheet" href="/css/style.css?v=2" type="text/css" >
	<link rel="stylesheet" href="/css/smoothness/jquery-ui-1.8.13.custom.css" type="text/css" >
    
	<script type="text/javascript" src="/js/libs/modernizr-1.7.min.js"></script>
	<script type="text/javascript" src="/js/libs/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="/js/libs/jquery-ui-1.8.13.custom.min.js"></script>
	
	<script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-28850873-1']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>		    
</head>
<body>
	<div id="header-container">
		<header class="wrapper">
			
      <h1 id="title">
      <img alt="logo" src="/images/us_lightbulb.png" width="70" height="80" id="logo">
      Le Blog d'Eric Vidal <small>(beta)</small>
      </h1>
			<nav>
				<ul>
					<li><a href="/blog">Blog</a></li>
					<li><a href="/blog/auteur">Auteur</a></li>
					<% if (user && users.userAdmin) {%>
						<li><a href="/edit">Nouveau Blog</a></li>
						<li><a href="${users.createLogoutURL("/")}">D&eacute;connexion</a></li>
					<%} %>
				</ul>
			</nav>
		</header>
	</div>
