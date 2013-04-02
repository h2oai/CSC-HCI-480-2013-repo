package edu.oswego.csc480_hci521_2013.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import edu.oswego.csc480_hci521_2013.client.place.DoublePanelPlace;
import edu.oswego.csc480_hci521_2013.client.place.popout.DataPanelPlace;
import edu.oswego.csc480_hci521_2013.client.place.popout.ConfusionMatrixPlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */

@WithTokenizers({ 
	DoublePanelPlace.Tokenizer.class, 
	DataPanelPlace.Tokenizer.class,
	ConfusionMatrixPlace.Tokenizer.class
})

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {}
