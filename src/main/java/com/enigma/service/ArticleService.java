package com.enigma.service;

import com.enigma.entity.Article;

import java.util.List;

public interface ArticleService {

    Article saveArticle(Article article);

    Article updateArticleById(Article article);

    Article getArticleById(String idArticle);

    List<Article> getAllArticle();

    void deleteArticleById(String idArticle);

}
