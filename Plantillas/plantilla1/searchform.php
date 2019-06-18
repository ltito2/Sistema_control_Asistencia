<form method="get" id="searchform" action="<?php bloginfo('url'); ?>/">
<h2>Search</h2>
<div><input type="text" value="<?php the_search_query(); ?>" name="s" id="search-text" />
<input type="submit" id="search-submit" value="GO" />
</div>
</form>
<div style="clear: both; margin-bottom: 20px;">&nbsp;</div>
