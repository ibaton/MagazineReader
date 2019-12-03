package se.treehou.newsreader.screen

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import se.treehou.newsreader.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navigationFragment).navigateUp()
    }

    /**
     * Root destinations for navigation
     */
    private val rootDestinations = setOf(
        R.id.magazineBrowserFragment,
        R.id.settingsFragment
    )

    /**
     * Setup navigation bottom bar navigation
     */
    private fun setupNavigation() {

        val navController = findNavController(R.id.navigationFragment)

        // Update action bar to reflect navigation
        setupActionBarWithNavController(navController, AppBarConfiguration(rootDestinations))

        // Tie nav graph to items in bottom navigation
        NavigationUI.setupWithNavController(navView, navController)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(NavBarHiderChangeListener())
    }

    /**
     * Hides bottom navigation when not on root destination
     */
    inner class NavBarHiderChangeListener : NavController.OnDestinationChangedListener {
        override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
        ) {
            if (rootDestinations.contains(destination.id)) {
                navView.visibility = View.VISIBLE
            } else {
                navView.visibility = View.GONE
            }
        }
    }
}
