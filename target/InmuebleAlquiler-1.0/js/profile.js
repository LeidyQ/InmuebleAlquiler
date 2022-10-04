var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-saldo").html("$" + user.saldo.toFixed());

        getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-telefono").val(parsedResult.telefono);
                $("#input-email").val(parsedResult.email);
                $("#input-direccion_u").val(parsedResult.direccion_u);
                $("#input-ciudad_u").val(parsedResult.ciudad_u);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult);

            } else {
                console.log("Error recuperando los datos de los alquileres");
            }
        }
    });
}

function mostrarHistorial(inmuebles) {
    let contenido = "";
    if (inmuebles.length >= 1) {
        $.each(inmuebles, function (index, inmueble) {
            inmueble = JSON.parse(inmueble);

            contenido += '<tr><th scope="row">' + inmueble.id + '</th>' +
                    '<td>' + inmueble.tipo_inmueble + '</td>' +
                    '<td>' + inmueble.n_habitaciones + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + inmueble.id
                    + '" disabled ';
            if (inmueble.n_habitaciones) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + inmueble.fechaAlquiler + '</td>' +
                    '<td><button id="cancelar-btn" onclick= "cancelarinmueble(' + inmueble.id
                    + ');" class="btn btn-danger">Cancelar inmueble</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function cancelarInmueble(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletInmuebleCancelar",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error cancelando el Inmueble");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let telefono = $("#input-telefono").val();
    let email = $("#input-email").val();
    let direccion_u = $("#input-direccion_u").val();
    let ciudad_u = $("#input-ciudad_u").val();
   
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
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

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}