package se.treehou.newsreader.screen.settings.adapters.items

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class MenuTitleItemModel : EpoxyModelWithHolder<MenuTitleItemModel.Holder>() {

    @EpoxyAttribute
    var title: String = ""

    override fun getDefaultLayout(): Int = R.layout.item_menu_title_item

    override fun bind(holder: Holder) {
        holder.titleText.text = title
    }

    class Holder : EpoxyHolder() {

        lateinit var titleText: TextView

        override fun bindView(itemView: View) {
            titleText = itemView.findViewById(R.id.title)
        }
    }
}