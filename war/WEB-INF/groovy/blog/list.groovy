package blog
import entities.BlogEntry
import entities.Tag;
import com.google.appengine.api.users.User;

final int maxBlog = 10
def page = params.page ? params.page : 0
page=(page as int) - 1
page = page >= 0 ? page : 0



if (!user || !users.isUserAdmin()) {
	log.info "not logged in"
}


if(params.tag) {
	if (!user || !users.isUserAdmin()) {
		request.blogentries = BlogEntry.getBlogsPerTagPaginated(params.tag, maxBlog, page)
	} else {
		request.blogentries = BlogEntry.getBlogsPerTagPaginatedAdmin(params.tag, maxBlog, page)
	}
	
	request.tag = params.tag
} else {
	if (!user || !users.isUserAdmin()) {
		request.blogentries = BlogEntry.getBlogsPaginated(maxBlog, page)
	} else {
		request.blogentries = BlogEntry.getBlogsPaginatedAdmin(maxBlog, page)
	}
}

request.page = page + 1
log.info("Request page = "+ request.page)
log.info("size = "+request.blogentries.size())

// Aside
request.tags = Tag.getTags()
request.tenLastBlogs = BlogEntry.getBlogsPaginated(10, 0)

forward "/blog.gtpl"