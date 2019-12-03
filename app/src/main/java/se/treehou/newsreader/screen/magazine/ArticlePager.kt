package se.treehou.newsreader.screen.magazine

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import se.treehou.newsreader.screen.article.ArticleReaderFragment

class ArticlePager(fragmentManager: FragmentManager, var articleIds: List<String> = emptyList()) :
    FragmentStatePagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {

    override fun getCount(): Int = articleIds.size

    override fun getItem(i: Int): Fragment {
        val fragment =
            ArticleReaderFragment()
        fragment.arguments = Bundle().apply {
            putString(ArticleReaderFragment.ARG_ARTICLE_ID, articleIds[i])
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}