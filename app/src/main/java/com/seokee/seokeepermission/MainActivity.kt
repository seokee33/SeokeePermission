package com.seokee.seokeepermission

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var permissionUtil: PermissionUtil

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.RequestPermission)

        permissionUtil = PermissionUtil(
            arrayOf(
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ), this
        )

        permissionUtil.requestPermission()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.i("Permission",requestCode.toString())
        permissionUtil.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults,
            object : PermissionCallback {
                override val requestCode: Int
                    get() = requestCode
                @SuppressLint("SetTextI18n")
                override fun onPermissionsGranted() {
                    when (requestCode) {
                        RequestCode.REQUEST_CODE_CAMERA.toCode() -> {
                            Log.i("Permission",requestCode.toString()+"허용")
                            runOnUiThread {
                                textView.text = "${textView.text.toString()} 카메라 권한 혀용\n"
                            }
                        }
                        RequestCode.REQUEST_CODE_ACCESS_FINE_LOCATION.toCode() -> {
                            Log.i("Permission",requestCode.toString()+"허용")
                            runOnUiThread{
                                textView.text = "${textView.text.toString()} 위치 권한 혀용\n"
                            }
                        }
                        RequestCode.REQUEST_CODE_ACCESS_COARSE_LOCATION.toCode() -> {
                            Log.i("Permission",requestCode.toString()+"허용")
                            runOnUiThread {
                                textView.text = "${textView.text.toString()} 위치 권한 혀용\n"
                            }
                        }
                    }


                }

                @SuppressLint("SetTextI18n")
                override fun onPermissionsDenied() {
                    when (requestCode) {
                        RequestCode.REQUEST_CODE_CAMERA.toCode() -> {
                            textView.text = "${textView.text.toString()} 카메라 권한 허용 안함\n"
                        }
                        RequestCode.REQUEST_CODE_ACCESS_FINE_LOCATION.toCode() -> {
                            textView.text = "${textView.text.toString()} 위치 권한 허용 안함\n"
                        }
                        RequestCode.REQUEST_CODE_ACCESS_COARSE_LOCATION.toCode() -> {
                            textView.text = "${textView.text.toString()} 위치 권한 허용 안함\n"
                        }
                    }
                }

            })
    }
}