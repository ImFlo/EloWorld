function loginIn(login, mdp){
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: "v1/connect=" + login + "&" + mdp,
        dataType: "json",
        data: "",
        success: function(key) {
            return key;
        },
        error: function() {
            return undefined;
        }
    });
}

function isConnected(key){
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: "v1/joueur=",
        dataType: "json",
        data: key,
        success: function(ok) {
            return ok;
        },
        error: function() {
            return undefined;
        }
    });
}
