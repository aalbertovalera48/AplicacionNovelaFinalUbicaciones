// LocationActivity.kt
package com.example.aplicacionnovela.ui.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacionnovela.R
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class LocationActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", MODE_PRIVATE))
        mapView = findViewById(R.id.mapView)
        mapView.setMultiTouchControls(true)

        val spainGeoPoint = GeoPoint(40.416775, -3.703790) // Coordinates for Madrid, Spain
        mapView.controller.setZoom(6.0) // Set an appropriate zoom level
        mapView.controller.setCenter(spainGeoPoint)

        val latitudes = intent.getDoubleArrayExtra("latitudes")
        val longitudes = intent.getDoubleArrayExtra("longitudes")
        val titles = intent.getStringArrayExtra("titles")

        if (latitudes != null && longitudes != null && titles != null &&
            latitudes.isNotEmpty() && longitudes.isNotEmpty() && titles.isNotEmpty()) {
            val geoPoints = latitudes.zip(longitudes).map { GeoPoint(it.first, it.second) }

            geoPoints.forEachIndexed { index, geoPoint ->
                val marker = Marker(mapView)
                marker.position = geoPoint
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                marker.title = titles[index]
                mapView.overlays.add(marker)
            }
        }
    }
}