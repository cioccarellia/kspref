/**
 * Designed and developed by Andrea Cioccarelli (@cioccarellia)
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
package com.cioccarellia.ksprefsample.activities.observer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cioccarellia.ksprefsample.App.Companion.prefs
import com.cioccarellia.ksprefsample.R
import kotlin.random.Random

class ObserverActivity : AppCompatActivity() {

    private val log by lazy { findViewById<TextView>(R.id.log) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observer)

        repeat(5) {
            val v = Random.nextInt().toString()
            prefs.push(v, v)
            val u = prefs.pull<String>(key = v)

            log.text = "${log.text}V: $v\nU: $u\n"
        }
    }
}
