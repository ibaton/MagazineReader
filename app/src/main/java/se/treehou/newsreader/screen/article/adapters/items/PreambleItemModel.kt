package se.treehou.newsreader.screen.article.adapters.items

import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class PreambleItemModel : EpoxyModelWithHolder<PreambleItemModel.Holder>() {

    @EpoxyAttribute
    var text: String = ""

    @EpoxyAttribute
    var typeface: Typeface? = null

    override fun getDefaultLayout(): Int = R.layout.item_preamble

    override fun bind(holder: Holder) {
        holder.preambleText.text = text
        if(typeface != null){
            holder.preambleText.typeface = typeface
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var preambleText: TextView

        override fun bindView(itemView: View) {
            preambleText = itemView.findViewById(R.id.preamble)
        }
    }
}