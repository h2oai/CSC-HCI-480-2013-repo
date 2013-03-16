// Copyright 2013 Oswego University 
//
// Licensed under the Apache License, Version 2.0 (the "License"); 
// you may not use this file except in compliance with the License. 
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, 
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
// See the License for the specific language governing permissions and 
// limitations under the License.

package edu.oswego.csc480_hci521_2013.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import edu.oswego.csc480_hci521_2013.shared.h2o.json.RFView;

public class RFParameterView extends Composite {
    
    private static RFParameterViewUiBinder uiBinder = GWT.create(RFParameterViewUiBinder.class);
    
    interface RFParameterViewUiBinder extends UiBinder<Widget, RFParameterView> {
    }
    
    @UiField Element rows;
    
    public RFParameterView() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    public void setData(RFView data) {
        this.rows.setInnerText(Integer.toString(data.getNtree()));
    }
}