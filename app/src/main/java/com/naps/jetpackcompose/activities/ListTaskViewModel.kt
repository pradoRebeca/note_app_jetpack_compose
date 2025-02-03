package com.naps.jetpackcompose.activities

import androidx.lifecycle.ViewModel
import com.naps.jetpackcompose.base.Consts
import com.naps.jetpackcompose.data.SharedPreferences
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListTaskViewModel(val localData: SharedPreferences) : ViewModel() {
    private var _title = MutableStateFlow(localData.get(Consts.title))
    val title: StateFlow<String> = _title

    private var _showAlertDialog = MutableStateFlow(false)
    val showAlertDialog: StateFlow<Boolean> = _showAlertDialog

    fun deleteTask(){
        localData.delete(Consts.title)
        localData.delete(Consts.description)
        _title.value = ""
        _showAlertDialog.value = false
    }

    fun setShowAlertDialog(value : Boolean){
        _showAlertDialog.value = value
    }
}