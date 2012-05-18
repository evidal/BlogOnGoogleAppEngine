package blog
import entities.BlogEntry
import entities.Tag;
import groovyx.gaelyk.obgaektify.ObgaektifyDAO;

if(users.isUserAdmin() ) {

	log.info "Parameters : "+params.toString()
	
	// Cast date Publication as date
	params.datePublication = Date.parse("dd/MM/yyyy",params.datePublication )
	log.info "params.datePublication : "+params.datePublication
	
	// Populating Blog
	def blog = new BlogEntry()
	blog << params
	blog.setId blog.datePublication.format("yyyy/MM/dd")+"/"+blog.title
	log.info "blog.datePublication : "+blog.datePublication
	
	// Check that no identical blog exists, if yes show an error message
	if (null != (BlogEntry.getBlog(blog.datePublication, blog.title))){
		request.errormessage = "Un blog avec le même titre et le même jour existe"
		forward "/edit"
	}
	
	// Store things	
	// Store Blog
	dao.store(blog)
	log.info "Blog Stored : "+blog.toString()
	
	// Store Tags
	Tag.syncBlogAndTags(blog.id, params.tags.split(",").collect{it.trim()}, null)
	log.info "TAGS Stored"
}
redirect "/blog"