package se.treehou.newsreader.screen.magazinebrowser

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import se.treehou.newsmanager.NewsManager
import se.treehou.newsmanager.model.Magazine
import se.treehou.newsreader.BaseViewModel

class MagazineBrowserViewModel(newsManager: NewsManager) : BaseViewModel() {

    val magazines: Observable<List<Magazine>> = newsManager.loadMagazines()
        .observeOn(AndroidSchedulers.mainThread())

    val viewActions: PublishSubject<ViewActions> =
        PublishSubject.create<ViewActions>()

    fun magazineClicked(magazineId: String) {
        viewActions.onNext(ViewActions.OpenMagazineAction(magazineId))
    }

}