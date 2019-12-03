package se.treehou.newsmanager.model

data class Magazine(
    val id: String,
    val title: String,
    val promoImage: String,
    val articleIds: List<String>
)