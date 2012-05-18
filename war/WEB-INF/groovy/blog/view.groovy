package blog
import com.googlecode.objectify.Key;

import entities.BlogEntry;
import entities.Comment;
import entities.Tag;

log.info("View Blog")

if (params.year != null &&
	params.month != null &&
	params.day != null && 
	params.title != null) { 
	
	log.info("load blog : ${params.year}/${params.month}/${params.day}/${params.title} ")	
	request.blog = BlogEntry.getBlog(params.year, params.month, params.day, params.title)
	
	request.comments = Comment.search(ancestor: new Key(BlogEntry.class, request.blog.id))
}

// Aside
request.tags = Tag.getTags()
request.tenLastBlogs = BlogEntry.getBlogsPaginated(10, 0)
	
forward "/viewblog.gtpl"