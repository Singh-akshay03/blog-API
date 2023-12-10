package com.blog.article;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping(path = "/articles")
public class ArticlesController {
}
