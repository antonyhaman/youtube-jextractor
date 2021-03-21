package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class WebPlayerActionsPorting{

	@SerializedName("removeFromWatchLaterCommand")
	private RemoveFromWatchLaterCommand removeFromWatchLaterCommand;

	@SerializedName("subscribeCommand")
	private SubscribeCommand subscribeCommand;

	@SerializedName("getSharePanelCommand")
	private GetSharePanelCommand getSharePanelCommand;

	@SerializedName("unsubscribeCommand")
	private UnsubscribeCommand unsubscribeCommand;

	@SerializedName("addToWatchLaterCommand")
	private AddToWatchLaterCommand addToWatchLaterCommand;

	public void setRemoveFromWatchLaterCommand(RemoveFromWatchLaterCommand removeFromWatchLaterCommand){
		this.removeFromWatchLaterCommand = removeFromWatchLaterCommand;
	}

	public RemoveFromWatchLaterCommand getRemoveFromWatchLaterCommand(){
		return removeFromWatchLaterCommand;
	}

	public void setSubscribeCommand(SubscribeCommand subscribeCommand){
		this.subscribeCommand = subscribeCommand;
	}

	public SubscribeCommand getSubscribeCommand(){
		return subscribeCommand;
	}

	public void setGetSharePanelCommand(GetSharePanelCommand getSharePanelCommand){
		this.getSharePanelCommand = getSharePanelCommand;
	}

	public GetSharePanelCommand getGetSharePanelCommand(){
		return getSharePanelCommand;
	}

	public void setUnsubscribeCommand(UnsubscribeCommand unsubscribeCommand){
		this.unsubscribeCommand = unsubscribeCommand;
	}

	public UnsubscribeCommand getUnsubscribeCommand(){
		return unsubscribeCommand;
	}

	public void setAddToWatchLaterCommand(AddToWatchLaterCommand addToWatchLaterCommand){
		this.addToWatchLaterCommand = addToWatchLaterCommand;
	}

	public AddToWatchLaterCommand getAddToWatchLaterCommand(){
		return addToWatchLaterCommand;
	}
}