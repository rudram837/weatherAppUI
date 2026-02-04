package com.weather.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.weather.app.ui.screens.components.ActionBar
import com.weather.app.ui.screens.components.AirQuality
import com.weather.app.ui.screens.components.DailyForecast
import com.weather.app.ui.screens.components.WeeklyForecast
import com.weather.app.ui.theme.ColorBackground


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherScreen () {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorBackground
    ) { paddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddings)
                .padding(
                    horizontal = 24.dp,
                    vertical = 10.dp
                )
        ) {
            ActionBar()
            Spacer(
                modifier = Modifier.height(13.dp)
            )
            DailyForecast()
            Spacer(
                modifier = Modifier.height(22.dp)
            )
            AirQuality()
            Spacer(
                modifier = Modifier.height(22.dp)
            )
            WeeklyForecast()
        }
    }
}