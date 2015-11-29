package com.trip.domain;

public class Attention {
	private int attentionId;
	private int followId;
	private int followedId;
	private boolean tag;
	
	public Attention(int attentionId,int followId,int followedId,boolean tag){
		this.attentionId=attentionId;
		this.followId=followId;
		this.followedId=followedId;
		this.tag=tag;
	}
	
	public int getAttentionId() {
		return attentionId;
	}

	public void setAttentionId(int attentionId) {
		this.attentionId = attentionId;
	}

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public int getFollowedId() {
		return followedId;
	}

	public void setFollowedId(int followedId) {
		this.followedId = followedId;
	}

	public boolean isTag() {
		return tag;
	}
	public void setTag(boolean tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		return  attentionId+"qwert" +followId + "qwert" + followedId+ "qwert" +tag;
	}
}
