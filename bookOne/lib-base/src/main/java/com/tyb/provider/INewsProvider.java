package com.tyb.provider;


import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;


public interface INewsProvider extends IProvider {
    Fragment getMainNewsFragment();
}
