package com.example.parametros.model

import android.os.Parcel
import android.os.Parcelable

data class Alumno2(var nombre:String?, var numCuenta:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(numCuenta)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Alumno2> {
        override fun createFromParcel(parcel: Parcel): Alumno2 {
            return Alumno2(parcel)
        }

        override fun newArray(size: Int): Array<Alumno2?> {
            return arrayOfNulls(size)
        }
    }
}

