package kr.co.e1.workreport.framework;

import android.content.res.Resources;
import kr.co.e1.workreport.R;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import timber.log.Timber;

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

  public static Validate2Result validate2(String id, String pw, Resources res) {
    if (id.length() < MINIMUM_LENGTH_ID || id.length() > MAXIMUM_LENGTH) {
      Timber.i("username too short or too long");
      return new Validate2Result(res.getString(R.string.validate_id_short_or_long), ErrorType.ID);
    }
    if (pw.length() < MINIMUM_LENGTH_PW || pw.length() > MAXIMUM_LENGTH) {
      Timber.i("pass too short or too long");
      return new Validate2Result(res.getString(R.string.validate_pass_short_or_long), ErrorType.PW);
    }
    if (!pw.matches(".*\\d.*")) {
      Timber.i("no digits found");
      return new Validate2Result(res.getString(R.string.validate_no_digits), ErrorType.PW);
    }
    if (!pw.matches(".*[a-z].*")) {
      Timber.i("no lowercase letters found");
      return new Validate2Result(res.getString(R.string.validate_no_lowercase), ErrorType.PW);
    }
    if (!pw.matches(".*[!@#$%^&*+=?-].*")) {
      Timber.i("no special chars found");
      return new Validate2Result(res.getString(R.string.validate_no_special_chars), ErrorType.PW);
    }
    if (containsPartOf(pw, id)) {
      Timber.i("pass contains substring of username");
      return new Validate2Result(res.getString(R.string.validate_pass_contains_id), ErrorType.PW);
    }

    return new Validate2Result("", ErrorType.PASS);
  }

  public enum ErrorType {
    ID(0), PW(1), PASS(2);
    private int value;

    ErrorType(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  @AllArgsConstructor @ToString public static class Validate2Result {
    @Getter private String message;
    @Getter private ErrorType errorType;
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
      Timber.i("pass too short or too long");
      return false;
    }
    if (username.length() < 3 || username.length() > 15) {
      Timber.i("username too short or too long");
      return false;
    }
    if (!pass.matches(".*\\d.*")) {
      Timber.i("no digits found");
      return false;
    }

    if (!pass.matches(".*[a-z].*")) {
      Timber.i("no lowercase letters found");
      return false;
    }
    if (!pass.matches(".*[!@#$%^&*+=?-].*")) {
      Timber.i("no special chars found");
      return false;
    }
    if (containsPartOf(pass, username)) {
      Timber.i("pass contains substring of username");
      return false;
    }
    if (containsPartOf(pass, email)) {
      Timber.i("pass contains substring of email");
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