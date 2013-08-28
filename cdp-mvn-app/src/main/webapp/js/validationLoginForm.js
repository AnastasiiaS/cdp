function addEventListenerToForm(loginForm) {

	if (loginForm.addEventListener) {
		loginForm.addEventListener("input", validateForm, false);
	} else {
		loginForm.attachEvent("input", validateForm);
	}
}

function validateForm(src) {
	var loginForm = !!src.target ? this : src;
	validateFields(loginForm);
	setTimeout("", 0);
}
function validateFields(loginForm) {
	var fieldCount = loginForm.elements.length;
	for ( var i = 0; i < fieldCount; i++) {
		var field = loginForm[i];
		errorMsg = validateField(field);
		field.setCustomValidity(errorMsg);

	}
}

function validateField(field) {
	if (field.validity.valid) {
		return '';
	} else {
		var startMsg = field.placeholder;
		if (field.validity.valueMissing) {
			return startMsg + " field is required and cannot be empty";
		}
		var max = getMaxLength(field);
		var min = getMinLength(field);
		if (field.validity.patternMismatch) {
			return startMsg
					+ " field should contains from "
					+ min
					+ " to "
					+ max
					+ (field.name == "username" ? " and have at least one letter and one number "
							: '');
		}
		return '';
	}
}

function getMaxLength(field) {
	var fieldName = field.name;
	if (fieldName == "username") {
		return 10;
	}
	if (fieldName == "password") {
		return 12;
	}
}

function getMinLength(field) {
	var fieldName = field.name;
	if (fieldName == "username") {
		return 4;
	}
	if (fieldName == "password") {
		return 6;
	}
}

var loginForm = document.forms[0];

addEventListenerToForm(loginForm);
validateForm(loginForm);
