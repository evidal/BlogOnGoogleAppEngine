def blobs = blobstore.getUploadedBlobs(request)
def blobKey = blobs["myTextFile"]

response.status = 302

if (blobKey) {
	redirect "/arch/success.gtpl?key=${blobKey.keyString}"	
} else {
	redirect "/arch/failure.gtpl"
}
