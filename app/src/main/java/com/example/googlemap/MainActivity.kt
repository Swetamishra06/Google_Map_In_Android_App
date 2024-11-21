package com.example.googlemap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapfragment) as SupportMapFragment
        mapFragment.getMapAsync(this) // Pass 'this' instead of a new instance of OnMapReadyCallback
    }

    // This method will be called when the map is ready
    override fun onMapReady(gmap: GoogleMap) {
        map = gmap
        // Reference of ready google map is loaded here
        var jdhlatlng = LatLng(26.2389,73.0243)
        var markerOptions= MarkerOptions().position(jdhlatlng).title("Jodhpur")
        map.addMarker(markerOptions)
        //adding marker initially to jodhpur
        map.moveCamera(CameraUpdateFactory.newLatLng(jdhlatlng))//move camera initially to jodhpur
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(jdhlatlng,16f))//by default zoomed camera

    }
}




