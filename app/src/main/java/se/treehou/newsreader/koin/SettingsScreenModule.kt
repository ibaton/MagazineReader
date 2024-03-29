package se.treehou.newsreader.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import se.treehou.newsreader.screen.settings.SettingsViewModel
import se.treehou.newsreader.screen.settings.adapters.SettingsController

val settingsScreenModule: Module = module {
    viewModel { SettingsViewModel(get()) }
    factory { SettingsController(get()) }
}