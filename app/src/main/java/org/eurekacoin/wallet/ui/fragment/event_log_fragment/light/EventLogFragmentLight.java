package com.eurekanetwork.wallet.ui.fragment.event_log_fragment.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.gson.history.Log;
import com.eurekanetwork.wallet.ui.fragment.event_log_fragment.EventLogFragment;

import java.util.List;


public class EventLogFragmentLight extends EventLogFragment{

    @Override
    protected int getLayout() {
        return R.layout.fragment_event_log_light;
    }

    @Override
    public void updateEventLog(List<Log> logs) {
        mEventLogAdapter = new EventLogAdapter(logs, R.layout.item_event_log_light, R.layout.item_event_log_data_light);
        mRecyclerViewLogs.setAdapter(mEventLogAdapter);
    }
}
