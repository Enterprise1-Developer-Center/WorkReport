package kr.co.e1.workreport.framework;

import android.content.res.Resources;
import android.text.TextUtils;
import kr.co.e1.workreport.R;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 10
 */

public class LoginValidation {
  private final static int MINIMUM_LENGTH_ID = 3;
  private final static int MINIMUM_LENGTH_PW = 8;
  private final static int MAXIMUM_LENGTH = 15;
  public static boolean validate(String pass, String username) {
    String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";
    if (pass.matches(pattern)) {
      for (int i = 0; (i + 3) < username.length(); i++) {
        if (pass.contains(username.substring(i, i + 3))
            || username.length() < 3
            || username.length() > 15) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static Validate2Result validate2(String pass, String username, Resources res) {
    if (TextUtils.isEmpty(pass) && TextUtils.isEmpty(username)) {
      return new Validate2Result(false, res.getString(R.string.validate_all_empty));
    }
    if (pass.length() < MINIMUM_LENGTH_PW || pass.length() > MAXIMUM_LENGTH) {
      System.out.println("pass too short or too long");
      return new Validate2Result(false, res.getString(R.string.validate_pass_short_or_long));
    }
    if (username.length() < MINIMUM_LENGTH_ID || username.length() > MAXIMUM_LENGTH) {
      System.out.println("username too short or too long");
      return new Validate2Result(false, res.getString(R.string.validate_id_short_or_long));
    }
    if (!pass.matches(".*\\d.*")) {
      System.out.println("no digits found");
      return new Validate2Result(false, res.getString(R.string.validate_no_digits));
    }
    if (!pass.matches(".*[a-z].*")) {
      System.out.println("no lowercase letters found");
      return new Validate2Result(false, res.getString(R.string.validate_no_lowercase));
    }
    if (!pass.matches(".*[!@#$%^&*+=?-].*")) {
      System.out.println("no special chars found");
      return new Validate2Result(false, res.getString(R.string.validate_no_special_chars));
    }
    if (containsPartOf(pass, username)) {
      System.out.println("pass contains substring of username");
      return new Validate2Result(false, res.getString(R.string.validate_pass_contains_id));
    }

    return new Validate2Result(true, "");
  }

  @AllArgsConstructor @ToString public static class Validate2Result {
    @Getter private boolean validate;
    @Getter private String message;
  }

  // if you don't care why it fails and only want to know if valid or not
  public static boolean validate(String pass, String username, String email) {
    String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";
    if (pass.matches(pattern)) {
      for (int i = 0; (i + 3) < username.length(); i++) {
        if (pass.contains(username.substring(i, i + 3))
            || username.length() < 3
            || username.length() > 15) {
          return false;
        }
      }
      for (int i = 0; (i + 3) < email.length(); i++) {
        if (pass.contains(email.substring(i, i + 3)) || email.length() < 3 || email.length() > 15) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  // if you want to know which requirement was not met
  public static boolean validate2(String pass, String username, String email) {
    if (pass.length() < 8 || pass.length() > 15) {
      System.out.println("pass too short or too long");
      return false;
    }
    if (username.length() < 3 || username.length() > 15) {
      System.out.println("username too short or too long");
      return false;
    }
    if (!pass.matches(".*\\d.*")) {
      System.out.println("no digits found");
      return false;
    }

    if (!pass.matches(".*[a-z].*")) {
      System.out.println("no lowercase letters found");
      return false;
    }
    if (!pass.matches(".*[!@#$%^&*+=?-].*")) {
      System.out.println("no special chars found");
      return false;
    }
    if (containsPartOf(pass, username)) {
      System.out.println("pass contains substring of username");
      return false;
    }
    if (containsPartOf(pass, email)) {
      System.out.println("pass contains substring of email");
      return false;
    }
    return true;
  }

  private static boolean containsPartOf(String pass, String username) {
    int requiredMin = MINIMUM_LENGTH_ID;
    for (int i = 0; (i + requiredMin) < username.length(); i++) {
      if (pass.contains(username.substring(i, i + requiredMin))) {
        return true;
      }
    }
    return false;
  }
}