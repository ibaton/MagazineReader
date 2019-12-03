package se.treehou.newsmanager

import io.reactivex.Observable
import se.treehou.newsmanager.model.Magazine
import se.treehou.newsmanager.model.NewsArticle

/**
 * Manager used for loading articles and magazines.
 */
interface NewsManager {
    fun loadArticle(articleId: String): Observable<NewsArticle>
    fun loadArticles(): Observable<List<NewsArticle>>
    fun loadMagazine(magazineId: String): Observable<Magazine>
    fun loadMagazines(): Observable<List<Magazine>>
}