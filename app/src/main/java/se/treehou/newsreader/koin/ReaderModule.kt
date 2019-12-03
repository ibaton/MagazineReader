package se.treehou.newsreader.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsreader.screen.reader.ReaderViewModel

val readerModule: Module = module{
    viewModel { ReaderViewModel(get()) }
}