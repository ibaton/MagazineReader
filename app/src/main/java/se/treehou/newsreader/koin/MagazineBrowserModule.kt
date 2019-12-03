package se.treehou.newsreader.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsreader.screen.magazinebrowser.MagazineBrowserViewModel
import se.treehou.newsreader.screen.magazinebrowser.adapters.MagazineBrowserController

val magazineBrowserModule: Module = module {
    viewModel { MagazineBrowserViewModel(get()) }
    factory { MagazineBrowserController() }
}