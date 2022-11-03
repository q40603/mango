package com.serotonin.mango.db.dao;
import com.serotonin.mango.vo.User;
public class CacheItem<int,User> {
	private int key;
	private User value;
	private int hitCount=0;
	private CacheItem(int key,User value) {
		this.key=key;
		this.value=value;
	}
	 public void incrementHitCount() {
	        this.hitCount++;
	    }
	 User getValue() {
		 return value;
		 
	 }
	 void setValue(User value) {
		 this.value=value;
	 }
	 void setKey(int key) {
		 this.key=key;
		 
	 }
	 
	 int getKey() {
		 return key;
	 }
}
