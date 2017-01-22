class HelloWorldFile {
 
     static {
		 System.out.println(System.getProperty("java.library.path"));
         System.loadLibrary("HelloWorldFile");
     }
 
     private native void print(int number, String value);
 
     public static void main(String[] args) {
		 int number = 70;
		 String value = "Steven data ";
         new HelloWorldFile().print(number, value);
     }
 }
