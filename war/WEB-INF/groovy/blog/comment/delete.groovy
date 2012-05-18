package blog.comment

import com.googlecode.objectify.Key

import entities.BlogEntry;
import entities.Comment;

if (user && users.userAdmin) { 
	log.info "Parameters : "+params.toString()
	def blogKey = new Key(BlogEntry.class, params.blog)
	def commentKey = new Key(blogKey, Comment.class, params.id as Long	)
	
	// Remove Comment
	commentKey.destroy()
}
redirect "/article/${params.blog}"