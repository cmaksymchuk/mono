package com.maksymchuk.inventory;

import java.util.HashMap;
import java.util.Map;

public class Shipments {
	private Map<String, Map<String, Integer>> shipmentMap = new HashMap<String, Map<String, Integer>>();

	public Map<String, Map<String, Integer>> getShipmentMap() {
		return shipmentMap;
	}

	public void setShipmentMap(Map<String, Map<String, Integer>> shipmentMap) {
		this.shipmentMap = shipmentMap;
	}

		
}
