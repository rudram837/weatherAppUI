package com.weather.app.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.weather.app.R
import com.weather.app.ui.theme.ColorGradient1
import com.weather.app.ui.theme.ColorGradient2
import com.weather.app.ui.theme.ColorGradient3
import com.weather.app.ui.theme.ColorTextSecondary
import com.weather.app.ui.theme.ColorTextSecondaryVariant
import com.weather.app.ui.theme.ColorWindForecast

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String = "Mostly Sunny",
    date: String = "Sunday 01 Feb"
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (forecastImage, forecastValue, windImage, title, description, background) = createRefs()

        CardBackground(
            modifier = Modifier.constrainAs(background) {
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    top = parent.top,
                    bottom = description.bottom,
                    topMargin = 24.dp
                )
                height = Dimension.fillToConstraints
            }
        )

        Image(
            painter = painterResource(R.drawable.img_sub_rain),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(175.dp)
                .constrainAs(forecastImage) {
                    start.linkTo(anchor = parent.start, margin = 4.dp)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = forecast,
            style = MaterialTheme.typography.titleLarge,
            color = ColorTextSecondary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(title) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(forecastImage.bottom)
            }
        )
        Text(
            text = date,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant,
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                }
                .padding(bottom = 24.dp)
        )
        ForecastValue(
            modifier = Modifier.constrainAs(forecastValue) {
                end.linkTo(parent.end, 2.dp)
                top.linkTo(forecastImage.top, 12.dp)
                bottom.linkTo(forecastImage.bottom)
            }
        )
        WindForecastImage (
            modifier = Modifier.constrainAs(windImage) {
                linkTo(
                    top = title.top,
                    bottom = title.bottom
                )
                end.linkTo(parent.end, 24.dp)
            }
        )
    }
}

@Composable
fun CardBackground (
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.5f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(32.dp)
            )
    )
}

@Composable
fun ForecastValue (
    modifier: Modifier = Modifier,
    degree: String = "29°",
    description: String = "Feels like 32°"
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = degree,
                style = TextStyle (
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "",
                style = TextStyle (
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}

@Composable
fun WindForecastImage (
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_frosty),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
        Icon(
            painter = painterResource(R.drawable.ic_wind),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
    }
}