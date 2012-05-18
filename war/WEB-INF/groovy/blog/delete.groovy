package blog
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import entities.BlogEntry;
import entities.Tag;

log.info("Edit Blog")

if (users.isUserAdmin() &&
	params.year != null &&
	params.month != null &&
	params.day != null && 
	params.title != null) {
	
	log.info("load blog : ${params.year}/${params.month}/${params.day}/${params.title} ")
	def blog = BlogEntry.getBlog(params.year, params.month, params.day, params.title)
	def tagsToRemove = blog.tags
	blog.destroy();
	
	// Remove Tags
	Tag.syncBlogAndTags(blog.id, null, tagsToRemove.split(",").collect{it.trim()})
	log.info "TAGS Stored"
}

redirect "/blog"
