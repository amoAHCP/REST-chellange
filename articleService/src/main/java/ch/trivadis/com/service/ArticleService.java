package ch.trivadis.com.service;

import ch.trivadis.com.entities.Article;
import ch.trivadis.com.repository.ArticleRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy Moncsek on 10.06.15.
 */
@RestController
public class ArticleService {
    @Inject
    private ArticleRepository repository;

    @RequestMapping("/articleService/findAll")
    public List<Article> findAll() {
        return new ArrayList<>(repository.getAllArticles());
    }
    @RequestMapping("/articleService/findMAX/{amount}")
    public List<Article>  findMax(@PathVariable(value="amount") String amount) {
        return new ArrayList<>(repository.getAllArticles(Integer.valueOf(amount)));
    }

    @RequestMapping("/articleService/findPage/{page}")
    public List<Article>  findPage(@PathVariable(value="page") String page) {
        return new ArrayList<>(repository.getAllArticlesPages(Integer.valueOf(page)));
    }
}
