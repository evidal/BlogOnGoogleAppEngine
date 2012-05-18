package blog
import com.google.appengine.api.users.User;

if (!user || !users.isUserAdmin()) {
	log.info "not logged in"
	redirect users.createLoginURL("/blog")
}

redirect "/blog"