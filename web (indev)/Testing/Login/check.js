/**
 * check.js
 * Author: Anthony Narlock, Matthew Sherohman
 * 
 * - Checks that the username/password is validated
 * - Also checks if the user/pass already exists, will not
 * allow user to create account with multiple use of username, email
 */

const taken_user_text = document.querySelector('.taken_user')
var x = document.getElementById("username"); 

function printUsername() {
    console.log(x.value)
};

function taken_user() {
    if (x.value == "Matt" || x.value == "Tony") {
        taken_user_text.textContent = `Username is Taken`;
    }
    else {
        taken_user_text.textContent = `Username is NOT taken!`;
    }
}

