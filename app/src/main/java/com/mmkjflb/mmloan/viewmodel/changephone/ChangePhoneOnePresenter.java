package com.mmkjflb.mmloan.viewmodel.changephone;

import com.mmkjflb.mmloan.R;
import com.mmkjflb.mmloan.model.DataManager;
import com.mmkj.baselibrary.base.RxPresenter;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Administrator on 2017/8/10.
 */

public class ChangePhoneOnePresenter extends RxPresenter<ChangePhoneOneContract.View> implements ChangePhoneOneContract.Presenter {

	private DataManager mDataManager;

	@Inject
	public ChangePhoneOnePresenter(DataManager mDataManager) {
		this.mDataManager = mDataManager;
	}


	@Override
	public void checkUserInfo(Map<String, Object> map) {
		addSubscribe(mDataManager.checkUserInfo(map).doOnSubscribe(subscription -> mView.showProgress()).subscribeOn(AndroidSchedulers.mainThread())
				.subscribe(baseBean -> {
					mView.checkUserInfoSuc(baseBean);
					mView.hideProgress();
				}, throwable -> mView.hideProgress(R.string.neterror_tryagain)));
	}
}
