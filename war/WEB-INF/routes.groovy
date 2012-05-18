get "/blog", forward: "/blog/list.groovy"
get "/blog/", forward: "/blog/list.groovy"
get "/blog/page/@page", forward: "/blog/list.groovy?page=@page"
get "/article/@year/@month/@day/@title", forward: "/blog/view.groovy?year=@year&month=@month&day=@day&title=@title"
get "/tag/@tag", forward: "/blog/list.groovy?tag=@tag"
get "/tag/@tag/@page", forward: "/blog/list.groovy?tag=@tag&page=@page"

get "/edit/@year/@month/@day/@title", forward: "/blog/edit.groovy?year=@year&month=@month&day=@day&title=@title"
get "/edit", forward: "/blog/edit.groovy"
get "/blog/get/@filename", redirect: "/blog/attachments/get.groovy?filename=@filename"
get "/blog/attachments/@year/@month/@day/@title", forward: "/blog/attachments/list.groovy?year=@year&month=@month&day=@day&title=@title"

post "/blog/create", forward: "/blog/create.groovy"
post "/blog/update", forward: "/blog/update.groovy"
get "/delete/@year/@month/@day/@title", forward: "/blog/delete.groovy?year=@year&month=@month&day=@day&title=@title"

get "/blog/admin", forward: "/blog/admin.groovy"
get "/blog/clear", forward: "/blog/clear.groovy"

get "/blog/archives", forward: "/blog/archive.groovy"

get "/blog/auteur", forward: "/blog/about/about.groovy"

get "/blog/eric-vidal.rss", forward: "/blog/rss.groovy"

get "/favicon.ico", redirect: "/images/small_lightbulb.png" 	