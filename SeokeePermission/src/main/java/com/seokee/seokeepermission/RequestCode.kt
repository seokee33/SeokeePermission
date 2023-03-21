package com.seokee.seokeepermission

import android.Manifest

enum class RequestCode {

    // 저장소
    REQUEST_CODE_READ_EXTERNAL_STORAGE,
    REQUEST_CODE_WRITE_EXTERNAL_STORAGE,

    //카메라
    REQUEST_CODE_CAMERA,

    //마이크
    REQUEST_CODE_RECORD_AUDIO,

    //위치
    REQUEST_CODE_ACCESS_FINE_LOCATION,
    REQUEST_CODE_ACCESS_COARSE_LOCATION,

    //인터넷
    REQUEST_CODE_INTERNET,

    //전화
    REQUEST_CODE_CALL_PHONE,

    //문자
    REQUEST_CODE_SEND_SMS,

    //블루투스
    REQUEST_CODE_BLUETOOTH,
    REQUEST_CODE_BLUETOOTH_ADMIN;


    fun toCode(): Int {
        return when (this) {
            REQUEST_CODE_READ_EXTERNAL_STORAGE -> 101
            REQUEST_CODE_WRITE_EXTERNAL_STORAGE -> 102
            REQUEST_CODE_CAMERA -> 103
            REQUEST_CODE_RECORD_AUDIO -> 104
            REQUEST_CODE_ACCESS_FINE_LOCATION -> 105
            REQUEST_CODE_ACCESS_COARSE_LOCATION -> 106
            REQUEST_CODE_INTERNET -> 107
            REQUEST_CODE_CALL_PHONE -> 108
            REQUEST_CODE_SEND_SMS -> 109
            REQUEST_CODE_BLUETOOTH -> 110
            REQUEST_CODE_BLUETOOTH_ADMIN -> 111
        }
    }


    companion object{
        fun permissionToCode(permission:String):Int{
            return when(permission){
                Manifest.permission.READ_EXTERNAL_STORAGE -> REQUEST_CODE_READ_EXTERNAL_STORAGE.toCode()
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> REQUEST_CODE_WRITE_EXTERNAL_STORAGE.toCode()
                Manifest.permission.CAMERA -> REQUEST_CODE_CAMERA.toCode()
                Manifest.permission.RECORD_AUDIO -> REQUEST_CODE_RECORD_AUDIO.toCode()
                Manifest.permission.ACCESS_FINE_LOCATION -> REQUEST_CODE_ACCESS_FINE_LOCATION.toCode()
                Manifest.permission.ACCESS_COARSE_LOCATION -> REQUEST_CODE_ACCESS_COARSE_LOCATION.toCode()
                Manifest.permission.INTERNET -> REQUEST_CODE_INTERNET.toCode()
                Manifest.permission.CALL_PHONE -> REQUEST_CODE_CALL_PHONE.toCode()
                Manifest.permission.SEND_SMS -> REQUEST_CODE_SEND_SMS.toCode()
                Manifest.permission.BLUETOOTH -> REQUEST_CODE_BLUETOOTH.toCode()
                Manifest.permission.BLUETOOTH_ADMIN -> REQUEST_CODE_BLUETOOTH_ADMIN.toCode()

                else -> 9999
            }
        }
    }
}