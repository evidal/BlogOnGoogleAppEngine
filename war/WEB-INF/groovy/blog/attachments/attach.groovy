package blog.attachments

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;

import entities.Attachment;
import entities.BlogEntry;

// check si un fichier vient d'être uploadé
log.fine "Parameters : "+params.toString()
def blobs = blobstore.getUploadedBlobs(request)
def blobKey = blobs["attachment"]

response.status = 302

if (blobKey) {
	Attachment attachment = new Attachment()
	attachment.blobid=blobKey.keyString
	attachment.filename=params.blogid+"/"+blobKey.filename
	attachment.contentType=blobKey.contentType
	attachment.size=blobKey.size
	attachment.creation=blobKey.creation
	attachment.blog=new Key(BlogEntry.class, params.blogid)
	
	dao.store(attachment)
}


redirect("/blog/attachments/${params.blogid}")