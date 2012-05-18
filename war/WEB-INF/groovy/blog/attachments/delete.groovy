package blog.attachments

import com.google.appengine.api.blobstore.BlobKey;

import entities.Attachment;


def attachments = Attachment.search(
	filter: ["filename =": params.filename]
)

def blobid
if(attachments.size > 0) {
	blobid = attachments[0].blobid
	log.fine("attachment found")
	
	BlobKey blob = new BlobKey(blobid)
	
}


redirect("/blog/attachments/${params.blogid}")