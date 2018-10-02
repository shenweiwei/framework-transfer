package org.sww.framework.transfer.http.plugin;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public interface HttpWatcher {
	void onWatch(Object dto);
	Observable<Object> doOnNext();
	
	default Disposable watchSubscribe() {
		return this.doOnNext().subscribe(dto -> {
			this.onWatch(dto);
		});
	}
}
