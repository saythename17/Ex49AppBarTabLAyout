package com.icandothisallday2020.ex49appbartablayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    TabLayout tabLayout;
    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);

        tabLayout=findViewById(R.id.layout_tab);
        //Tab Button 객체 생성
//        TabLayout.Tab tab1=tabLayout.newTab();
//        tab1.setText("POWER");
//        tab1.setIcon(android.R.drawable.ic_lock_power_off);
//        tab1.setTag("tab1");//식별문자열(id 같은 역할)
//        tabLayout.addTab(tab1);
//        TabLayout.Tab tab2=tabLayout.newTab().setText("MY").setIcon(android.R.drawable.star_on).setTag("tab2");
//        tabLayout.addTab(tab2);
//        tabLayout.addTab(tabLayout.newTab().setText("CALL").setIcon(android.R.drawable.ic_menu_call).setTag("tab3"));
        //뷰페이저 아답터 설정






        adapter=new MyAdapter(getSupportFragmentManager());
        pager=findViewById(R.id.pager);
        pager.setAdapter(adapter);
        //TabLayout 과 ViewPager 연동-탭버튼의 글씨를 뷰페이저의 아답터에서 결정
        // ∴ Tab 개수는 아답터의 프레그먼트에서 결정(즉, 위 Tab 객체 추가는 의미없어짐)
        tabLayout.setupWithViewPager(pager);
        //페이지와 탭을 연동시키면 기본적으로 탭버튼에 아이콘이 없음
        //↓ 탭아이콘 설정
        tabLayout.getTabAt(0).setIcon(android.R.drawable.ic_lock_idle_alarm);
        tabLayout.getTabAt(1).setIcon(android.R.drawable.ic_lock_idle_lock);
        tabLayout.getTabAt(2).setIcon(android.R.drawable.ic_dialog_dialer);
        setSupportActionBar(toolbar);
        //제목줄관리자(ActionBar)에게 subTitle 설정
        getSupportActionBar().setSubtitle("Clock");
        //탭이변경되는 것을 듣는 리스너 객체 추가
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle(tab.getText());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {            }
        });
        drawerLayout=findViewById(R.id.layout_drawer);
        navigationView=findViewById(R.id.navi);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
