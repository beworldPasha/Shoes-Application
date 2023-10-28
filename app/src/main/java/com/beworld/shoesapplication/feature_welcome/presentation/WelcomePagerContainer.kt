package com.beworld.shoesapplication.feature_welcome.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beworld.shoesapplication.R
import com.beworld.shoesapplication.feature_welcome.presentation.components.PagerContent
import com.beworld.shoesapplication.feature_welcome.presentation.components.PagerIndicatorItem
import com.beworld.shoesapplication.ui.theme.ShoesApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomePagerContainer(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_page_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState(
            initialPage = 0, initialPageOffsetFraction = 0f
        ) { 3 }
        HorizontalPager(state = pagerState) { page ->
            PagerContent(
                page = page,
                buttonClick = {
                    if (page != pagerState.pageCount - 1)
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page + 1)
                        }
                }
            )
        }

        Row(
            Modifier
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .padding(bottom = 168.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                PagerIndicatorItem(
                    currentPage = pagerState.currentPage,
                    iteration = iteration
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(id = R.string.created_by),
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = stringResource(id = R.string.my_info),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview() {
    ShoesApplicationTheme {
        WelcomePagerContainer()
    }
}