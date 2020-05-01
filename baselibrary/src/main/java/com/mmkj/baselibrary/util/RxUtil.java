package com.mmkj.baselibrary.util;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {
	/**
	 * 统一线程处理
	 *
	 * @param <T>
	 * @return
	 */
	public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
		return observable -> observable.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.unsubscribeOn(Schedulers.io());
	}
}
