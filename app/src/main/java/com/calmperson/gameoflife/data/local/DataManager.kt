package com.calmperson.gameoflife.data.local

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import javax.inject.Inject
import kotlin.reflect.KClass

class DataManager @Inject constructor(private val applicationContext: Context) {

    companion object {
        private val TAG = DataManager::class.simpleName
    }

    fun <T> saveData(data: T, fileName: String) {
        var fos: FileOutputStream? = null
        var oos: ObjectOutputStream? = null
        try {
            fos = File(applicationContext.filesDir, fileName).outputStream()
            oos = ObjectOutputStream(fos)
            oos.writeObject(data)
            Log.i(TAG, "Data has been successfully saved in the file: $fileName")
        } catch (e: Exception) {
            Log.e(TAG, "Error: ", e)
        } finally {
            fos?.close()
            oos?.close()
        }
    }

    fun <T : Any> loadData(dataType: KClass<T>, fileName: String): T? {
        var fis: FileInputStream? = null
        var ois: ObjectInputStream? = null
        try {
            fis = File(applicationContext.filesDir, fileName).inputStream()
            ois = ObjectInputStream(fis)
            val data = ois.readObject() as T
            Log.i(TAG, "Data has been successfully loaded from the file $fileName")
            return data
        } catch (e: Exception) {
            Log.e(TAG, "Error: ", e)
        } finally {
            fis?.close()
            ois?.close()
        }
        return null
    }

}