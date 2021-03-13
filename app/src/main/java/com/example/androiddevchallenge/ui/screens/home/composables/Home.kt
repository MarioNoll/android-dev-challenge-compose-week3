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
package com.example.androiddevchallenge.ui.screens.home.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.home.HomeViewState
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun Home(viewState: HomeViewState) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {

                Row {
                    TextButton(
                        modifier = Modifier
                            .weight(1F)
                            .paddingFromBaseline(top = 64.dp, bottom = 8.dp),
                        onClick = { },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onBackground,
                            disabledContentColor = MaterialTheme.colors.onBackground
                                .copy(alpha = ContentAlpha.disabled)
                        )
                    ) {
                        Text(text = "ACCOUNT")
                    }

                    TextButton(
                        modifier = Modifier
                            .weight(1F)
                            .paddingFromBaseline(top = 64.dp, bottom = 8.dp),
                        onClick = { },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onBackground,
                            disabledContentColor = MaterialTheme.colors.onBackground
                                .copy(alpha = ContentAlpha.disabled)
                        ),
                        enabled = false
                    ) {
                        Text(text = "WATCHLIST")
                    }

                    TextButton(
                        modifier = Modifier
                            .weight(1F)
                            .paddingFromBaseline(top = 64.dp, bottom = 8.dp),
                        onClick = { },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colors.onBackground,
                            disabledContentColor = MaterialTheme.colors.onBackground
                                .copy(alpha = ContentAlpha.disabled)
                        ),
                        enabled = false
                    ) {
                        Text(text = "PROFILE")
                    }
                }

                Text(
                    modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 8.dp),
                    text = "Balance",
                    style = MaterialTheme.typography.subtitle1
                )

                Text(
                    modifier = Modifier.paddingFromBaseline(top = 48.dp, bottom = 24.dp),
                    text = "$73,589.01",
                    style = MaterialTheme.typography.h1
                )

                Text(
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 32.dp),
                    text = "+412.35 today",
                    style = MaterialTheme.typography.subtitle1,
                    color = green
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(50),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    ),
                    onClick = { }
                ) {
                    Text(text = "TRANSACT")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.width(12.dp))

                Filter.values().forEach { filter ->
                    Spacer(modifier = Modifier.width(4.dp))

                    OutlinedButton(
                        modifier = Modifier.height(40.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colors.onBackground
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = MaterialTheme.colors.background,
                            contentColor = MaterialTheme.colors.onBackground
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        ),
                        shape = RoundedCornerShape(50),
                        onClick = {}
                    ) {
                        Text(
                            text = filter.text,
                            style = MaterialTheme.typography.body1
                        )

                        if (filter == Filter.Week) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Default.ExpandMore,
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(4.dp))
                }

                Spacer(modifier = Modifier.width(12.dp))
            }

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 32.dp),
                painter = painterResource(id = R.drawable.home_illos),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    CompositionLocalProvider(
                        LocalContentColor provides MaterialTheme.colors.onSurface
                    ) {
                        Text(
                            modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 24.dp),
                            text = "Positions",
                            style = MaterialTheme.typography.subtitle1
                        )

                        if (viewState.items.isNotEmpty()) {

                            Divider(
                                modifier = Modifier.fillMaxWidth()
                            )

                            viewState.items.forEachIndexed { index, stockItem ->
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(56.dp)
                                ) {

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1F)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .weight(1F)
                                        ) {
                                            Column(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                            ) {

                                                Text(
                                                    modifier = Modifier.paddingFromBaseline(top = 24.dp),
                                                    text = stockItem.price,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1
                                                )
                                                val changeColor = if (stockItem.isPositive) {
                                                    green
                                                } else {
                                                    red
                                                }
                                                Text(
                                                    modifier = Modifier.paddingFromBaseline(
                                                        top = 16.dp,
                                                        bottom = 16.dp
                                                    ),
                                                    text = stockItem.change,
                                                    color = changeColor,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1
                                                )
                                            }

                                            Column(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                                    .padding(start = 64.dp, end = 16.dp),
                                            ) {

                                                Text(
                                                    modifier = Modifier.paddingFromBaseline(top = 24.dp),
                                                    text = stockItem.title,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.h3
                                                )
                                                Text(
                                                    modifier = Modifier.paddingFromBaseline(
                                                        top = 16.dp,
                                                        bottom = 16.dp
                                                    ),
                                                    text = stockItem.subtitle,
                                                    maxLines = 1,
                                                    style = MaterialTheme.typography.body1
                                                )
                                            }
                                        }

                                        Image(
                                            painter = painterResource(id = stockItem.image),
                                            contentDescription = null,
                                            contentScale = ContentScale.Fit
                                        )
                                    }

                                    if (index < viewState.items.indices.last) {
                                        Divider(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        )
                                    }
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun HomePreviewLight() {
    MyTheme {
        ProvideWindowInsets {
            Home(
                viewState = HomeViewState.DEFAULT
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun HomePreviewDark() {
    MyTheme(darkTheme = true) {
        ProvideWindowInsets {
            Home(
                viewState = HomeViewState.DEFAULT
            )
        }
    }
}
