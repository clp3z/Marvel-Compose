package com.clp3z.marvelcompose.ui.screens.common

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import arrow.core.right
import com.clp3z.marvelcompose.repository.models.MarvelItem
import com.clp3z.marvelcompose.repository.models.Result
import com.clp3z.marvelcompose.ui.MarvelScreen
import com.clp3z.marvelcompose.ui.models.characters

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

            ModalBottomSheetLayout(
                sheetState = bottomSheetState,
                sheetContent = {
                    MarvelItemBottomSheet(
                        item = bottomSheetItem,
                        onGoToDetailsClick = onClick
                    )
                }
            ) {
                MarvelList(
                    isLoading = isLoading,
                    items = it,
                    onItemClick = onClick,
                    onItemMoreClick = {
                        bottomSheetItem = it
                        // TODO bottomSheetState.show()
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
