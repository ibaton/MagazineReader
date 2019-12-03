package se.treehou.newsmanager.model

data class NewsArticle(
    val id: String,
    val source: String,
    val title: String,
    val promoImage: String,
    val preamble: String,
    val body: List<Body>
)

sealed class Body {
    data class BodyText(val text: String) : Body()
    data class BodyImage(val url: String) : Body()
}