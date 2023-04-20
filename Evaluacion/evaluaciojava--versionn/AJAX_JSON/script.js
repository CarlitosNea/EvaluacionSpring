$(document).ready(function(){
    $('#listar').on('click', function(){
        let tabla = $('#tabla');
        $.ajax({
            url: "http://localhost:8080/mostrar",
            type : "GET",
            dataType: "JSON",
            success: function(res){
                console.log(res);
                tabla.empty();
                let encabezado = $('<tr></tr>');
                encabezado.append('<th>Documento</th>');
                encabezado.append('<th>Nombre</th>');
                encabezado.append('<th>Apellido</th>');
                encabezado.append('<th>Curso</th>');
                encabezado.append('<th>Nota Final</th>');
                tabla.append(encabezado);
                for (let i = 0; i < res.length; i++) {
                    let fila = $('<tr></tr>');
                    fila.append('<td>' + res[i].documento + '</td>');
                    fila.append('<td>' + res[i].nombre + '</td>');
                    fila.append('<td>' + res[i].apellido + '</td>');
                    fila.append('<td>' + res[i].curso + '</td>');
                    fila.append('<td>' + res[i].nota_final + '</td>');
                    tabla.append(fila);
                }
            }
        })
    })


    $('#enviar').on('click', function(){
        let datos = {
            documento: $('#doc_input').val(),
            nombre: $('#nombre_input').val(),
            apellido: $('#apellido_input').val(),
            curso: $('#curso_input').val(),
            nota_final: $('#nota_input').val(),
        }
        let datosEnvio = JSON.stringify(datos)
        console.log(datos)
        console.log(datosEnvio)
        $.ajax({
            url: "http://localhost:8080/agregar",
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
            datatype: JSON,
            success: function(respuesta){
                alert(respuesta)
            }
        })
    })

})