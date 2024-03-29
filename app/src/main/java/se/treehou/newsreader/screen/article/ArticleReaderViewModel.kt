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
        .observeOn(AndroidSchedulers.mainThread())

    private val viewActionsSubject = PublishSubject.create<ViewActions>()
    val viewActions: Observable<ViewActions> = viewActionsSubject.hide()
        .observeOn(AndroidSchedulers.mainThread())

    fun clickedShareArticle() {
        newsArticle
            .autoDisposable(this)
            .subscribe {
                viewActionsSubject.onNext(ViewActions.ShareArticleAction(it.title, it.source))
            }
    }
}