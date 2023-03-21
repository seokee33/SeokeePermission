package com.seokee.seokeepermission

interface PermissionCallback {
    val requestCode: Int

    fun onPermissionsGranted()

    fun onPermissionsDenied()
}