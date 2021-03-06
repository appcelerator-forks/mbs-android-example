 

package arrowmbs.auth;

import java.util.Map;

public class SdkException extends Exception {

  public static final byte CONTEXT_NOT_AVAILABLE = 1;
  public static final byte CONTEXT_NOT_INSTANCE_OF_TOKENLISTENER = 2;
  public static final byte NOT_INITIALIZED = 3;
  public static final byte KEYSTORE_CREATE_KEYS_ERROR = 4;
  public static final int AUTH_SERVICE_CREATION_FAILED = 5;
  public static final int AUTH_STATE_READ_FAILED = 6;
  public static final int SECURE_PREFERENCES_NOT_INITIALIZED = 7;
  public static final int MISSING_PARAMETER = 400;
  public static final int INTERNET_NOT_AVAILABLE = 100;
  public static final int AUTH_CONFIG_NOT_AVAILABLE = 101;
  public static final int INTERNAL_SERVER_ERROR = 501;
  public static final int MULTIPART_NOT_SUPPORTED = 401;
  public static final byte TRANSPORT_OBJECT_CREATION_FAILED = 8;
  public static final byte AUTH_CONFIG_NOT_SET = 9;
  public static final byte OAUTHPASSWORD_CREDENTIALS_MISSING = 10;
  public static final byte OAUTHPASSWORD_CLIENT_CREDENTIALS_MISSING = 11;
  public static final byte ERROR_RUNNING_ON_UI_THREAD = 12;

  private int code = 0;
  private String message = null;
  private Map<String, Object> responseHeaders;
  private String responseBody;

  /**
   * Default Constructor
   *
   * @param throwable @{@link Throwable} object
   */
  public SdkException(Throwable throwable) {
    super(throwable);
  }

  /**
   * Plain old Exception with a Code and Message
   *
   * @param code Exception Code
   * @param message @{@link String} Exception Message
   */
  public SdkException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  /**
   * SDKException for HTTP Response errors
   *
   * @param code Exception code
   * @param message Exception Message
   * @param responseHeaders @{@link Map} of response headers
   * @param responseBody @{@link String} Response Body
   */
  @SuppressWarnings("SameParameterValue")
  public SdkException(int code, String message, Map<String, Object> responseHeaders, String responseBody) {
    this.code = code;
    this.message = message;
    this.responseHeaders = responseHeaders;
    this.responseBody = responseBody;
  }

  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  /**
   * Get the HTTP response headers.
   */
  public Map<String, Object> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * Get the HTTP response body.
   */
  public String getResponseBody() {
    return responseBody;
  }
}
