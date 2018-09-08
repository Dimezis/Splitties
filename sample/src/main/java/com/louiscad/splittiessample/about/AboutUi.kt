/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.louiscad.splittiessample.about

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.louiscad.splittiessample.R
import splitties.dimensions.dip
import splitties.viewdsl.appcompat.toolbar
import splitties.viewdsl.constraintlayout.centerHorizontally
import splitties.viewdsl.constraintlayout.constraintLayout
import splitties.viewdsl.constraintlayout.lParams
import splitties.viewdsl.constraintlayout.topOfParent
import splitties.viewdsl.constraintlayout.topToBottomOf
import splitties.viewdsl.core.Ui
import splitties.viewdsl.core.add
import splitties.viewdsl.core.textView
import splitties.viewdsl.core.wrapContent
import splitties.viewdsl.design.appBarLParams
import splitties.viewdsl.design.appBarLayout
import splitties.viewdsl.design.contentScrollingWithAppBarLParams
import splitties.viewdsl.design.coordinatorLayout
import splitties.viewdsl.design.defaultLParams
import splitties.views.centerText
import splitties.views.textAppearance
import splitties.views.textResource

class AboutUi(override val ctx: Context) : Ui {

    private val mainContent = constraintLayout {
        val headlineTv = add(textView {
            textAppearance = R.style.TextAppearance_AppCompat_Headline
            textResource = R.string.lib_name
            centerText()
        }, lParams(height = wrapContent) {
            centerHorizontally(); topOfParent()
            topMargin = dip(16)
        })
        val authorTv = add(textView {
            textAppearance = R.style.TextAppearance_AppCompat_Small
            textResource = R.string.a_lib_by_louiscad
            centerText()
        }, lParams(height = wrapContent) {
            centerHorizontally(); topToBottomOf(headlineTv)
            topMargin = dip(8)
        })
        add(textView {
            textAppearance = R.style.TextAppearance_AppCompat_Caption
            textResource = R.string.licensed_under_apache_2
            centerText()
        }, lParams(height = wrapContent) {
            centerHorizontally(); topToBottomOf(authorTv)
            topMargin = dip(8)
        })
    }

    override val root = coordinatorLayout {
        fitsSystemWindows = true
        add(appBarLayout(R.id.app_bar, R.style.AppTheme_AppBarOverlay) {
            add(toolbar {
                popupTheme = R.style.AppTheme_PopupOverlay
                (ctx as? AppCompatActivity)?.setSupportActionBar(this)
            }, defaultLParams())
        }, appBarLParams())
        add(mainContent, contentScrollingWithAppBarLParams())
    }
}
