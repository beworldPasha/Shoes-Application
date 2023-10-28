package com.beworld.shoesapplication.feature_welcome.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.beworld.shoesapplication.R


private enum class ShoesImages(@DrawableRes val imageId: Int) {
    WelcomeShoes(R.drawable.ic_welcome_shoes),
    JourneyShoes(R.drawable.ic_journey_shoes),
    PowerShoes(R.drawable.ic_power_shoes)
}

private enum class TitlesText(@StringRes val stringId: Int) {
    WelcomeTitle(R.string.welcome_screen_nike_title),
    JourneyTitle(R.string.welcome_screen_journey_title),
    PowerTitle(R.string.welcome_screen_power_title)
}

private enum class BodesText(@StringRes val stringId: Int) {
    WelcomeText(R.string.empty),
    JourneyText(R.string.welcome_screen_journey_text),
    PowerText(R.string.welcome_screen_power_text)
}

private enum class ButtonText(@StringRes val stringId: Int) {
    FirstButtonText(R.string.welcome_screen_button_text_get_started),
    SecondButtonText(R.string.welcome_screen_button_text_next),
    ThirdButtonText(R.string.welcome_screen_button_text_next)
}

@Composable
fun PagerContent(
    page: Int,
    buttonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(ShoesImages.values()[page].imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(312.dp)
        )
        Text(
            text = stringResource(id = TitlesText.values()[page].stringId),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            minLines = 2,
            maxLines = 2,
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.big_padding),
                    bottom = dimensionResource(id = R.dimen.medium_padding)
                )
        )
        Text(
            text = stringResource(id = BodesText.values()[page].stringId),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            minLines = 2,
            maxLines = 2
        )
        Button(
            shape = RoundedCornerShape(corner = CornerSize(12.dp)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.large_padding))
                .height(50.dp)
                .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
            colors = ButtonDefaults.buttonColors(Color(0xFFECECEC)),
            onClick = buttonClick
        ) {
            Text(
                text = stringResource(id = ButtonText.values()[page].stringId),
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF2B2B2B)
            )
        }
    }
}