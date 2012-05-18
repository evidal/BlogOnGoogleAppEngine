<% import ys.wikiparser.WikiParser;
include '/WEB-INF/includes/header.gtpl' %>
	<div id="main" class="wrapper">
		<% include '/aside.gtpl' %>
		
		<%  request.blogentries.each{ blog -> %>
			<h4>${blog.datePublication.format('dd/MM/yyyy')} <a href="/article/${blog.id}">${blog.title}</a></h4>
		<%}%>
	</div>
	
<% include '/WEB-INF/includes/footer.gtpl' %>