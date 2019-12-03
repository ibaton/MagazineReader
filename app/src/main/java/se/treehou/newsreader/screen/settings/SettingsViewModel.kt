package se.treehou.newsreader.screen.settings

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import se.treehou.newsreader.BaseViewModel
import se.treehou.newsreader.thememanager.Font
import se.treehou.newsreader.thememanager.ThemeManager

class SettingsViewModel(private val themeManager: ThemeManager) : BaseViewModel() {

    private val viewActionsSubject: PublishSubject<ViewActions> =
        PublishSubject.create<ViewActions>()

    val viewActions: Observable<ViewActions> = viewActionsSubject.hide()
        .observeOn(AndroidSchedulers.mainThread())

    private val fontSubject: BehaviorSubject<Font> = BehaviorSubject.createDefault(themeManager.getFont())
    val font: Observable<Font> = fontSubject.hide()
        .observeOn(AndroidSchedulers.mainThread())

    fun fontClicked(font: Font){
        themeManager.setFont(font)
        fontSubject.onNext(font)
    }

    fun licenseClicked() {
        viewActionsSubject.onNext(ViewActions.OpenLicensePageAction)
    }
}