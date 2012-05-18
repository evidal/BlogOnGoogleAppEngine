package blog
import entities.BlogEntry
import entities.Tag;
import groovyx.gaelyk.obgaektify.ObgaektifyDAO;

if(users.isUserAdmin() ) {
	
	// get blog to update
	def blog = BlogEntry.getBlog(params.id)
	def oldTags = blog.tags.split(",").collect{it.trim()}
	
	log.info "Parameters : "+params.toString()
	// Cast date Publication as date
	params.datePublication = Date.parse("dd/MM/yyyy",params.datePublication )
	// Check Published flag
	params.published = params.published ? params.published : false
	blog << params	
	
	// Now tag
	log.info("oldTags : "+oldTags)
	def toAdd = params.tags ? params.tags.split(",").collect{it.trim()} : []
	log.info("To add : "+toAdd)
	def toRemove = oldTags - toAdd
	log.info("To remove : "+toRemove)
	toAdd-=oldTags
	
	// Store Blog
	dao.store(blog)
	log.info "Blog Stored : "+blog.toString()
	
	// Store Tags
	Tag.syncBlogAndTags(blog.id, toAdd, toRemove)
	log.info "TAGS Stored"
}
redirect "/blog"
