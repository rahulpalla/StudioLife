/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.studiolife.data

import android.widget.Button
import com.example.studiolife.model.Question

/**
 * An object to generate a static list of dogs
 */
object DataSource {

    val questions: List<Question> = listOf(
        Question(
//            R.drawable.zoya,
            "What career do you want?",
            null,
            null,
            null
        ),

        Question(
//            R.drawable.cupcake,
            "Who do you want to marry?",
            null,
            null,
            null
        ),

        Question(
//            R.drawable.momo,
            "Where do you want to live?",
            null,
            null,
            null
        ),
        Question(
//            R.drawable.tiramisu,
            "What kind of house do you want?",
            null,
            null,
            null
        ),

        Question(
//            R.drawable.tiramisu,
            "What mode of transportation do you want?",
            null,
            null,
            null
        ),
        Question(
//            R.drawable.jasper,
            "How many kids do you want?",
            null,
            null,
            null
        ),
        Question(
//            R.drawable.tabitha,
            "What pet do you want",
            null,
            null,
            null
        ),
    )
}
