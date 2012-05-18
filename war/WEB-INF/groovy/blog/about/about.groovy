package blog.about;
import entities.BlogEntry;
import entities.Tag;

// Aside
request.tags = Tag.getTags()
request.tenLastBlogs = BlogEntry.getBlogsPaginated(10, 0)

forward "/about.gtpl"