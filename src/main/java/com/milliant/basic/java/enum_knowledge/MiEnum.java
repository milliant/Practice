package com.milliant.basic.java.enum_knowledge;

public enum MiEnum {
		ONE,TWO,THREE,FOUR,FIVE;
		public static MiEnum next(){
			return values()[(int) (Math.random()*5)];
		}
		
		public static void main(String[] args)
		{
			MiEnum mi_1 = MiEnum.ONE;
			for(MiEnum e:MiEnum.values()){
				System.out.println(MiEnum.next());
			}
			switch(mi_1){
			case ONE:
			case TWO:
			case THREE:
			default:break;
			}
		}
}
