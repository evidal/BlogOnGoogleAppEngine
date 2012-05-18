<% include '/WEB-INF/includes/header.gtpl' %>

	<div id="main" class="wrapper">
		<form method="POST" enctype="multipart/form-data" action="${blobstore.createUploadUrl('/blog/attachments/attach.groovy')}" id="blogForm">
			
			<a href="/edit/${request.blog.id}" id="back" class="button">Return to Blog Edition</a>
			<br>
			<br>
			<table class="files">
				<tr>
					<th class="files">File
					<th class="files">Content Type
					<th class="files">Creation Date
					<th class="files">Size
					<th class="files">
					<th class="files">
				</tr>
				<%  request.attachments.each{ a -> %>
				<tr>
					<td class="files">${a.filename}
					<td class="files">${a.contentType}
					<td class="files">${a.creation.format('dd/MM/yyyy HH:mm')}
					<td class="files">${a.size / 1024} ko
					<td class="files"><a href="/blog/get/${a.filename}"><span class="ui-icon ui-icon-trash"></span></a>
					<td class="files"><a href="/blog/get/${a.filename}"><span class="ui-icon ui-icon-extlink"></span></a>
				</tr>
				<% } %>
			</table>
			<br>
			<br>
			<input type="hidden" name="blogid" value="${request.blog.id}">	
		
			<fieldset>
				<label for="title" class="blogform">Fichier</label>
				<input type="file" name="attachment" id="f_attachment">
				<input type="submit" name="Envoyer" value="Envoyer">
			</fieldset>						
		</form>
	</div>

<script type="text/javascript">
	\$(function(){
		\$('#back').button();
	});
</script>
		
<% include '/WEB-INF/includes/footer.gtpl' %>