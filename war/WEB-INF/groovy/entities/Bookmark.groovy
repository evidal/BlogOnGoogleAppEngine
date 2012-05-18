package entities

import groovyx.gaelyk.obgaektify.ObgaektifiableLongId

import java.io.Serializable

class Bookmark extends ObgaektifiableLongId implements Serializable {
	String name
	String link
	String category
}
