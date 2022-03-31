package com.example.homemovies

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.homemovies.databinding.ActivityMainBinding
import java.io.IOException
import java.nio.charset.Charset

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var titleData: ArrayList<String> = ArrayList()
    private var statusData: ArrayList<String> = ArrayList()
    private var idData: ArrayList<String> = ArrayList()
    var arr = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_library, R.id.nav_watched, R.id.nav_watchlist
            ), drawerLayout
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /*read_json()*/
        /*title = "KotlinApp"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val titleArray = obj.getJSONArray("title")
            for (i in 0 until titleArray.length()) {
                val userDetail = titleArray.getJSONObject(i)
                titleData.add(userDetail.getString("title"))
                statusData.add(userDetail.getString("status"))
                idData.add(userDetail.getString("id"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
        val customAdapter = LibraryViewModel() CustomAdapter(this@MainActivity, personName, emailId, mobileNumbers)
        recyclerView.adapter = customAdapter*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("movieData.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

        /*fun read_json(){
            var json:String? = null

            try {
                val inputStream: InputStream = assets.open("movieData.json")
                json = inputStream.bufferedReader().use { it.readText() }

                var jsonarr = JSONArray(json)

                for (i in 0..jsonarr.length() ){
                    var jsonobj = jsonarr.getJSONObject(i)
                    arr.add(jsonobj.getString("title"))

                }


            }catch (e : IOException){

            }
        }*/
}