package com.stevenprogramming.tests_code;

/**
 *
 * @author steven.mendez
 */
public class StevenTest {

  public static final String ELLIPSIS = "...";

  public static String getDescriptionShortWithEllipsis(String data,
          int sizeReqired) {
    if (data.length() < sizeReqired) {
      return data.concat(ELLIPSIS);
    }
    if (data.length() == sizeReqired) {
      char ch = data.charAt(sizeReqired - 1);
      if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n' || Character.isWhitespace(ch)) {
        return data.concat(ELLIPSIS);
      }
    } 
      String cuttingText = data.substring(0, sizeReqired);
      int index = cuttingText.lastIndexOf(" ");
      cuttingText = data.substring(0, index);
      return cuttingText.concat(ELLIPSIS);
  }

  public static void main(String[] args) {
    String description = "Esto es una prueba de informacion con el fin "
            + "de poder enconntrar el corte de texto en el lugar adecuado"
            + "siempre validando spaces y tambien validando posiciones";

    System.out.println(getDescriptionShortWithEllipsis(description, 56));
    System.out.println(getDescriptionShortWithEllipsis(description, 46));
    System.out.println(getDescriptionShortWithEllipsis(description, 36));
    System.out.println(getDescriptionShortWithEllipsis(description, 16));
    System.out.println(getDescriptionShortWithEllipsis(description, 21));
    System.out.println(getDescriptionShortWithEllipsis(description, 32));
    System.out.println(getDescriptionShortWithEllipsis(description, 41));
    System.out.println(getDescriptionShortWithEllipsis(description, 76));

  }
}
