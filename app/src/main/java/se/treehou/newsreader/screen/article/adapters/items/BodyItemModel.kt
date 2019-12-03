package se.treehou.newsreader.screen.article.adapters.items

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class BodyItemModel : EpoxyModelWithHolder<BodyItemModel.Holder>() {

    @EpoxyAttribute
    var text: String = ""

    override fun getDefaultLayout(): Int = R.layout.item_body

    override fun bind(holder: Holder) {
        holder.bodyText.text = text
    }

    class Holder : EpoxyHolder() {

        lateinit var bodyText: TextView

        override fun bindView(itemView: View) {
            bodyText = itemView.findViewById(R.id.body)
        }
    }
}