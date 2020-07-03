package com.icandothisallday2020.ex49appbartablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    Fragment[] fragments=new Fragment[3];//참조변수 배열.
    String[] tabTexts=new String[]{"Analog","Digital","Calender"};
    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]=new Tab1Fragment();
        fragments[1]=new Tab2Fragment();
        fragments[2]=new Tab3Fragment();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
    //탭 레이아웃과 연동시 탭버튼에 보여질 text 리턴 메소드
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}
