package se.treehou.newsmanager

import io.reactivex.Observable
import se.treehou.newsmanager.model.Magazine
import se.treehou.newsmanager.model.NewsArticle

class StaticNewsManager : NewsManager {

    private val magazines = sortedMapOf(
        magazine1.id to magazine1
    )

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

    override fun loadMagazines(): Observable<List<Magazine>> {
        return Observable.just(
            magazines.values.toList()
        )
    }

    override fun loadMagazine(magazineId: String): Observable<Magazine> {
        return Observable.just(magazines[magazineId])
    }
}
