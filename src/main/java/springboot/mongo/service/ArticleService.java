package springboot.mongo.service;


import com.github.pagehelper.PageInfo;
import springboot.common.query.ArticleQuery;
import springboot.mongo.bean.Article;

/**
 * Created by zhangshengchen on 2017/8/23.
 */
public interface ArticleService {
    public Long insert(ArticleQuery title);
    public Article get(Long id);
    public PageInfo getPage(ArticleQuery article, int start, int size);
    public void update(Article title);
}
