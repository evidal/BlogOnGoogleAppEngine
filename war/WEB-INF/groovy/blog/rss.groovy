package blog
import entities.BlogEntry;


def blogs = BlogEntry.getBlogsPaginated(5, 0)
def lastBuildDate = blogs[0].datePublication
//def site = "http://eric-vidal.appspot.com"
def site = "http://www.eric-vidal.com"
println "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>"
println "<rss version=\"2.0\">"
println "	<channel>"
println "		<title>Le Blog d'Eric Vidal</title>"
println "		<description>Flux RSS 2.0 du Blog d'Eric Vidal</description>"
println "		<lastBuildDate>${lastBuildDate}</lastBuildDate>"
println "		<link>${site}</link>"
blogs.each{ 
println "		<item>"
println "			<title>${it.title}</title>"
println "			<description>${it.content}</description>"
println "			<pubDate>${it.datePublication}</pubDate>"
println "			<link>${site}/article/${it.id}/${it.title}</link>"
println "		</item>"
}
println "	</channel>"
println "</rss>"
