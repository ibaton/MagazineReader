package se.treehou.newsreader.screen.settings.adapters.items

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import se.treehou.newsreader.R


@EpoxyModelClass
abstract class SeparatorItemModel : EpoxyModelWithHolder<SeparatorItemModel.Holder>() {

    override fun getDefaultLayout(): Int = R.layout.item_separator

    override fun bind(holder: Holder) {}

    class Holder : EpoxyHolder() {
        override fun bindView(itemView: View) {}
    }
}