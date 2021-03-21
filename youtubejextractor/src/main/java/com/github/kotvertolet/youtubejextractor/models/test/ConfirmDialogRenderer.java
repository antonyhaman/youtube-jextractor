package com.github.kotvertolet.youtubejextractor.models.test;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ConfirmDialogRenderer{

	@SerializedName("trackingParams")
	private String trackingParams;

	@SerializedName("cancelButton")
	private CancelButton cancelButton;

	@SerializedName("confirmButton")
	private ConfirmButton confirmButton;

	@SerializedName("dialogMessages")
	private List<DialogMessagesItem> dialogMessages;

	@SerializedName("primaryIsCancel")
	private boolean primaryIsCancel;

	public void setTrackingParams(String trackingParams){
		this.trackingParams = trackingParams;
	}

	public String getTrackingParams(){
		return trackingParams;
	}

	public void setCancelButton(CancelButton cancelButton){
		this.cancelButton = cancelButton;
	}

	public CancelButton getCancelButton(){
		return cancelButton;
	}

	public void setConfirmButton(ConfirmButton confirmButton){
		this.confirmButton = confirmButton;
	}

	public ConfirmButton getConfirmButton(){
		return confirmButton;
	}

	public void setDialogMessages(List<DialogMessagesItem> dialogMessages){
		this.dialogMessages = dialogMessages;
	}

	public List<DialogMessagesItem> getDialogMessages(){
		return dialogMessages;
	}

	public void setPrimaryIsCancel(boolean primaryIsCancel){
		this.primaryIsCancel = primaryIsCancel;
	}

	public boolean isPrimaryIsCancel(){
		return primaryIsCancel;
	}
}