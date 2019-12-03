package se.treehou.newsreader.screen.article.adapters.items

import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.textview.MaterialTextView
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class TitleItemModel : EpoxyModelWithHolder<TitleItemModel.Holder>() {

    @EpoxyAttribute
    var text: String = ""

    @EpoxyAttribute
    var typeface: Typeface? = null

    override fun getDefaultLayout(): Int = R.layout.item_title

    override fun bind(holder: Holder) {
        holder.titleText.text = text
        if(typeface != null){
            holder.titleText.typeface = typeface
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var titleText: TextView

        override fun bindView(itemView: View) {
            titleText = itemView.findViewById(R.id.title)
        }
    }
}