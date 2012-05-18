package entities

import groovyx.gaelyk.obgaektify.ObgaektifiableLongId

import java.io.Serializable;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;

class Attachment extends ObgaektifiableLongId implements Serializable {
	String blobid
	String filename
	String contentType
	Date creation
	long size
	@Parent Key<BlogEntry> blog
	
	static List<Attachment> getAttachments(String blogid) {
		return Attachment.search(ancestor: new Key(BlogEntry.class, blogid))
	}
	
	static void getAttachment(String key) {

	}
}
