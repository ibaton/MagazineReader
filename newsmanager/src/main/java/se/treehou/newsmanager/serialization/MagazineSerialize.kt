package se.treehou.newsmanager.serialization

import kotlinx.serialization.Serializable
import se.treehou.newsmanager.model.Magazine

@Serializable
data class MagazineSerialize(
    val id: String,
    val title: String,
    val promoImage: String,
    val articleIds: List<String>
) {
    fun toModel(): Magazine {
        return Magazine(
            id = id,
            title = title,
            promoImage = promoImage,
            articleIds = articleIds
        )
    }
}

