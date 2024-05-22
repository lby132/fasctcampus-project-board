package com.fastcampus.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * /articles
 * /articles/{articles-id}
 * /articles/search
 * /articles/search-hashtag
 */
@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String article(ModelMap map) {
        map.addAttribute("articles", List.of());
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String article(@PathVariable Long articleId, ModelMap map) {
        map.addAttribute("article", "article"); //TODO 나중에 구현해야함
        map.addAttribute("articleComments", List.of());

        return "articles/index";
    }
}
