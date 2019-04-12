package com.swkang.springboot.springbootintegration.controller;

import com.swkang.springboot.springbootintegration.domain.Article;
import com.swkang.springboot.springbootintegration.domain.JsonData;
import com.swkang.springboot.springbootintegration.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("save")
    public Object save(){
        Article article = new Article();
        article.setId(1L);
        article.setPv(128);
        article.setContent("this is 内容");
        article.setTitle("I Love LL");
        article.setSummary("概要搜索");
        articleRepository.save(article);
        return JsonData.buildSuccess();
    }

    @GetMapping("search")
    public Object search(){
        Iterable<Article> all = articleRepository.findAll();
        return JsonData.buildSuccess(all);
    }


}
