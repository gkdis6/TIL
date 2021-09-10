package com.sy.googlemaps

import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.sy.googlemaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val LATLNG = LatLng(37.566418, 126.977943)

        /*
        val markerOptions = MarkerOptions()
            .position(LATLNG)
            .title("Marker in Seoul Cite Hall")
        mMap.addMarker(markerOptions)
        */

        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)

        /*
        var markerOptions = MarkerOptions()
            .position(LATLNG)
            .title("Seoul City Hall")
            .snippet("37.566418, 126.977943")
        mMap.addMarker(markerOptions)
         */

        var bitmapDrawable : BitmapDrawable

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(R.drawable.marker) as BitmapDrawable
        }else{
            bitmapDrawable = resources.getDrawable(R.drawable.marker) as BitmapDrawable
        }

        var discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)
        val markerOptions = MarkerOptions()
            .position(LATLNG)
            .icon(discriptor)
            .title("butterfly")
        mMap.addMarker(markerOptions)
    }

}