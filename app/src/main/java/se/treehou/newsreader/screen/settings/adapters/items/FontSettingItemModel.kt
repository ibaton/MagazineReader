package se.treehou.newsreader.screen.settings.adapters.items

import android.view.View
import android.widget.RadioGroup
import androidx.annotation.IdRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_font_settings_item.view.*
import se.treehou.newsreader.R
import se.treehou.newsreader.thememanager.Font

@EpoxyModelClass
abstract class FontSettingItemModel : EpoxyModelWithHolder<FontSettingItemModel.Holder>() {

    @EpoxyAttribute
    var fontSelectListener: (Font) -> Unit = {}

    @EpoxyAttribute
    lateinit var font: Font

    override fun getDefaultLayout(): Int = R.layout.item_font_settings_item

    override fun bind(holder: Holder) {
        holder.fontSelector.setOnCheckedChangeListener(null)
        holder.fontSelector.check(fontToViewId(font))
        holder.fontSelector.setOnCheckedChangeListener(FontChangeListener())
    }

    @IdRes
    fun fontToViewId(font: Font): Int {
        return when (font) {
            Font.ROBOTO -> R.id.fontSelectorRoboto
            Font.MONTSERRAT -> R.id.fontSelectorMontserrat
            Font.PLAYFAIR -> R.id.fontSelectorPlayfair
            Font.OPENSANS -> R.id.fontSelectorOpenSans
        }
    }

    inner class FontChangeListener : RadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when (checkedId) {
                R.id.fontSelectorRoboto -> fontSelectListener(Font.ROBOTO)
                R.id.fontSelectorMontserrat -> fontSelectListener(Font.MONTSERRAT)
                R.id.fontSelectorPlayfair -> fontSelectListener(Font.PLAYFAIR)
                R.id.fontSelectorOpenSans -> fontSelectListener(Font.OPENSANS)
                else -> fontSelectListener(Font.ROBOTO)
            }
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var fontSelector: RadioGroup

        override fun bindView(itemView: View) {
            fontSelector = itemView.fontSelector
        }
    }
}