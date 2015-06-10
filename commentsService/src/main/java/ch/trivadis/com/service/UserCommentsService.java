package ch.trivadis.com.service;


import ch.trivadis.com.entities.Comment;
import ch.trivadis.com.repository.UserCommentRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andy Moncsek on 13.05.15.
 */
@RestController
public class UserCommentsService {
    private  @Inject
    UserCommentRepository repository;



    @RequestMapping("/articleService/fetchAllREST")
    public List<Comment> fetchAllUserCommentsREST() {
        return new ArrayList<>(repository.getAllComments());
    }




    @RequestMapping("/fetchByArticleIdREST/{articleId}")
    public List<Comment> fetchByArticleIdREST(@PathVariable(value="articleId") String articleId) {
        return new ArrayList<>(repository.findCommentsByArticleId(articleId));
    }


}
