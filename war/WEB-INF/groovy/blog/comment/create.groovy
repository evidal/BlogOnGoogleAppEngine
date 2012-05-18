package blog.comment

import org.apache.commons.lang.StringEscapeUtils;

import com.googlecode.objectify.Key

import entities.BlogEntry;
import entities.Comment;

log.info "Parameters : "+params.toString()
def comment = new Comment()
comment << params
comment.date = new Date()
comment.blog = new Key(BlogEntry.class, params.blogpath)
comment.comment = StringEscapeUtils.escapeHtml(comment.comment)
// Store Blog
dao.store(comment)

redirect "/article/${params.blogpath}"