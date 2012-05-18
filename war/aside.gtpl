		<aside>
			<p>	
				<a title="Twitter" href="http://twitter.com/#!/EricVidalPro"><img src="/images/twitter.png"></a>
				<a title="Linkedin" href="http://www.linkedin.com/pub/eric-vidal/4/582/99"><img src="/images/linkedin.png"></a>
				<a title="Viadeo" href="http://www.viadeo.com/fr/profile/eric.vidal"><img src="/images/viadeo.png"></a>
				<a title="RSS" href="/blog/eric-vidal.rss"><img src="/images/RSS.png"></a>
			</p>
			
			<p>
			<h3>Articles Pr&eacute;c&eacute;dents</h3>
			<ul>
			<% request.tenLastBlogs.each { %>
				<li ><a class="recent" href="/article/${it.id}">${it.datePublication.format('dd/MM/yyy')} ${it.title}</a></li>
			<% } %>
			</ul>
			</p>
			
			<p>
			<h3><a href="/blog/archives" class="asidelink">Archives</a></h3>
			</p>
			<p>
			<h3>Tags</h3>
			<% request.tags.each { %>
				<a href="/tag/${it.id}" style="font-size: ${(Math.log(it.blogs.size() + 1)) * 5}mm;">${it.id}</a>
			<% } %>
			</p>
			
		</aside>
		