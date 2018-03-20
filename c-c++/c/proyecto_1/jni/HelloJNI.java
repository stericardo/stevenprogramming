public class HelloJNI {
   static {
	    try
	   {
		   System.out.println(System.getProperty("java.library.path"));

      System.loadLibrary("hello"); // Load native library at runtime
                                   // hello.dll (Windows) or libhello.so (Unixes)
                                   }catch(Exception e){
		System.out.println(e.toString());
	     
		  }
   }
 
   // Declare a native method sayHello() that receives nothing and returns void
   private native void sayHello();
 
   // Test Driver
   public static void main(String[] args) {
	   System.out.println(System.getProperty("java.library.path"));
	   try
	   {
      new HelloJNI().sayHello();  // invoke the native method
      }catch(Exception e){
		System.out.println(e.toString());
	     
		  }
   }
}
