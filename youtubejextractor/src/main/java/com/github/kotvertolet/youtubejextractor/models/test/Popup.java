package com.github.kotvertolet.youtubejextractor.models.test;

import com.google.gson.annotations.SerializedName;

public class Popup{

	@SerializedName("confirmDialogRenderer")
	private ConfirmDialogRenderer confirmDialogRenderer;

	public void setConfirmDialogRenderer(ConfirmDialogRenderer confirmDialogRenderer){
		this.confirmDialogRenderer = confirmDialogRenderer;
	}

	public ConfirmDialogRenderer getConfirmDialogRenderer(){
		return confirmDialogRenderer;
	}
}