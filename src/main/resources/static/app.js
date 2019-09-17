var app = angular.module('app', [ 'BotDetectCaptcha', 'ngRoute' ]);
app.config(function($routeProvider, captchaSettingsProvider) {
	
	// defing routed for the captcha 
	$routeProvider.when("/", {
		templateUrl : 'your-form-with-captcha.html',
		controller : 'CaptchaController'
	}).when('/captcha', {
		templateUrl : 'your-form-with-captcha.html',
		controller : 'CaptchaController'
	});

	//Setting captcha provider url
	captchaSettingsProvider.setSettings({
		captchaEndpoint : ' /simple-captcha-endpoint'
	});
});
