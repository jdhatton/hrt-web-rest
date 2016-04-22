package com.hrt.data.db.enums;

public enum UserRole {

		TEACHER(0),
	    PARENT(1),
	    STUDENT(2),
	    ADMIN(3),
	    DISTRICT(4),
	    SPECIAL(5),
	    OTHER(6);

	    private final int value;

	    private UserRole(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	    
	    public static int getValue(String intValue) {
	    	try{
	    		return Integer.parseInt(intValue);
	    	}catch(Exception e){return 6;}
	    }
	}