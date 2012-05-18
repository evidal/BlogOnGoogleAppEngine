package entities

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Id;
import javax.persistence.PrePersist;

import ys.wikiparser.WikiParser;

import groovyx.gaelyk.obgaektify.ObgaektifiableStringId;

import com.google.appengine.api.datastore.Entity
import com.google.appengine.api.datastore.Key
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

class BlogEntry extends ObgaektifiableStringId implements Serializable {
	String title
	String content
	String tags
	Date datePublication
	Boolean published
	
	@PrePersist
	void validate() {
		if(null.equals(title) || "".equals(title)) throw new Exception()
		if(null.equals(content) || "".equals(content)) throw new Exception()
		if(null.equals(datePublication)) throw new Exception()
	}
		
	String toString() {
		//datePublication.year+"/"+datePublication.month+"/"+datePublication.day+"/"+
		return datePublication.format("yyyy/MM/dd")+"/"+title+" : "+content+" ; "+tags
	}
	
	public String getFormattedContent() {
		return WikiParser.renderXHTML(this.content)
	}
	
	public String getFormattedShortContent() {
		def formattedContent = getFormattedContent()
		def indexBreak = formattedContent.indexOf('<hr/>') -1
		if( indexBreak != -2) {
			formattedContent = formattedContent[0..indexBreak]
		}
		return formattedContent	
	}
	
	public boolean isReadMore(){
		def formattedContent = getFormattedContent()
		def indexBreak = formattedContent.indexOf('<hr/>') -1
		if( indexBreak != -2) {
			return true
		}
		return false
	}
	
	public int getNumberOfComment(){
		// Rajouter un compteur au niveai de l'entité pour éviter le comptage
		return 0;
	}
		
	static BlogEntry getBlog(key) {
		try {
			return BlogEntry.fetch(key)
		} catch(EntityNotFoundException) {
			return null;
		}
	}
	
	static BlogEntry getBlog(date, title) {
		try {
			return BlogEntry.fetch( date.format("yyyy/MM/dd")+"/"+title)
		} catch(EntityNotFoundException) {
			return null;
		}
	}
	
	static BlogEntry getBlog(year, month, day, title) {
		Date date = new GregorianCalendar(year as Integer,(month as Integer)-1,day as Integer).getTime()
		try {
			def key = date.format("yyyy/MM/dd")+"/"+title
			return BlogEntry.fetch( key )
		} catch(EntityNotFoundException) {
			return null;
		}
	}
	
	static List<BlogEntry> getAllBlogs() {
		return BlogEntry.search(sort: 	["-datePublication"])
	}
	
	static List<BlogEntry> getBlogsPaginated(pageSize,pageNumber) {
		
		return BlogEntry.search(
			filter: ["published in ":[true]],
			sort: 	["-datePublication"],
			limit: pageSize,
			offset : pageSize*pageNumber)
	}
	
	static List<BlogEntry> getBlogsPerTagPaginated(tag, pageSize,pageNumber) {		
		Tag t = Tag.fetch(tag)
		
		return BlogEntry.search(
			filter: ["id in  ":t.blogs,
					 "published in ":[true]],
			sort: 	["-datePublication"],
			limit: pageSize,
			offset : pageSize*pageNumber)
	}
	
	static List<BlogEntry> getBlogsPaginatedAdmin(pageSize,pageNumber) {
		
		return BlogEntry.search(
			sort: 	["-datePublication"],
			limit: pageSize,
			offset : pageSize*pageNumber)
	}
	
	static List<BlogEntry> getBlogsPerTagPaginatedAdmin(tag, pageSize,pageNumber) {
		Tag t = Tag.fetch(tag)
		
		return BlogEntry.search(
			filter: ["id in  ":t.blogs],
			sort: 	["-datePublication"],
			limit: pageSize,
			offset : pageSize*pageNumber)
	}
	
	
	static List<BlogEntry> getBlogsPerMonth(year,month) {		
		def dateMin = new GregorianCalendar(year,month-1,1).getTime()
		def calMax = new GregorianCalendar(year,month,1)
		calMax.add(Calendar.DATE,1)
		def dateMax = calMax.getTime()
		
		return BlogEntry.search(
			filter: ["datePublication >=":dateMin,
					 "datePublication <=":dateMax],
			sort: 	["-datePublication"])
	}
	
	static List<String> getArchivesMonth() {
		return null;	
	}
}