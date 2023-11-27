package com.androidstudy.toolbarscrollviewexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainFragment extends Fragment implements OnMapReadyCallback {

    View rootView;
    MapView mapView;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mapview_main, container, false);
        mapView = (MapView)rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return rootView;
    }

// onResume() : 사용자와 상호작용 하는 단계 / 주로 앱 기능이 onResume()에 설정됨
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    // onLowMemory() : 시스템 리소스가 부족할 때,
    // 즉 애플리케이션 메모리가 부족하면 호출됩니다.
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    //  onDestroy() : 액티비티가 완전히 종료되기 직전에 호출됩니다.
    //  여러 개의 액티비티를 갖는 앱에서도 액티비티 생명주기에 맞춰
    //  콜백 메서드를 호출합니다.
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        MapsInitializer.initialize(this.getActivity());

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom
                (new LatLng(37.5030698,126.8789856), 14);

        googleMap.animateCamera(cameraUpdate);

        LatLng seoulCityHall = new LatLng(37.5030698,126.8789856);
        googleMap.addMarker(new MarkerOptions().position(seoulCityHall).title("Location : AniZip"));
    }
}
