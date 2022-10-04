var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
       

        getInmuebles(false, "ASC");

        $("#ordenar-tipo_inmueble").click(ordenarInmuebles);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getInmuebles(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletInmuebleListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarInmuebles(parsedResult);
            } else {
                console.log("Error recuperando los datos de los inmuebles");
            }
        }
    });
}
function mostrarInmuebles(inmuebles) {

    let contenido = "";

    $.each(inmuebles, function (index, inmueble) {

        inmueble = JSON.parse(inmueble);
        

            contenido += '<tr><th scope="row">' + inmueble.id + '</th>' +
                    '<td>' + inmueble.tipo_inmueble + '</td>' +
                    '<td>' + inmueble.n_habitacion + '</td>' +
                    '<td>' + inmueble.n_bano + '</td>' +
                    '<td>' + inmueble.direccion_i + '</td>' +
                    '<td>' + inmueble.patio + '</td>' +
                    '<td>' + inmueble.parqueadero + '</td>' +
                    '<td>' + inmueble.telefono_i + '</td>' +
                    '<td>' + inmueble.ciudad_i + '</td>' +
                    '<td>' + inmueble.comuna_i + '</td>' +
                    '<td>' + inmueble.valor_alquiler + '</td>' 
                    ;
          
       }
        );
    $("#inmuebles-tbody").html(contenido);
     
}
function ordenarInmuebles() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getInmuebles(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getInmuebles(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getInmuebles(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}

