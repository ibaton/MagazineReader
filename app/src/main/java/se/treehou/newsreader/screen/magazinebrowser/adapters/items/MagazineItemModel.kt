package se.treehou.newsreader.screen.article.adapters.items

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_magazine.view.*
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class MagazineItemModel : EpoxyModelWithHolder<MagazineItemModel.Holder>() {

    @EpoxyAttribute
    var title: String = ""
    @EpoxyAttribute
    var promoImage: String = ""
    @EpoxyAttribute
    var magazineId: String = ""
    @EpoxyAttribute
    var magazineClickListener: (String)->Unit = {}

    override fun getDefaultLayout(): Int = R.layout.item_magazine

    override fun bind(holder: Holder) {
        holder.magazineImage.load(promoImage)
        holder.magazineTitle.text = title
        holder.itemView.setOnClickListener { magazineClickListener(magazineId) }
    }

    class Holder : EpoxyHolder() {

        lateinit var itemView: View
        lateinit var magazineTitle: TextView
        lateinit var magazineImage: ImageView

        override fun bindView(itemView: View) {
            this.itemView = itemView
            magazineImage = itemView.magazinePromoImage
            magazineTitle = itemView.magazineTitle
        }
    }
}