package blog
import entities.BlogEntry
import entities.Tag;

// Main page
request.blogentries = BlogEntry.getAllBlogs();

// Aside
request.tags = Tag.getTags()
request.tenLastBlogs = BlogEntry.getBlogsPaginated(10, 0)

forward "/archive.gtpl"
