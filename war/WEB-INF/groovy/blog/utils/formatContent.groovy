package blog.utils

import ys.wikiparser.WikiParser;

log.info("content : "+params.content)
println(WikiParser.renderXHTML(params.content))