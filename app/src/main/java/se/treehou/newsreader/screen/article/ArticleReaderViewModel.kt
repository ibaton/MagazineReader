package se.treehou.newsreader.screen.article

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import se.treehou.newsreader.BaseViewModel
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsmanager.NewsManager

class ArticleReaderViewModel(
    val articleId: String,
    newsManager: NewsManager
): BaseViewModel() {


    val newsArticle: Observable<NewsArticle> = newsManager.loadArticle(articleId)
        .observeOn(AndroidSchedulers.mainThread())
}