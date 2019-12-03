package se.treehou.newsreader.screen.article.adapters.items

import android.view.View
import android.widget.ImageView
import coil.api.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_image.view.*
import se.treehou.newsreader.R

@EpoxyModelClass
abstract class ImageItemModel: EpoxyModelWithHolder<ImageItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var imagePath: String

    override fun getDefaultLayout(): Int = R.layout.item_image

    override fun bind(holder: Holder) {
        val imageHolder = holder.imageHolder

        imageHolder.load(imagePath)
    }

    class Holder : EpoxyHolder() {
        lateinit var imageHolder: ImageView

        override fun bindView(itemView: View) {
            imageHolder = itemView.imageView
        }
    }
}