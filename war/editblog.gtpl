<% include '/WEB-INF/includes/header.gtpl' %>
<script type="text/javascript" src="/js/libs/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/libs/messages_fr.js"></script>
<script type="text/javascript">

\$.validator.addMethod(
    "frenchDate",
    function(value, element) {
        return value.match(/^[0-3]?[0-9]\\/[01]?[0-9]\\/[12][90][0-9][0-9]\$/);
    },
    "Please enter a date in the format dd/mm/yyyy"
);

\$(document).ready(
  	function(){
    \$("#blogForm").validate();
  });

</script>

	<div id="main" class="wrapper">
		<form method="POST" action="${request.edit ? '/blog/update':'/blog/create'}" id="blogForm">
			
			<input type="hidden" name="id" value="${request.blog ? request.blog.id :''}">	
		
			<fieldset>
				<label for="title" class="blogform">Title</label>
				<input type="text" name="title" id="f_title" value="${request.blog ? request.blog.title :''}" autofocus class="required">
			</fieldset>
			
			<fieldset>
				<label for="content" class="blogform">Content</label>				
				<br>
				<textarea rows="30" cols="150" name="content" id="f_content" class="required">${request.blog ? request.blog.content : ""}</textarea>
			</fieldset>
			<input type="button" id="previewer" value="Preview">
			<%  if(request.edit) {%>
				<a href="/blog/attachments/${request.blog.id}" id="attachments" class="button">Attachments</a>
			<%  } %>
			
			<fieldset>
				<label for="tags" class="blogform">TAGS</label>
				<input type="text" name="tags" id="f_tags" value="${request.blog ? request.blog.tags :''}" autofocus>
			</fieldset>
			
						
			<fieldset>
				<label for="date" class="blogform">Date</label>
				<input type="text" name="datePublication" id="f_date" value="${request.blog ? request.blog.datePublication.format('dd/MM/yyyy') : ''}" class="required frenchDate">
			</fieldset>
			
			<% def published = request.blog ? request.blog.published : true %>
			<fieldset>
				<label for="published" class="blogform">Publication</label>
				<input type="checkbox" name="published" id="f_published" ${published ? "checked": ""} >
			</fieldset>
			
			<input type="submit" name="save" value="Save">
		</form>
	</div>
	
	<div id="preview" title="Basic dialog"></div>
	
<script type="text/javascript">
	\$(function(){
		// Datepicker
		\$('#f_date').datepicker({ dateFormat: 'dd/mm/yy' });
		\$('input:submit').button();
		\$('#previewer').button();
		\$('#attachments').button();
		
		// Preview
		\$( "#preview" ).dialog({
			autoOpen: false,
			show: "blind",
			hide: "blind",
			width: 700,
			maxHeight : 400,
			position : top
		});

		\$( "#previewer" ).click(function() {
		    var cntnt = \$("#f_content").val();
 			
 			\$.post( "/blog/utils/formatContent.groovy", { content: cntnt },
		      function( data ) {
		          \$( "#preview" ).empty().append( data );
		      }
		    );
 			
			\$( "#preview" ).dialog("open");
			return false;
		});
	});
</script>

<% include '/WEB-INF/includes/footer.gtpl' %>