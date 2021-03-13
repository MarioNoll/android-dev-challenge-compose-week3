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
package com.example.androiddevchallenge.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeViewState.DEFAULT)

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            val items = listOf(
                StockItem(
                    title = "ALK",
                    subtitle = "Alaska Air Group, Inc.",
                    image = R.drawable.home_alk,
                    price = "$7,918",
                    change = "-0.54%",
                    isPositive = false
                ),
                StockItem(
                    title = "BA",
                    subtitle = "Boeing Co.",
                    image = R.drawable.home_ba,
                    price = "$1,293",
                    change = "+4.18%",
                    isPositive = true
                ),
                StockItem(
                    title = "DAL",
                    subtitle = "Delta Airlines Inc.",
                    image = R.drawable.home_dal,
                    price = "$893.50",
                    change = "-0.54%",
                    isPositive = false
                ),
                StockItem(
                    title = "EXPE",
                    subtitle = "Expedia Group Inc.",
                    image = R.drawable.home_exp,
                    price = "$12,301",
                    change = "+2.51%",
                    isPositive = true
                ),
                StockItem(
                    title = "EADSY",
                    subtitle = "Airbus SE",
                    image = R.drawable.home_eadsy,
                    price = "$12,301",
                    change = "+1.38%",
                    isPositive = true
                ),
                StockItem(
                    title = "JBLU",
                    subtitle = "Jetblue Airways Corp.",
                    image = R.drawable.home_jblu,
                    price = "$8,521",
                    change = "+1.56%",
                    isPositive = true
                ),
                StockItem(
                    title = "MAR",
                    subtitle = "Marriott International Inc.",
                    image = R.drawable.home_mar,
                    price = "$521",
                    change = "+2.75%",
                    isPositive = true
                ),
                StockItem(
                    title = "CCL",
                    subtitle = "Carnival Crop",
                    image = R.drawable.home_ccl,
                    price = "$5,481",
                    change = "+0.14%",
                    isPositive = true
                ),
                StockItem(
                    title = "RCL",
                    subtitle = "Royal Caribbean Cruises",
                    image = R.drawable.home_rcl,
                    price = "$9,184",
                    change = "+1.69%",
                    isPositive = true
                ),
                StockItem(
                    title = "TRVL",
                    subtitle = "Travelocity Inc.",
                    image = R.drawable.home_mar,
                    price = "$654",
                    change = "+3.23%",
                    isPositive = true
                )
            )
            _state.value = HomeViewState(
                items = items
            )
        }
    }
}
