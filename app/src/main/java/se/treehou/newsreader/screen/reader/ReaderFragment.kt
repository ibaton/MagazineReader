package se.treehou.newsreader.screen.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.uber.autodispose.autoDisposable
import kotlinx.android.synthetic.main.fragment_reader.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import se.treehou.newsmanager.model.NewsArticle
import se.treehou.newsreader.R
import se.treehou.newsreader.screen.BaseFragment
import se.treehou.newsreader.screen.article.ArticleReaderFragment

class ReaderFragment : BaseFragment() {

    private val viewModel: ReaderViewModel by viewModel()
    private lateinit var articleAdapter: ArticlePager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reader, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = fragmentManager ?: return

        articleAdapter = ArticlePager(fragmentManager)
        articlePager.adapter = articleAdapter
    }

    override fun onResume() {
        super.onResume()

        viewModel.newsArticles
            .autoDisposable(scopeProvider)
            .subscribe {
                articleAdapter.articles = it
                articleAdapter.notifyDataSetChanged()
            }
    }
}

class ArticlePager(fragmentManager: FragmentManager, var articles: List<NewsArticle> = emptyList()) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = articles.size

    override fun getItem(i: Int): Fragment {
        val fragment = ArticleReaderFragment()
        fragment.arguments = Bundle().apply {
            putString(ArticleReaderFragment.ARG_ARTICLE_ID, articles[i].id)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }
}