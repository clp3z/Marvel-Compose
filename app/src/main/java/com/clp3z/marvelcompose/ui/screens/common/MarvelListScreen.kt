package com.clp3z.marvelcompose.ui.screens.common

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import arrow.core.right
import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characters
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T : MarvelItem> MarvelListScreen(
    isLoading: Boolean,
    items: Result<List<T>>,
    onClick: (T) -> Unit
) {

    items.fold(
        ifLeft = { ErrorMessage(it) },
        ifRight = {
            var bottomSheetItem by remember { mutableStateOf<T?>(null) }
            val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
            val coroutineScope = rememberCoroutineScope()

            val lifecycleOwner = LocalLifecycleOwner.current
            val backDispatcher = requireNotNull(LocalOnBackPressedDispatcherOwner.current)
                .onBackPressedDispatcher

            LaunchedEffect(lifecycleOwner, backDispatcher) {
                backDispatcher.addCallback(lifecycleOwner, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        coroutineScope.launch { bottomSheetState.hide() }
                    }
                })
            }

            ModalBottomSheetLayout(
                sheetState = bottomSheetState,
                sheetContent = {
                    MarvelItemBottomSheet(
                        item = bottomSheetItem,
                        onGoToDetailsClick = {
                            bottomSheetItem = null
                            coroutineScope.launch { bottomSheetState.hide() }
                            onClick(it)
                        }
                    )
                }
            ) {
                MarvelList(
                    isLoading = isLoading,
                    items = it,
                    onItemClick = onClick,
                    onItemMoreClick = {
                        bottomSheetItem = it
                        coroutineScope.launch { bottomSheetState.show() }
                    }
                )
            }
        }
    )
}

@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun MarvelListScreenPreview() {
    MarvelScreen {
        MarvelListScreen(
            isLoading = false,
            items = characters.right(),
            onClick = {}
        )
    }
}
