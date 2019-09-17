app.controller('CaptchaController',
     function ($scope, $http, $window, Captcha) {
  // process the form on submit event
  $scope.validate = function () {

    // create new AngularJS Captcha instance
    var captcha = new Captcha();

    // get the user-entered captcha code value to be validated at the backend side        
    var userEnteredCaptchaCode = captcha.getUserEnteredCaptchaCode();

    // get the id of a captcha instance that the user tried to solve
    var captchaId = captcha.getCaptchaId();

    var postData = {
      // add the user-entered captcha code value to the post data
      userEnteredCaptchaCode: userEnteredCaptchaCode,
      // add the id of a captcha instance to the post data
      captchaId: captchaId
    };

    // post the captcha data to the /your-app-backend-path on your backend
   $http({
      headers: { 'Content-Type': 'application/json; charset=utf-8' },
      method: 'POST',
      url: 'http://localhost:8080/api/validate',
      data: postData
    })
      .then(function (response) {
        if (response.data.success == false) {
          // captcha validation failed; reload image
          captcha.reloadImage();
          // TODO: maybe display an error message, too
        } else {
          // TODO: captcha validation succeeded; proceed with the workflow
        }
      }, function (error) {
        throw new Error(error.data);
      });
  };
});
