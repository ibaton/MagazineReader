package se.treehou.newsmanager

import io.reactivex.Observable
import se.treehou.newsmanager.model.NewsArticle

interface NewsManager {
    fun loadArticle(articleId: String): Observable<NewsArticle>
    fun loadArticles(): Observable<List<NewsArticle>>
}