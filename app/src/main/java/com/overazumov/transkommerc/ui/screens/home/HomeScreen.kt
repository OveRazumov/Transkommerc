package com.overazumov.transkommerc.ui.screens.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.overazumov.transkommerc.R
import com.overazumov.transkommerc.ui.navigation.AppNavHost
import com.overazumov.transkommerc.ui.navigation.AppScreen
import com.overazumov.transkommerc.ui.navigation.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.FindTrip.name
    )
    val mainScreens = bottomNavItems.map { it.appScreen }
    val onMainScreen = currentScreen in mainScreens
    var selectedNavigationItemIndex by rememberSaveable { mutableIntStateOf(1) }

    Scaffold(
        bottomBar = {
            if (onMainScreen) {
                BottomNavBar(
                    navController = navController,
                    selectedNavigationItemIndex = selectedNavigationItemIndex,
                    onNavigationItem = { index, screenName ->
                        selectedNavigationItemIndex = index
                        navController.navigate(screenName)
                    }
                )
            }
        },
        topBar = {
            if (onMainScreen) {
                MainTopBar()
            } else {
                TopBar(
                    title = currentScreen.title,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        modifier = modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes title: Int,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(title)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                androidx.compose.material.Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    )
}

@Composable
private fun BottomNavBar(
    navController: NavHostController,
    selectedNavigationItemIndex: Int,
    onNavigationItem: (Int, String) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface,
        elevation = dimensionResource(R.dimen.medium_elevation),
        modifier = modifier
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            val color = if (selectedNavigationItemIndex == index) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }

            BottomNavigationItem(
                selected = selectedNavigationItemIndex == index,
                onClick = { onNavigationItem(index, item.appScreen.name) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        tint = color,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        color = color,
                        fontSize = 12.sp
                    )
                }
            )
        }
    }
}