package com.hem.poc.pocbotdetect;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.captcha.botdetect.web.servlet.SimpleCaptcha;

/**
 * FormPostController represent the the various controller for implementing the server side functionality for captcha 
 * provided by the captcha.com (https://captcha.com/)
 * @author hem
 *
 */
@RestController
public class FormPostController {

	
	private static final Log LOG = LogFactory.getLog(FormPostController.class);
	
	/**
	 * validating captcha API
	 * @param jsonObejct
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/api/validate", produces = "application/json; charset=utf-8")
	public @ResponseBody String yourFormPostAction(@RequestBody JsonObject jsonObejct, HttpServletRequest request)
		 {
		String userEnteredCaptchaCode = jsonObejct.getUserEnteredCaptchaCode();
		String captchaId = jsonObejct.getCaptchaId();
		SimpleCaptcha yourFirstCaptcha = SimpleCaptcha.load(request);
		LOG.info(userEnteredCaptchaCode + " | " + captchaId);
		LOG.info(yourFirstCaptcha);
	    boolean isHuman = yourFirstCaptcha.validate(userEnteredCaptchaCode, captchaId);
	    return "{\"success\":"+isHuman+"}";
	}
}
