package se.treehou.newsreader.screen.article

sealed class ViewActions{

    /**
     * A action for sharing article article to external party.
     */
    data class ShareArticleAction(val title: String, val url: String): ViewActions()
}