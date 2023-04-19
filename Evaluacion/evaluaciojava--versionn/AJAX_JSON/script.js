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
            nombres: $('#nombre_input').val(),
            apellidos: $('#apellido_input').val(),
            telefono: $('#telefono_input').val(),
            estado_civil: $('#civil_input').val(),
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

    $('#buscar').on('click', function(){
        let dato = $('#nombre_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarNombre/"+dato,
            type: "GET",
            datatype: JSON,
            success: function(respuesta){
                if(respuesta)
                    console.log(respuesta)
                else
                console.log("no hay na")
            }
        })
    })

    $('#buscar_id').on('click', function(){
        let dato = $('#id_buscar').val();
        $.ajax({
            url: "http://localhost:8080/buscarId/"+dato,
            type: "GET",
            datatype: JSON,
            success: function(respuesta){
                if(respuesta)
                    console.log(respuesta)
                else
                console.log("no hay na")
            }
        })
    })


    $('#eliminar').on('click', function(){
    let dato = $('#id_eliminar').val();
    $.ajax({
        url: "http://localhost:8080/eliminar/"+dato,
        type: "DELETE",
        dataType: "JSON",
        success: function(respuesta){
            if(respuesta)
                console.log("eliminado exitosamente")
            else
                console.log("no hay na")
        }})
    })


    $('#actualizar').on('click', function(){
        let id = $('#id_act').val()
        let nombre_act = $('#nombre_act').val()
        let apellido_act = $('#apellido_act').val()
        let telefono_act= $('#telefono_act').val()
        let civil_act = $('#civil_act').val()
        $.ajax({
            url: "http://localhost:8080/actualizar/"+id+"/"+nombre_act+"/"+apellido_act+"/"+telefono_act+"/"+civil_act,
            type: "PUT",
            dataType: "JSON",
            success: function(respuesta){
                alert(respuesta)
            }
        })
    })
})