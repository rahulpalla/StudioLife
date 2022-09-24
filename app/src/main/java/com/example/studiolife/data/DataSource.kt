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
import com.example.studiolife.R

import com.example.studiolife.model.Question

/**
 * An object to generate a list of questions
 */
object DataSource {

    var questions: MutableList<Question> = mutableListOf(
        Question(
            R.drawable.career_image,
            "What career do you want?",
            null,
            null,
            null
        ),

        Question(
            R.drawable.spouse_image,
            "Who do you want to marry?",
            null,
            null,
            null
        ),

        Question(
            R.drawable.location_image,
            "Where do you want to live?",
            null,
            null,
            null
        ),
        Question(
            R.drawable.house_image,
            "What kind of house do you want?",
            null,
            null,
            null
        ),
        Question(
            R.drawable.kid_clipart,
            "How many kids do you want?",
            null,
            null,
            null
        ),
    )
}
