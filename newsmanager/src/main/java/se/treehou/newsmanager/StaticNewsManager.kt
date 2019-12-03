package se.treehou.newsmanager

import android.content.Context
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list
import se.treehou.newsmanager.model.Magazine
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsmanager.serialization.MagazineSerialize
import se.treehou.newsmanager.serialization.NewsArticleSerialize

class StaticNewsManager(val context: Context) : NewsManager {

    private val json = Json(JsonConfiguration.Stable)

    override fun loadArticles(): Observable<List<NewsArticle>> {
        return loadArticlesFromFile()
            .map { it.values.toList() }
    }

    override fun loadArticle(articleId: String): Observable<NewsArticle> {
        return loadArticlesFromFile().map { articles ->
            articles[articleId]
        }
    }

    override fun loadMagazines(): Observable<List<Magazine>> {
        return loadMagazinesFromFile()
            .map { it.values.toList() }
    }

    override fun loadMagazine(magazineId: String): Observable<Magazine> {
        return loadMagazinesFromFile()
            .map { magazines ->
                magazines[magazineId]
            }
    }

    /**
     * Load an deserialize magazines stored in filesystem.
     * TODO implement some type of cache, bad practice to deserialize all items every time
     */
    /**
     * Load an deserialize magazines stored in filesystem.
     * TODO implement some type of cache, bad practice to deserialize all items every time
     */
    private fun loadMagazinesFromFile(): Observable<Map<String, Magazine>> {
        return Observable.create<Map<String, Magazine>> { emitter ->
            val text = context.resources.openRawResource(R.raw.magazines)
                .bufferedReader().use { it.readText() }

            val magazines = json.parse(MagazineSerialize.serializer().list, text)
                .map { it.toModel() }
            val magazineMap = magazines.map { it.id to it }.toMap()

            if (!emitter.isDisposed) {
                emitter.onNext(magazineMap)
            }
        }.subscribeOn(Schedulers.io())
    }

    /**
     * Load an deserialize magazines stored in filesystem.
     * TODO implement some type of cache, bad practice to deserialize all items every time
     */
    /**
     * Load an deserialize magazines stored in filesystem.
     * TODO implement some type of cache, bad practice to deserialize all items every time
     */
    private fun loadArticlesFromFile(): Observable<Map<String, NewsArticle>> {
        return Observable.create<Map<String, NewsArticle>> { emitter ->
            val text = context.resources.openRawResource(R.raw.articles)
                .bufferedReader().use { it.readText() }

            val articles = json.parse(NewsArticleSerialize.serializer().list, text)
                .map { it.toModel() }
            val articleMap = articles.map { it.id to it }.toMap()

            if (!emitter.isDisposed) {
                emitter.onNext(articleMap)
            }
        }.subscribeOn(Schedulers.io())
    }
}
