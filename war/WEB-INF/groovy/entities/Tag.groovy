package entities

import groovyx.gaelyk.obgaektify.ObgaektifiableStringId;
import groovyx.gaelyk.obgaektify.ObgaektifyDAO;

import java.io.Serializable;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

class Tag extends ObgaektifiableStringId implements Serializable {
	String name
	List<String> blogs
		
	static syncBlogAndTags(def blog, def toAdd, def toRemove) {
		def log = Logger.getLogger(Tag.class.toString())
		def dao = new ObgaektifyDAO()
		
		// Add New Tags
		if(toAdd)
			toAdd.each{
				def tag
				try {
					tag = Tag.fetch(it)
					log.info "${tag} fetched"
				} catch(e) {}
				if(! tag) {
					tag = new Tag()
					tag.id = it
				}
				if(!tag.blogs) tag.blogs = new ArrayList<String>()
				tag.blogs.add(blog)
				log.info "add ${blog} to ${tag}"
				dao.store(tag)
			}
		
		// Remove New Tags
		if(toRemove)
			toRemove.each{
				def tag
				try {
					tag = Tag.fetch(it)
					log.info "${tag} fetched"
				} catch(e) {}
				
				if(tag) {
					tag.blogs-= blog
					log.info "Remove ${blog} from ${tag}"
					if(tag.blogs.isEmpty())
						dao.destoy(tag)
					else
						dao.store(tag)
				}
			}
	}
	
	static List getTags() {
		return Tag.search()
	}
}
