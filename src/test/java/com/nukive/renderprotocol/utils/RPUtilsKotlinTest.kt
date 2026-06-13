package com.nukive.renderprotocol.utils

import com.nukive.renderprotocol.ui.v1.rPAction
import com.nukive.renderprotocol.utils.Actions.navigate
import org.junit.Test

class RPUtilsKotlinTest {

    @Test
    fun testActionNavigation() {
        rPAction {}.navigate("toId", emptyMap())
    }
}
