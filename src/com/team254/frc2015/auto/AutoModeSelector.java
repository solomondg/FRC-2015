package com.team254.frc2015.auto;

import com.team254.frc2015.auto.modes.*;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public class AutoModeSelector {
	private static AutoModeSelector instance = null;
	private ArrayList<AutoMode> autoModes = new ArrayList<AutoMode>();
	int selectedIndex = 0;
	
	public static AutoModeSelector getInstance() {
		if (instance == null) {
			instance = new AutoModeSelector();
		}
		return instance;
	}
	
	public  void registerAutonomous(AutoMode auto) {
		autoModes.add(auto);
	}
	
	public AutoModeSelector() {
        registerAutonomous(new DoNothingAutoMode());
        //registerAutonomous(new ThreeBinNoCanAutoMode());
	}
	
	public AutoMode getAutoMode() {
		return (AutoMode) autoModes.get(selectedIndex);
	}
	
	public ArrayList<String> getAutoModeList() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < autoModes.size(); i++){
			list.add(autoModes.get(i).getClass().getSimpleName());
		}
		return list;
	}
	
	public JSONArray getAutoModeJSONList() {
		JSONArray list = new JSONArray();
		list.addAll(getAutoModeList());
		return list;
	}
	
	public void setAutoModeByIndex(int which) {
		selectedIndex = which;
	}

}
