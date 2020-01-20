package com.enigma.controller;

import com.enigma.entity.Article;
import com.enigma.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @CrossOrigin
    @GetMapping("/articles")
    public List<Article> getAllArticle() {
        return articleService.getAllArticle();
    }

    @CrossOrigin
    @GetMapping("/article/{idArticle}")
    public Article getArticleById(@PathVariable String idArticle) {
        return articleService.getArticleById(idArticle);
    }

    @CrossOrigin
    @PostMapping("/article")
    public Article saveArticle(@RequestBody Article Article) {
        return articleService.saveArticle(Article);
    }

    @CrossOrigin
    @PutMapping("/article")
    public Article updateArticle(@RequestBody Article article) {
        return articleService.updateArticleById(article);
    }

    @CrossOrigin
    @DeleteMapping("/Article/{idArticle}")
    public void deleteArticle(@PathVariable String idArticle) {
        articleService.deleteArticleById(idArticle);
    }

}
