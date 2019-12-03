package se.treehou.newsreader.screen.reader

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsreader.screen.article.ArticleReaderFragment

class ArticlePager(fragmentManager: FragmentManager, var articles: List<NewsArticle> = emptyList()) :
    FragmentStatePagerAdapter(fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    override fun getCount(): Int = articles.size

    override fun getItem(i: Int): Fragment {
        val fragment =
            ArticleReaderFragment()
        fragment.arguments = Bundle().apply {
            putString(ArticleReaderFragment.ARG_ARTICLE_ID, articles[i].id)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}