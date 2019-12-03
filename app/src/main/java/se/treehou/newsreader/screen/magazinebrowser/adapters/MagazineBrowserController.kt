package se.treehou.newsreader.screen.magazinebrowser.adapters

import com.airbnb.epoxy.EpoxyController
import se.treehou.newsmanager.model.Magazine
import se.treehou.newsreader.screen.article.adapters.items.magazineItem

class MagazineBrowserController : EpoxyController() {

    var magazines: List<Magazine> = emptyList()
    var magazineClickListener: (String)->Unit = {}

    override fun buildModels() {
        for (magazine in magazines) {
            magazineItem {
                id(magazine.id)
                title(magazine.title)
                promoImage(magazine.promoImage)
                magazineId(magazine.id)
                magazineClickListener(magazineClickListener)
            }
        }
    }
}