package com.epam.training.dailyhandson.strings;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * This class is intended for some custom operations on {@code String} types.
 * It acts as a mutable string class.
 * */
public class CustomString  {

  String str;

  public CustomString(String str) {
    super();
    this.str = str;
  }

  /**
   * method to capitalize a particular string by changing it's first alphabetic
   * character to uppercase.
   * 
   */
  public void capitalize() {
    char[] tempArr = str.toCharArray();
    int i;
    for (i = 0; i < tempArr.length; i++) {
      if ((int) tempArr[i] >= 97 && (int) tempArr[i] <= 122) {
        tempArr[i] = (char) ((int) tempArr[i] - 32);
        break;
      } else if ((int) tempArr[i] >= 65 && (int) tempArr[i] <= 90) {
        return;
      }
    }
    str = new String(tempArr);
  }

  @Override
  public String toString() {
    return str;
  }

  /**
   * method to encode a string using a char as key and XORing it with each
   * character of String.
   * 
   */
  public void encode(char key) {
    char[] tempArr = str.toCharArray();
    for (int i = 0; i < tempArr.length; i++) {
      tempArr[i] = (char) (tempArr[i] ^ key);
    }
    str = new String(tempArr);
  }

  /**
   * method to decode a string using a char as key and XORing it with each
   * character of encoded String.
   * 
   */
  public void decode(char key) {
    char[] tempArr = str.toCharArray();
    for (int i = 0; i < tempArr.length; i++) {
      tempArr[i] = (char) (tempArr[i] ^ key);
    }
    str = new String(tempArr);
  }

  /**
   * method to convert hungarian characters to english ones using normalization of
   * string with canonical decomposition normalization form and regex to de
   * accentify the string.
   */
  public void convertHungarianToEnglish() {
    str = Normalizer.normalize(str, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    str = pattern.matcher(str).replaceAll("");
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

}
