/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun Welcome(onLoginClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
        ) {

            Row {
                Button(
                    modifier = Modifier
                        .weight(1F)
                        .height(48.dp),
                    shape = RoundedCornerShape(50),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    ),
                    onClick = { }
                ) {
                    Text(text = "GET STARTED")
                }

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedButton(
                    modifier = Modifier
                        .weight(1F)
                        .height(48.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colors.primary
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = purple
                    ),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(50),
                    onClick = onLoginClick
                ) {
                    Text(text = "LOG IN")
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun WelcomePreview() {
    MyTheme {
        ProvideWindowInsets {
            Welcome(
                onLoginClick = {}
            )
        }
    }
}
