package se.treehou.newsreader.screen.settings

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import se.treehou.newsreader.BaseViewModel

class SettingsViewModel : BaseViewModel() {

    private val viewActionsSubject: PublishSubject<ViewActions> =
        PublishSubject.create<ViewActions>()
    val viewActions: Observable<ViewActions> = viewActionsSubject.hide()
        .observeOn(AndroidSchedulers.mainThread())

    fun licenseClicked() {
        viewActionsSubject.onNext(ViewActions.OpenLicensePageAction)
    }
}