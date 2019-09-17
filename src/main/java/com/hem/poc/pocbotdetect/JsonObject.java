package com.hem.poc.pocbotdetect;

import lombok.Data;

/**
 * Class <b>JsonObject</b> represent the request for validating the entered captcha.
 * @author hem
 *
 */
@Data
public class JsonObject {
	
	/**
	 * captcha entered by the user
	 */
	private String userEnteredCaptchaCode;
	
	/**
	 * captcha id 
	 */
	private String captchaId;

}
