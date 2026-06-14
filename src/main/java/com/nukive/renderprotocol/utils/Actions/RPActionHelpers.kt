package com.nukive.renderprotocol.utils.Actions

import com.nukive.renderprotocol.ui.v1.RPAction
import com.nukive.renderprotocol.ui.v1.RPDismissAction
import com.nukive.renderprotocol.ui.v1.rPAction
import com.nukive.renderprotocol.ui.v1.rPApiCallAction
import com.nukive.renderprotocol.ui.v1.rPCustomAction
import com.nukive.renderprotocol.ui.v1.rPDismissAction
import com.nukive.renderprotocol.ui.v1.rPNavigationAction
import com.nukive.renderprotocol.ui.v1.rPOpenUrlAction


//Creates a Navigation Action to a specified View
fun RPAction.navigate(toId: String, params: Map<String, String> = emptyMap()): RPAction {

    val nav = rPNavigationAction {
        destinationViewId = toId
        parameters.putAll(params)
    }

    return rPAction {
        navigation = nav
    }

}

// Create an API Call Action
fun RPAction.apiCall(
    endPoint: String,
    method: String = "GET",
    headers: Map<String, String> = emptyMap(),
    body: String? = null
): RPAction {

    val api = rPApiCallAction {
        endpoint = endPoint
        this.method = method
        this.headers.putAll(headers)
        body?.let { this.body = it }
    }

    return rPAction {
        apiCall = api
    }

}

//Creates an Action to Open URL
fun RPAction.openURL(url:String, external: Boolean = false) : RPAction{

    val openUrl = rPOpenUrlAction{
        this.url = url
        this.external = external
    }

    return rPAction {
        this.openUrl = openUrl
    }

}

// Creates a dismiss action
fun RPAction.dismiss(): RPAction{
    return rPAction { dismiss = rPDismissAction{} }
}

fun RPAction.custom(actionType: String, payload: Map<String, String> = emptyMap()) : RPAction{
    val custom = rPCustomAction{
        this.actionType = actionType
        this.payload.putAll(payload)
    }

    return rPAction { this.custom = custom }
}