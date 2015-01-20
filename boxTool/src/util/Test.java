package util;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*String s ="1.1-1.5";
		String[] ss =  s.split("-");
		System.out.println((s.split("-"))[0]);
		System.out.println(ss[1]);*/
		
		//String [] s ={"a1","a2","a3","a4","a5","a6"};
		String [] s= new String[5];
		s[0]="a1";
		s[1]="a2";
		s[2]="a5";
		s[3]="a4";
		s[4]="a3";
		for(int i=0 ;i<s.length;i++){
			if(s[i].equals("a3")){
				//return;
				//continue;
				//break;
			}else if(s[i].equals("a5")){
				System.out.println("a5");
			}else{
				System.out.println(s[i]);
			}
		}
		System.out.println("end");
	}

}
