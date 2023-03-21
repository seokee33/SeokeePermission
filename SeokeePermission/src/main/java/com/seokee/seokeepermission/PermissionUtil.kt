package com.seokee.seokeepermission

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import androidx.core.content.ContextCompat

class PermissionUtil(permissions: Array<String>, activity: Activity) {

    private var permissionList:MutableList<String> = permissions.toMutableList()

    private lateinit var requestedPermission:List<String>

    private var activity:Activity = activity


    fun requestPermission() {
        for (permission:String in permissionList){
            if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    activity,
                    permissionList.toTypedArray(),
                    RequestCode.permissionToCode(permission)
                )
            }
        }
    }

    // 권한 요청 결과 처리
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray, callback: PermissionCallback) {
        if (callback == null) {
            return
        }

        // 권한 요청이 성공했는지 확인
        if (requestCode == callback.requestCode) {
            var isAllGranted = true

            // 모든 권한이 허용되었는지 확인
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false
                    break
                }
            }

            // 모든 권한이 허용된 경우 콜백 함수 실행
            if (isAllGranted) {
                callback.onPermissionsGranted()
            } else {
                callback.onPermissionsDenied()
            }
        }
    }
}