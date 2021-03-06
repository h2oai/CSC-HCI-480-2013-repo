/*
 * Copyright 2013 State University of New York at Oswego
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package edu.oswego.csc480_hci521_2013.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import java.util.logging.Logger;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import edu.oswego.csc480_hci521_2013.client.place.DataTablePlace;
import edu.oswego.csc480_hci521_2013.client.presenters.DataPanelPresenter;
import edu.oswego.csc480_hci521_2013.client.presenters.DataPanelPresenterImpl;
import edu.oswego.csc480_hci521_2013.client.services.H2OServiceAsync;
import edu.oswego.csc480_hci521_2013.client.ui.DataPanelViewImpl;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.Inspect;
import edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders.InspectBuilder;
import java.util.logging.Level;

public class DataPanelActivity extends AbstractActivity {

    static final Logger logger = Logger.getLogger(
            DataPanelActivity.class.getName());

    H2OServiceAsync h2oService;
    String datakey;

    public DataPanelActivity(DataTablePlace place, H2OServiceAsync h2oService) {
        this.h2oService = h2oService;
        datakey = place.getDataKey();
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        h2oService.getData(new InspectBuilder(datakey), new AsyncCallback<Inspect>() {

            @Override
            public void onFailure(Throwable caught) {
                logger.log(Level.INFO, "Failure adding data tab.");
                logger.log(Level.SEVERE, caught.toString());
                // FIXME: do a message box or something...
            }

            @Override
            public void onSuccess(Inspect result) {
                logger.log(Level.INFO, "Building data tab.");

                // TODO: ideally we would want to hide the menu bar and add some sort of title header to the page...
                DataPanelPresenter presenter = new DataPanelPresenterImpl(
                        h2oService, new DataPanelViewImpl(true),
                        eventBus, datakey, result);
                panel.setWidget(presenter.getView());
            }
        });
    }

    public static native void openPanel(DoublePanelActivity parent, String url, String name, String features, String datakey)/*-{
        var window = $wnd.open(url, name, features);
        window.onbeforeunload = function() {
            parent.@edu.oswego.csc480_hci521_2013.client.activity.DoublePanelActivity::popinDataPanel(Ljava/lang/String;)(datakey);
        }
    }-*/;
}
