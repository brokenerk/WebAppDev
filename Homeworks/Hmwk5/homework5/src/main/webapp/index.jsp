<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Homework 5</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script>
			/*Para ir creando dinamicamente los inputs de los parametros*/
			$(document).ready(function(){
				var contador = 1;
				
				$('#agregar').click(function(){
					/*Leemos el nombre del parametro*/
					var parametro = $('#parametro').val(); 
					
					/*Si no es vacio, creamos el input y el boton Send*/
					if(parametro != ""){
						$('#enviar').remove();
						var nuevoInput = 
							"<label>" + contador + ". " + parametro + ":</label>" +
							"<input type='text' name=" + parametro + " value=''/><br>" +
							"<input type='submit' id='enviar' value='Send'></ol>";
						
						/*Añadimos los inputs al formulario (metodo POST)*/
					    $('#contenedor').append(nuevoInput);
					    contador++;
					    $('#parametro').val("");
					}
				});
			});
		</script>
	</head>
	<body>
		<h1>Sending dynamic parameters</h1>
		<br>
		<div>
	    	<label>Name attribute of the parameter:</label>
	        <input type="text" name="parametro" id="parametro" value=""/>
	        <input id="agregar" type="button" value="Add"/>
	    </div>
		<br>
		<form method="POST" id="contenedor" action="Recibe">
		</form>
	</body>
</html>