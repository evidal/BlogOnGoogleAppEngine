package entities

import groovyx.gaelyk.obgaektify.ObgaektifiableLongId
import java.io.Serializable

import javax.persistence.PrePersist;

import com.googlecode.objectify.annotation.Parent
import com.googlecode.objectify.Key

class Comment extends ObgaektifiableLongId implements Serializable {
	String comment
	String email
	String alias
	Date date
	Boolean published
	@Parent Key<BlogEntry> blog
	
	@PrePersist
	void validate() {
		if(null.equals(comment) || "".equals(comment)) throw new Exception()
		if(null.equals(email) || "".equals(email) ||
			!(email ==~ /^[a-zA-Z][\w\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/ )) throw new Exception()
		if(null.equals(alias) || "".equals(alias)) throw new Exception()
		if(null.equals(date) || "".equals(date)) throw new Exception()
		if(null.equals(blog)) throw new Exception()		
	}
}
