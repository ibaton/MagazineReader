package se.treehou.newsreader.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsreader.screen.article.ArticleReaderFragment
import se.treehou.newsreader.screen.article.ArticleReaderViewModel
import se.treehou.newsreader.screen.article.adapters.ArticleController

val articleModule: Module = module {
    viewModel {(articleId: String) -> ArticleReaderViewModel(articleId, get()) }
    factory { ArticleController() }
}