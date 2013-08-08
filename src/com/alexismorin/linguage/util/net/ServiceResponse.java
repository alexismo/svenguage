package com.alexismorin.linguage.util.net;

import com.google.gson.annotations.SerializedName;

public class ServiceResponse {

	@SerializedName("timestamp")
	public String timestamp;
	
	@SerializedName("status")
	public String status;
	
	@SerializedName("reason")
	public String reason;
	
	@SerializedName("reasonCode")
	public String reasonCode;
}
