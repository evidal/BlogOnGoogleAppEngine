<% include '/WEB-INF/includes/header.gtpl' %>
<script type="text/javascript" src="/js/libs/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/libs/messages_fr.js"></script>
<script>
  \$(document).ready(
  	function(){
    \$("#commentForm").validate();
  });
</script>
   	
	<div id="main" class="wrapper">
		<% include '/aside.gtpl' %>
		
		<article>
			<header>
				<h3><a href="/article/${request.blog.id}">${request.blog.title}</a></h3>
				Le ${request.blog.datePublication.format('dd/MM/yyyy')},  Tags : <% request.blog.tags.split(",").collect{it.trim()}.each{tag ->%>
				<a href="/tag/${tag}">${tag}</a>
				<% } %>
				<% if (user && users.userAdmin) { %>
					<a href="/edit/${request.blog.id}" id="edit" class="button">Edit</a>
					<a href="/delete/${request.blog.id}" id="delete" class="button">Delete</a>
				<% } %>
			</header>
			
			<p>${request.blog.formattedContent}</p>
		</article>
		
		<div id=comments>
			<h2>Comments</h2>
			<%request.comments.each{comment -> %>
				<h3>
				${comment.alias} le ${comment.date.format("dd/MM/yy")}
				<% if (user && users.userAdmin) { %>
				<a href="/blog/comment/delete.groovy?id=${comment.id}&blog=${request.blog.id}" class="button ui-state-default ui-corner-all">
				<span class="button ui-icon ui-icon-closethick"></span>
				</a>
				<% } %>
				</h3>
				<p>${comment.comment}</p>
			<% } %>
			<div id="commentform">
				<form method="POST" action="/blog/comment/create.groovy" id="commentForm">
					
					<input type="hidden" name="blogpath" value="${request.blog.id}">
					
					<fieldset>
						<legend>Nouveau Commentaire</legend>
						<label for="email">Email *  : </label>
						<input type="email" name="email" id="f_email" value="" size="25" class="required email">

						<label for="alias">Nom * : </label>
						<input type="text" name="alias" id="f_alias" value="" size="25" class="required">
					</fieldset>
					Comment * : 
					<textarea rows="10" cols="80" name="comment" id="f_comment" class="required"></textarea>
					<br>
					<input type="submit" name="save" value="Add Comment">
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	\$(function(){
		\$('#edit, #delete').button();
	});
	</script>
<% include '/WEB-INF/includes/footer.gtpl' %>