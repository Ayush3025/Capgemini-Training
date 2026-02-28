package com.capge;

public class StringShifting {
	
	public String shiftr(String str){
		if(str.length()<2 || str==null) {
			return null;
		}
        String s1=str.substring(0,2);
        String s2=str.substring(2);
        return s2+s1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringShifting ob = new StringShifting();
		String s="H";
        String op=ob.shiftr(s);
        System.out.println(op);
	}

}
