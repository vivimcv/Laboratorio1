package com.example.ireaderqr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class QR: AppCompatActivity(), ZXingScannerView.ResultHandler {
    private val PERMISO_CAMERA = 1
    private val scannerView:ZXingScannerView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scannerView = ZXingScannerView(this)
        setContentView(scannerView)
        scannerView?.startCamera()


    }


    override fun handleResult(p0: Result?) {
        //Aquí llega lo que lee el QR
     val
    }
}