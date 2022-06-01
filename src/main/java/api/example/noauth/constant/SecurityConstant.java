package api.example.noauth.constant;

public class SecurityConstant {
	public static final long EXPIRATION_TIME = 	432_000_000; // 5 days in ms
	public static final String TOKEN_HEADER = "BootSpring ";
	public static final String JWT_TOKEN_HEADER = "Jwt-Token";
	public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
	public static final String GET_DEVELOP_Agency = "Get Develop, Agency";
	public static final String GET_ARRAYS_ADMINISTRATION = "User managament Portal";
	public static final String AUTHORITIES = "Authorities";
	public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
	public static final String ACCESS_DENIED_MESSAGE = "You don't have permision to access this page";
	public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
	public static final String[] PUBLIC_URLS = {"/user/login","/user/register","/user/resetpassword/**","/user/image/**"};
}
