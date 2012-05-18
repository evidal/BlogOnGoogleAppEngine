<% import ys.wikiparser.WikiParser;
include '/WEB-INF/includes/header.gtpl' %>
	<div id="main" class="wrapper">
		<% include '/aside.gtpl' %>
		
		<%  request.blogentries.each{ blog -> %>
		<article>
			<header>
				<h3><a href="/article/${blog.id}">${blog.title}</a></h3>
				<div id="blogdate">Le ${blog.datePublication.format('dd/MM/yyyy')}</div>
				<% if (user && users.userAdmin) { %>
					<h4>
						<a href="/edit/${blog.id}" id="edit" class="button">Edit</a>
						<a href="/delete/${blog.id}" id="delete" class="button">Delete</a>
					</h4>
				<% } %>
			</header>

			<p>${blog.formattedShortContent}</p>
			<%if (blog.readMore) { %>
			<a href="/article/${blog.id}">Lire la suite...</a>
			<% } %>
			<p>
				<div id="tag">Tags : <% blog.tags.split(",").collect{it.trim()}.each{tag ->%>
				<a href="/tag/${tag}">${tag}</a>
				<% } %>
				</div>
				<div id="commentaire">
				Pas de Commentaire
				</div>
			</p>
		</article>
		<%}%>
	<% def page = request.page %>

	<div id="pagination">
		<% if((request.blogentries != null) && (request.blogentries.size() >= 10)) { %>
		<a href="${params.tag ? '/tag/'+params.tag+'/'+((page as int) + 1) : '/blog/page/'+((page as int) + 1)}">Un peu avant</a>
		<% } %>
		<%if(page > 1) { %>
		<a href="${params.tag ? '/tag/'+params.tag+'/'+((page as int) - 1) : '/blog/page/'+((page as int) - 1)}">Un peu apr&egrave;s</a>
		<% } %>
	</div>
	
	</div>
	<script type="text/javascript">
	\$(function(){
		\$('#edit, #delete').button();
	});
	</script>
<% include '/WEB-INF/includes/footer.gtpl' %>