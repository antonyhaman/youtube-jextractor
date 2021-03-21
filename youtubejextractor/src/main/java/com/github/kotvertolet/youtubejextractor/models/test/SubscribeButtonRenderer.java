package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubscribeButtonRenderer{

	@SerializedName("buttonText")
	private ButtonText buttonText;

	@SerializedName("subscribeAccessibility")
	private SubscribeAccessibility subscribeAccessibility;

	@SerializedName("showPreferences")
	private boolean showPreferences;

	@SerializedName("type")
	private String type;

	@SerializedName("subscribedButtonText")
	private SubscribedButtonText subscribedButtonText;

	@SerializedName("enabled")
	private boolean enabled;

	@SerializedName("unsubscribeButtonText")
	private UnsubscribeButtonText unsubscribeButtonText;

	@SerializedName("signInEndpoint")
	private SignInEndpoint signInEndpoint;

	@SerializedName("subscribed")
	private boolean subscribed;

	@SerializedName("unsubscribeAccessibility")
	private UnsubscribeAccessibility unsubscribeAccessibility;

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("channelId")
	private String channelId;

	@SerializedName("unsubscribedButtonText")
	private UnsubscribedButtonText unsubscribedButtonText;

	@SerializedName("serviceEndpoints")
	private List<ServiceEndpointsItem> serviceEndpoints;

	public void setButtonText(ButtonText buttonText){
		this.buttonText = buttonText;
	}

	public ButtonText getButtonText(){
		return buttonText;
	}

	public void setSubscribeAccessibility(SubscribeAccessibility subscribeAccessibility){
		this.subscribeAccessibility = subscribeAccessibility;
	}

	public SubscribeAccessibility getSubscribeAccessibility(){
		return subscribeAccessibility;
	}

	public void setShowPreferences(boolean showPreferences){
		this.showPreferences = showPreferences;
	}

	public boolean isShowPreferences(){
		return showPreferences;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setSubscribedButtonText(SubscribedButtonText subscribedButtonText){
		this.subscribedButtonText = subscribedButtonText;
	}

	public SubscribedButtonText getSubscribedButtonText(){
		return subscribedButtonText;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setUnsubscribeButtonText(UnsubscribeButtonText unsubscribeButtonText){
		this.unsubscribeButtonText = unsubscribeButtonText;
	}

	public UnsubscribeButtonText getUnsubscribeButtonText(){
		return unsubscribeButtonText;
	}

	public void setSignInEndpoint(SignInEndpoint signInEndpoint){
		this.signInEndpoint = signInEndpoint;
	}

	public SignInEndpoint getSignInEndpoint(){
		return signInEndpoint;
	}

	public void setSubscribed(boolean subscribed){
		this.subscribed = subscribed;
	}

	public boolean isSubscribed(){
		return subscribed;
	}

	public void setUnsubscribeAccessibility(UnsubscribeAccessibility unsubscribeAccessibility){
		this.unsubscribeAccessibility = unsubscribeAccessibility;
	}

	public UnsubscribeAccessibility getUnsubscribeAccessibility(){
		return unsubscribeAccessibility;
	}

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setUnsubscribedButtonText(UnsubscribedButtonText unsubscribedButtonText){
		this.unsubscribedButtonText = unsubscribedButtonText;
	}

	public UnsubscribedButtonText getUnsubscribedButtonText(){
		return unsubscribedButtonText;
	}

	public void setServiceEndpoints(List<ServiceEndpointsItem> serviceEndpoints){
		this.serviceEndpoints = serviceEndpoints;
	}

	public List<ServiceEndpointsItem> getServiceEndpoints(){
		return serviceEndpoints;
	}
}