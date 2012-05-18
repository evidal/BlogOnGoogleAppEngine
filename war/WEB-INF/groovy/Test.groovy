import entities.Tag

Tag.getTags().each {
	log.info(it.id)
}