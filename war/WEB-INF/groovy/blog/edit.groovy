package blog
import entities.BlogEntry;


log.info("Edit Blog")

if (users.isUserAdmin() &&
	params.year != null &&
	params.month != null &&
	params.day != null && 
	params.title != null) {
	
	log.info("load blog : ${params.year}/${params.month}/${params.day}/${params.title} ")
	def blog = BlogEntry.getBlog(params.year, params.month, params.day, params.title)
	log.info("Retrieved Blog : "+blog)
	request.blog = blog
	request.edit = true
}

forward "/editblog.gtpl"
