package blog.attachments

import entities.Attachment;
import entities.BlogEntry;

def blogid

// Récupérer la Liste
if (params.year != null &&
	params.month != null &&
	params.day != null &&
	params.title != null) {
	
	log.info("load blog : ${params.year}/${params.month}/${params.day}/${params.title} ")
	def blog = BlogEntry.getBlog(params.year, params.month, params.day, params.title)
	
	blogid = blog.id
	request.blog = blog
}

request.attachments = Attachment.getAttachments(blogid)

forward("/attachments.gtpl")