package com.sebastianrask.bettersubscription.views.recyclerviews.auto_span_behaviours;

import android.content.Context;

import com.sebastianrask.bettersubscription.R;
import com.sebastianrask.bettersubscription.service.Settings;

/**
 * Created by Sebastian Rask on 09-05-2017.
 */

public class ChannelAutoSpanBehaviour implements AutoSpanBehaviour {
	@Override
	public String getElementSizeName(Settings settings) {
		return settings.getAppearanceChannelSize();
	}

	@Override
	public int getElementWidth(Context context) {
		return (int) context.getResources().getDimension(R.dimen.subscription_card_width) + (int) context.getResources().getDimension(R.dimen.subscription_card_margin);
	}
}
