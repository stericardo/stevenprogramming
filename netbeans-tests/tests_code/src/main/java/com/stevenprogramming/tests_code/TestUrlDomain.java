package com.stevenprogramming.tests_code;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author steven.mendez
 */
public class TestUrlDomain {

  public static void requestGetHost(HttpServletRequest httpServletRequest) {
    StringBuffer url = httpServletRequest.getRequestURL();
    String uri = httpServletRequest.getRequestURI();
    String host = url.substring(0, url.indexOf(uri)); 
  }

  public static String getDomain(String url) {
    try {
      if (url.startsWith("https")) {
        url = url.substring(8); //result
      } else {
        url = url.substring(7); //result
      }
      if (url.indexOf("/") > 0) {
        return url.substring(0, url.indexOf("/"));
      }
    } catch (StringIndexOutOfBoundsException sioobe) {

    }
    return url;
  }

  public static void main(String[] args) {
    String host = getDomain("https://www.google.com");
    String referer = getDomain("https://www.google.com/data");
    System.out.println("host > " + host + " referer > " + referer);
    host = getDomain("https://localhost:4502/libs/granite/core/content/login.html?resource=%2Fcontent%2Fstryker%2Fsandbox%2Fus%2Fen%2Fendoscopy%2Fproducts%2Foperon-d860%2Fdetail.html&$$login$$=%24%24login%24%24&j_reason=unknown&j_reason_code=unknown");
    referer = getDomain("http://localhost:4502/libs/granite/core/content/login.html?resource=%2Fcontent%2Fstryker%2Fsandbox%2Fus%2Fen%2Fendoscopy%2Fproducts%2Foperon-d860%2Fdetail.html&$$login$$=%24%24login%24%24&j_reason=unknown&j_reason_code=unknown");
    System.out.println("host > " + host + " referer > " + referer);

  }
}
