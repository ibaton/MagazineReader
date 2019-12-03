package se.treehou.newsreader.screen.article

import com.uber.autodispose.autoDisposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import se.treehou.newsmanager.NewsManager
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsreader.BaseViewModel

class ArticleReaderViewModel(
    articleId: String,
    newsManager: NewsManager
) : BaseViewModel() {

    val newsArticle: Observable<NewsArticle> = newsManager.loadArticle(articleId)
        .share()
        .observeOn(AndroidSchedulers.mainThread())

    val viewActions = PublishSubject.create<ViewActions>()

    fun clickedShareArticle() {
        newsArticle
            .autoDisposable(this)
            .subscribe {
                viewActions.onNext(ViewActions.ShareArticleAction(it.title, it.source))
            }
    }
}