package com.trip.domain;

public class Images {
      private int circleId=0;
      private String imagePath=null;
      
	public Images() {
		super();
	}

	public Images(int circleId, String imagePath) {
		super();
		this.circleId = circleId;
		this.imagePath = imagePath;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return imagePath ;
	}
	
	
      
}
