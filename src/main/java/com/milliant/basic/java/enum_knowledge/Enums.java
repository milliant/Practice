package com.milliant.basic.java.enum_knowledge;

public class Enums {
	public static <T extends Enum<T>> T random(Class<T> rc){
		return random(rc.getEnumConstants());
	}
	private static <T> T random(T[] values){
		return values[(int) (Math.random()*values.length)];
	}
}
