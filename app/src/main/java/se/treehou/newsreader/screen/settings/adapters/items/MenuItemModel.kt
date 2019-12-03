package se.treehou.newsreader.screen.settings.adapters.items

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class MenuItemModel : EpoxyModelWithHolder<MenuItemModel.Holder>() {

    @EpoxyAttribute
    var clickListener: () -> Unit = {}
    @EpoxyAttribute
    var title: String = ""

    override fun getDefaultLayout(): Int = R.layout.item_menu_item

    override fun bind(holder: Holder) {
        holder.titleText.text = title
        holder.itemView.setOnClickListener {
            clickListener()
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var titleText: TextView
        lateinit var itemView: View

        override fun bindView(itemView: View) {
            this.itemView = itemView
            titleText = itemView.findViewById(R.id.title)
        }
    }
}