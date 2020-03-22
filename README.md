##实体类
博客Blog
博客分类Type (1:n) 一个分类中有多个博客，但一个博客有且只在一个分类中
博客标签Tag (m:n) 一篇博客有多个标签，一个标签有多个博客
用户User (1:n) blog -> 一个用户可以发表多个博客
博客评论Comment (n:1) blog -> 一篇博客有多个评论
Comment (1:n) ChildComment88
