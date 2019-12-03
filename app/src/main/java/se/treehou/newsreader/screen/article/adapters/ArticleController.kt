package se.treehou.newsreader.screen.article.adapters

import com.airbnb.epoxy.EpoxyController
import se.treehou.newsmanager.model.Body
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsreader.screen.article.adapters.items.bodyItem
import se.treehou.newsreader.screen.article.adapters.items.imageItem
import se.treehou.newsreader.screen.article.adapters.items.preambleItem
import se.treehou.newsreader.screen.article.adapters.items.titleItem
import se.treehou.newsreader.thememanager.ThemeManager

class ArticleController(private val themeManager: ThemeManager) : EpoxyController() {

    var article: NewsArticle? = null

    override fun buildModels() {
        val article = article ?: return // TODO implement loader

        titleItem {
            id("title")
            text(article.title)
            typeface(themeManager.getTypeface())
        }

        if (article.promoImage.isNotBlank()) {
            imageItem {
                id("promoImage")
                imagePath(article.promoImage)
            }
        }

        preambleItem {
            id("preamble")
            text(article.preamble)
            typeface(themeManager.getTypeface())
        }

        for (body in article.body) {
            when (body) {
                is Body.BodyImage -> createImageItem(body)
                is Body.BodyText -> createBodyItem(body)
            }
        }
    }

    private fun createBodyItem(body: Body.BodyText) {
        return bodyItem {
            id(body.text)
            text(body.text)
            typeface(themeManager.getTypeface())
        }
    }

    private fun createImageItem(body: Body.BodyImage) {
        return imageItem {
            id(body.url)
            imagePath(body.url)
        }
    }
}