package ch.trivadis.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.trivadis.com.entities.Article;
import ch.trivadis.com.repository.ArticleRepository;

/**
 * Created by Andy Moncsek on 10.06.15.
 */
@RestController
public class ArticleService {
	@Inject
	private ArticleRepository repository;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/articleService/findAll")
	public List<Article> findAll() {
		return new ArrayList<>(repository.getAllArticles());
	}

	@RequestMapping("/articleService/findMAX/{amount}")
	public List<Article> findMax(@PathVariable(value = "amount") String amount) {
		return new ArrayList<>(repository.getAllArticles(Integer
				.valueOf(amount)));
	}

	@RequestMapping("/articleService/findPage/{page}")
    public List<Article>  findPage(@PathVariable(value="page") String page) {
		ArrayList<Article> articles = new ArrayList<>(repository.getAllArticlesPages(Integer.valueOf(page)));
		Optional<ServiceInstance> firstService = discoveryClient.getInstances("comment-service").stream().findFirst();
		if(firstService.isPresent()) {
        	return articles.stream().map(a -> new Article(a, firstService.get().getUri().toString())).collect(Collectors.toList());
        }
        return articles;
    }
}
