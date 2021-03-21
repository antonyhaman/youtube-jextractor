package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SignalServiceEndpoint{

	@SerializedName("signal")
	private String signal;

	@SerializedName("actions")
	private List<ActionsItem> actions;

	public void setSignal(String signal){
		this.signal = signal;
	}

	public String getSignal(){
		return signal;
	}

	public void setActions(List<ActionsItem> actions){
		this.actions = actions;
	}

	public List<ActionsItem> getActions(){
		return actions;
	}
}