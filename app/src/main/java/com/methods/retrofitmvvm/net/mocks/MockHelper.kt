package com.methods.retrofitmvvm.net.mocks

import android.content.res.AssetManager
import android.util.Log
import java.io.File
import java.io.InputStream

class MockHelper() {

    companion object {

        fun readFromAsset(assetManager: AssetManager, folder:String, file: String):String{
            return assetManager.open(File(folder,file).path).bufferedReader().readText()
        }
        fun readFromAssets(assetManager: AssetManager): List<String> {

            val string = ArrayList<String>()
            val streams: List<InputStream> =
                getListStreams(
                    assetManager,
                    "API"
                )
            for (stream in streams) {

                string.add(stream.bufferedReader().readText())
            }


            return string;


        }

        fun getListStreams(assetManager: AssetManager, folder: String): List<InputStream> {
            val names =
                getNames(
                    assetManager,
                    folder
                )
            val list = ArrayList<InputStream>();
            for (name in names) {
                val path = File(folder,name).path
                list.add(assetManager.open(path))
            }
            return list;

        }

        fun getNames(assetManager: AssetManager, folder: String): Array<String> {

            val paths = assetManager.list(folder) ?: arrayOf<String>()

            for (names in paths) {
                Log.d("Assets", names)

            }
            return paths

        }
    }
}