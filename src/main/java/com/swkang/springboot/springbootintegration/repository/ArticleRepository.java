package com.swkang.springboot.springbootintegration.repository;

import com.swkang.springboot.springbootintegration.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Component;


//@Document(indexName = "blog", type = "article", shards = 1, replicas = 0)
@Component
public interface ArticleRepository extends ElasticsearchCrudRepository<Article, Long>{

}
