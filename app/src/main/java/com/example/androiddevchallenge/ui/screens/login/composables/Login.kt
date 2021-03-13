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
package com.example.androiddevchallenge.ui.screens.login.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screens.login.LoginListener
import com.example.androiddevchallenge.ui.screens.login.LoginViewState
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun Login(
    viewState: LoginViewState,
    listener: LoginListener,
    onLoginClick: () -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color =
                    if (isSystemInDarkTheme()) {
                        MaterialTheme.colors.background
                    } else {
                        MaterialTheme.colors.surface
                    }
                )
        ) {

            Column {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    modifier = Modifier.padding(start = 16.dp, top = 40.dp, end = 16.dp)
                ) {

                    OutlinedTextField(
                        value = viewState.mail,
                        maxLines = 1,
                        label = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = Icons.Outlined.Mail,
                                    contentDescription = null
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = "Email address",
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        },
                        onValueChange = listener::onMailChanged,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = MaterialTheme.colors.onSurface
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    OutlinedTextField(
                        value = viewState.password,
                        maxLines = 1,
                        label = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = Icons.Default.Password,
                                    contentDescription = null
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = "Password",
                                    style = MaterialTheme.typography.body1
                                )
                            }
                        },
                        onValueChange = listener::onPasswordChanged,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = MaterialTheme.colors.onSurface
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(50),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        ),
                        onClick = onLoginClick
                    ) {
                        Text(text = "LOG IN")
                    }
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 152.dp),
                textAlign = TextAlign.Center,
                text = "Welcome${System.lineSeparator()}back",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun LoginPreviewLight() {
    MyTheme {
        ProvideWindowInsets {
            Login(
                viewState = LoginViewState.DEFAULT,
                listener = LoginListener.NONE,
                onLoginClick = {}
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun LoginPreviewDark() {
    MyTheme(darkTheme = true) {
        ProvideWindowInsets {
            Login(
                viewState = LoginViewState.DEFAULT,
                listener = LoginListener.NONE,
                onLoginClick = {}
            )
        }
    }
}
