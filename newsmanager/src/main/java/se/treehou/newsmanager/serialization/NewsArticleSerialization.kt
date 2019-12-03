package se.treehou.newsmanager.serialization

import kotlinx.serialization.Serializable
import se.treehou.newsmanager.model.Body
import se.treehou.newsmanager.model.NewsArticle

@Serializable
data class NewsArticleSerialize(
    val id: String,
    val source: String,
    val title: String,
    val promoImage: String,
    val preamble: String,
    val body: List<BodySerialize>
) {
    fun toModel(): NewsArticle {
        return NewsArticle(
            id = id,
            source = source,
            title = title,
            promoImage = promoImage,
            preamble = preamble,
            body = body.map { it.toModel() }
        )
    }
}

@Serializable
data class BodySerialize(
    val bodyType: String,
    val data: String
) {
    fun toModel(): Body {
        return when (bodyType) {
            "image" -> Body.BodyImage(data)
            "text" -> Body.BodyText(data)
            else -> Body.BodyText("") // Safeguard against new types
        }
    }
}