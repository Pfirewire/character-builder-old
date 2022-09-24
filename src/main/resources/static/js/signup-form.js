$(() => {
    let userHasFocusedPassword = false;
    let userHasFocusedConfirm = false;
    let passwordFulfillsRequirements = false;
    let lengthMet = false;
    let uppercaseMet = false;
    let lowercaseMet = false;
    let numberMet = false;
    let specialMet = false;


    const isNumber = input => {
        return !(isNaN(Number(input)));
    }

    const betweenEightAndFifty = input => {
        if(input.length >= 8) {
            return true;
        } else {
            return false;
        }
    }

    const containsLowercase = input => {
        for(let i = 0; i < input.length; i++) {
            if(input.charAt(i).toLowerCase() === input.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    const containsUppercase = input => {
        for(let i = 0; i < input.length; i++) {
            if(input.charAt(i).toUpperCase() === input.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    const containsNumber = input => {
        for(let i = 0; i < input.length; i++) {
            if(isNumber(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    const containsSpecialCharacter = input => {
        let specials = "!@#$%^&*()-=_+"
        for(let i = 0; i < input.length; i++) {
            for(let j = 0; j < specials.length; j++) {
                if(input.charAt(i) === specials.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    const requirementsNotMet = (input) => {
        if(betweenEightAndFifty(input) && containsLowercase(input) && containsUppercase(input) && containsNumber(input) && containsSpecialCharacter(input)){
            return false;
        } else {
            return true;
        }
    }

    const revertBorder = selector => {
        selector.css("border", "1px solid #ced4da");
    }

    const makeBorderRed = selector => {
        selector.css("border", "2px solid #F00");
    }

    const makeTextRed = selector => {
        console.log("inside makeTextRed");
        selector.css("color", "#F00");
    }

    const revertText = selector => {
        selector.css("color", "#6c757d");
    }

    const changeBorderBasedOnRequirements = selector => {
        if(requirementsNotMet(selector.val())){
            makeBorderRed(selector);
        } else {
            revertBorder(selector);
        }
    }

    const changeIndividualRequirements = selector => {

    }

    $("#password")
        .focus(() => {
            console.log("inside password focus. userHasFocusedPassword: " + userHasFocusedPassword);
            if(!userHasFocusedPassword) {
                makeTextRed($("#passwordHelpLength, #passwordHelpUppercaseLetter, #passwordHelpLowercaseLetter, #passwordHelpNumber, #passwordHelpSpecialCharacters"));
            }
            userHasFocusedPassword = true;
            changeBorderBasedOnRequirements($("#password"));
            changeIndividualRequirements($("#password"));
        })
        .keyup(() => {
            changeBorderBasedOnRequirements($("#password"));
            changeIndividualRequirements($("#password"));
        })
    ;


    $("#confirmPassword").focus(() => {
        userHasFocusedConfirm = true;
    });



});