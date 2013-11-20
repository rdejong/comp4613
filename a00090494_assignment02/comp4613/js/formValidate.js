function addMemberFormValidator()

{

	var re = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	var regexp =  /\(?(\d{3})\)?-?(\d{3})-(\d{4})/;
	var lettersonly = /^[a-zA-Z]*$/;

	var lastName = document.addMemberForm.lastName.value;
	var firstName = document.addMemberForm.firstName.value;
	var address = document.addMemberForm.address.value;
	var code = document.addMemberForm.code.value;
	var city = document.addMemberForm.city.value;
	var phone = document.addMemberForm.firstName.value;
	var email = document.addMemberForm.firstName.value;
	var country = document.addMemberForm.country.value;

	var errMsg = "";

	if (lastName == "") {
		errMsg = errMsg + "Please fill in your last name\n";
	}
	if (firstName == "") {
		errMsg = errMsg + "Please fill in your first name\n";
	}
	if (address == "") {
		errMsg = errMsg + "Please fill in your Address\n";
	}
	if (code == "") {
		errMsg = errMsg + "Please fill in your Code\n";
	}
	if (city == "") {
		errMsg = errMsg + "Please fill in your City\n";
	}
	if (country == "") {
		errMsg = errMsg + "Please fill in your Country\n";
	}
	if (!lettersonly.test(country)) {
		errMsg = errMsg + "Letters only for Country name please\n";
	}
	if (regexp.test(phone)) {
		errMsg = errMsg + "Your phone number has been incorrectly formatted\n";
	}

	if (re.test(email)) {
		errMsg = errMsg + "Your email address has been incorrectly formatted\n";
	}
	if (errMsg != "") {
		alert(errMsg);
		return false;
	}
	return true;

}

function memberIdValidator() {
	
	var lettersonly = /^[a-zA-Z]*$/;
	var memberId = document.searchMemberForm.memberUid.value;

	var errMsg = "";

	if (lettersonly.test(memberId)) {
		errMsg = errMsg + "Numbers only for Member Id please\n";

		if (errMsg != "") {
			alert(errMsg);
			return false;
		}
		return true;
	}
}
function deleteMemberValidator() {
	
	var lettersonly = /^[a-zA-Z]*$/;
	var memberId = document.deleteMemberForm.uid.value;

	var errMsg = "";

	if (lettersonly.test(memberId)) {
		errMsg = errMsg + "Numbers only for Member Id please\n";

		if (errMsg != "") {
			alert(errMsg);
			return false;
		}
		return true;
	}
}
