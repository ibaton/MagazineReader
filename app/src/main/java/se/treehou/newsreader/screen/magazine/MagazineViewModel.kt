package se.treehou.newsreader.screen.magazine

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import se.treehou.newsmanager.NewsManager
import se.treehou.newsreader.BaseViewModel

class MagazineViewModel(magazineId: String, newsManager: NewsManager) : BaseViewModel() {

    val newsArticles: Observable<DisplayMagazine> = newsManager.loadMagazine(magazineId)
        .map { DisplayMagazine(it.title, it.articleIds) }
        .observeOn(AndroidSchedulers.mainThread())

    data class DisplayMagazine(
        val title: String,
        val articleIds: List<String>
    )
}