package se.treehou.newsreader.screen.settings.adapters

import android.content.Context
import com.airbnb.epoxy.EpoxyController
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.settings.adapters.items.fontSettingItem
import se.treehou.newsreader.screen.settings.adapters.items.menuItem
import se.treehou.newsreader.screen.settings.adapters.items.menuTitleItem
import se.treehou.newsreader.screen.settings.adapters.items.separatorItem
import se.treehou.newsreader.thememanager.Font
import se.treehou.newsreader.thememanager.ThemeManager

class SettingsController(val context: Context) : EpoxyController() {

    private val licenseClickedSubject: PublishSubject<Any> = PublishSubject.create<Any>()
    val licenseClickedStream: Observable<Any> = licenseClickedSubject.hide()

    private val fontClickedSubject: PublishSubject<Font> = PublishSubject.create<Font>()
    val fontClickedStream: Observable<Font> = fontClickedSubject.hide()

    var font: Font = Font.ROBOTO

    override fun buildModels() {
        menuTitleItem {
            id("fontTitle")
            title(context.getString(R.string.text_font))
        }
        fontSettingItem {
            id("typeface")
            fontSelectListener { fontClickedSubject.onNext(it) }
            font(font)
        }
        separatorItem {
            id("separator1")
        }
        menuItem {
            id("license")
            title(context.getString(R.string.third_party_licenses))
            clickListener { licenseClickedSubject.onNext(true) }
        }
    }
}