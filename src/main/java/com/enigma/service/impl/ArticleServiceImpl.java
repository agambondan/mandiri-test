package com.enigma.service.impl;

import com.enigma.constant.GeneratorConstant;
import com.enigma.entity.Article;
import com.enigma.entity.Category;
import com.enigma.entity.User;
import com.enigma.exception.DataNotFound;
import com.enigma.repository.ArticleRepository;
import com.enigma.service.ArticleService;
import com.enigma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    UserService userService;

    @Override
    public Article saveArticle(Article article) {
        User getUser = userService.getUserById(article.getIdUserTransient());
        article.setIdUser(getUser);
        List<Category> categoryList = new ArrayList<>(article.getCategoryList());
        article.setCategoryList(categoryList);
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticleById(Article article) {
        Article getArticle = getArticleById(article.idArticle);
        return saveArticle(article);
    }

    @Override
    public Article getArticleById(String idArticle) {
        if (!articleRepository.findById(idArticle).isPresent()){
            throw new DataNotFound(GeneratorConstant.ID_NOT_FOUND);
        }
        return articleRepository.findById(idArticle).get();
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticleById(String idArticle) {
        articleRepository.deleteById(idArticle);
    }
}
