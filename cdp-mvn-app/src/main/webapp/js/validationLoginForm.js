var errorMessages = {
	'valueMissing' : ' field is required and cannot be empty ',
	'patternMismatch' : ' value does not match pattern: ',
};
var form = document.forms[0];
if (form.addEventListener) {
	form.addEventListener("input", validateForm, false);
} else {
	form.attachEvent("input", validateForm);
}
validateForm(form);
function validateForm(src) {
	var form = !!src.target ? this : src;
	setTimeout(function() {
		for ( var i = 0, lenght = form.length; i < lenght; i++) {
			form[i].setCustomValidity(makeMessage(form[i]));
		}
	}, 0);
}
function makeMessage(input) {
	var errorMessage = '';
	if (input.validity.valid) {
		return errorMessage;
	}
	var key;
	for (key in input.validity) {
		if (input.validity[key] && errorMessages[key]) {
			errorMessage = input.placeholder + errorMessages[key]
					+ descriptionValue(key, input);

		}
	}
	return errorMessage;
}

function descriptionValue(key, input) {
	if (key === 'patternMismatch') {
		return input.pattern;
	}
	return "";
}