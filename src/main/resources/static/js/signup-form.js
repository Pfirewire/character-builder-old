$(() => {
    let userHasFocusedPassword = false;
    let userHasFocusedConfirm = false;
    let passwordFulfillsRequirements = false;

    const betweenEightAndFifty = input => {
        if(input.length >= 8 && input.length <= 50) {
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


    const requirementsNotMet = (input) => {
        if(betweenEightAndFifty(input) && containsLowercase(input) && containsUppercase(input)){
            return false;
        } else {
            return true;
        }
    }

    const revertBorder = (selector) => {
        selector.css("border", "1px solid #ced4da");
    }

    const makeBorderRed = (selector) => {
        selector.css("border", "1px solid #F00");
    }

    $("#password")
        .focus(() => {
            userHasFocusedPassword = true;
            if(requirementsNotMet($("#password").val())){
                makeBorderRed($("#password"));
            } else {
                revertBorder($("#password"));
            }
        })
        .keyup(() => {
            console.log($("#password").val());
            if(requirementsNotMet($("#password").val()) && userHasFocusedPassword){
                makeBorderRed($("#password"));
            } else {
                revertBorder($("#password"));
            }

        })
    ;
    $("#confirmPassword").focus(() => {
        userHasFocusedConfirm = true;
    });



});