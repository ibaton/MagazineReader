package se.treehou.newsmanager

import io.reactivex.Observable
import se.treehou.newsmanager.model.NewsArticle

class StaticNewsManager : NewsManager {

    private val articles = sortedMapOf(
        article1.id to article1,
        article2.id to article2
    )

    override fun loadArticles(): Observable<List<NewsArticle>> {
        return Observable.just(
            articles.values.toList()
        )
    }

    override fun loadArticle(articleId: String): Observable<NewsArticle> {
        return Observable.just(articles[articleId])
    }
}
