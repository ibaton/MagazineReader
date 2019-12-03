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

    private val viewActionsSubject: PublishSubject<ViewActions> =
        PublishSubject.create<ViewActions>()
    val viewActions: Observable<ViewActions> = viewActionsSubject.hide()

    fun magazineClicked(magazineId: String) {
        viewActionsSubject.onNext(ViewActions.OpenMagazineAction(magazineId))
    }

}