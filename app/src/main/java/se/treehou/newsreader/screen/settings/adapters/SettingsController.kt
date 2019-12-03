package se.treehou.newsreader.screen.settings.adapters

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.settings.adapters.items.menuItem

class SettingsController(val context: Context) : EpoxyController() {

    private val licenseClickedSubject: PublishSubject<Any> = PublishSubject.create<Any>()
    val licenseClickedObservable: Observable<Any> = licenseClickedSubject.hide()

    override fun buildModels() {
        menuItem {
            id("license")
            title(context.getString(R.string.third_party_licenses))
            clickListener { licenseClickedSubject.onNext(true) }
        }
    }
}