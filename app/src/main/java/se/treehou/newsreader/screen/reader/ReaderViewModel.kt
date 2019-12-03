package se.treehou.newsreader.screen.reader

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsmanager.NewsManager
import se.treehou.newsreader.BaseViewModel

class ReaderViewModel(newsManager: NewsManager): BaseViewModel() {

    val newsArticles: Observable<List<NewsArticle>> = newsManager.loadArticles()
        .observeOn(AndroidSchedulers.mainThread())
}