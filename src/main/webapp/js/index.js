$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register-inmueble").submit(function (event) {

        event.preventDefault();
        registrarInmueble();
    });
    
    $("#form-register-usuario").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });



});

function autenticarUsuario() {

    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let telefono = $("#input-telefono").val();
    let email = $("#input-email").val();
    let direccion_u = $("#input-direccion_u").val();
    let ciudad_u = $("#input-ciudad_u").val();
    

    if (contrasena == contrasenaConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                contrasena: contrasena,
                nombre: nombre,
                apellidos: apellidos,
                telefono: telefono,
                email: email,
                direccion_u: direccion_u,
                ciudad_u: ciudad_u,
                
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}

function registrarInmueble() {

    let tipo_inmueble = $("#input-tipo_inmueble").val();
    let n_habitaciones = $("#input-n_habitaciones").val();
    let n_banos = $("#input-n_banos").val();
    let direccion_i = $("#input-direccion_i").val();
    let patio = $("#input-patio").val();
    let parqueadero = $("#input-parqueadero").val();
    let telefono_i = $("#input-telefono_i").val();
    let ciudad_i= $("#input-ciudad_i").val();
    let comuna_i= $("#input-comuna_i").val();
    let valor_alquiler= $("#input-valor_alquiler").val();
    

  
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletInmuebleRegister",
            data: $.param({
                tipo_inmueble: tipo_inmueble,
                n_habitaciones: n_habitaciones,
                n_banos: n_banos,
                direccion_i: direccion_i,
                patio: patio,
                parqueadero: parqueadero,
                telefono_i: telefono_i,
                ciudad_i: ciudad_i,
                comuna_i:comuna_i,
                valor_alquiler:valor_alquiler
                
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                document.location.href = "home.html";
            }
        });
   
    }
