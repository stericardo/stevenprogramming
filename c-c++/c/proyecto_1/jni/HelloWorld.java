class HelloWorld {
 
     static {
		 System.out.println(System.getProperty("java.library.path"));
         System.loadLibrary("HelloWorld");
     }
 
     private native void print();
 
     public static void main(String[] args) {
         new HelloWorld().print();
     }
 }
