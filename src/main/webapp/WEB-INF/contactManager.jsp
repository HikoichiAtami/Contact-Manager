<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenedor Contactos</title>

<style>
.formulario, .lista{
	margin: 0 auto;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
caption{
	font-size: 2rem;
}
</style>
</head>
<body>



<div class="formulario">
	<form:form id="frmAcciones" modelAttribute="contact">
		<div>
			<fieldset>
				<legend>Mantenedor de Contactos</legend>
				<table border="1">
					<tr>
						<td>Nombre:</td>
						<td><input type="text" id="idNombre" name="nombre" /></td>
						<td>Apellido Paterno:</td>
						<td><input type="text" id="idApellidoPaterno" name="apellidoPaterno" /></td>
						<td>Apellido Materno:</td>
						<td><input type="text" id="idApellidoMaterno" name="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td>Dirección:</td>
						<td><input type="text" id="idDireccion" name="direccion" /></td>
						<td>Teléfono:</td>
						<td><input type="number" id="idTelefono" name="telefono"/></td>
					</tr>
					<tr>
						<td colspan="4">
						<input type="button" value="Agregar" onclick="submitFormAction('/addContact', 'post')" />
						<input type="button" value="Eliminar" onclick="deleteRow('/deleteContact', 'get')" />
						<c:out value="${mensaje}"/></td>
						
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>
	</div>
	

	<form:form id="formList" name="form1" action="/deleteContact" method="post">
	<table class="lista">
	<caption>Lista de Contactos</caption>
  <tr>
  	<th></th>
    <th>ID</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
    <th>Direccion</th>
    <th>Telefono</th>
  </tr>
  <c:forEach var="contact" items="${contacto}">
  <tr>
  	<td>
  		 <input type="radio" required id="select" name="select" value="<c:out value="${contact.getId()}"/>" />
  	</td>
    <td>
    	<c:out value="${contact.getId()}"/>
    </td>
     <td>
    	<c:out value="${contact.getNombre()}"/>
    </td>
     <td>
    	<c:out value="${contact.getApellidoPaterno()}"/>
    </td>
     <td>
    	<c:out value="${contact.getApellidoMaterno()}"/>
    </td>
     <td>
    	<c:out value="${contact.getDireccion()}"/>
    </td>
     <td>
    	<c:out value="${contact.getTelefono()}"/>
    </td>
  </tr>
  </c:forEach>
</table>
	</form:form>
	
<script type="text/javascript">
var idSelect = 0;
function submitFormAction(action, method){
	var telefono = document.getElementById("idTelefono").value;
	var nombre = document.getElementById("idNombre").value;
	var apellido = document.getElementById("idApellidoPaterno").value;
	var apellido2 = document.getElementById("idApellidoMaterno").value;
	var direccion = document.getElementById("idDireccion").value;
	if(telefono == "" || nombre == "" || apellido == "" || apellido2 == "" || direccion == ""){
		alert("Todos los campos son requeridos");
		return false;
	}
	if(!/^[A-Za-z]+$/.test(nombre)){
		alert("Ha ingresado datos erroneos");
		return false;
	}
	if(!/^(\+?56)?(\s?)(0?9)(\s?)[9876543]\d{7}$/.test(telefono)){
		alert("El telefono es incorrecto");
		return false;
	}
document.getElementById("frmAcciones").action = action;
document.getElementById("frmAcciones").method = method;
document.getElementById("frmAcciones").submit();
}

function deleteRow(action,method){
	
	if(document.form1.select.checked == false){
		alert ( "No ha seleccionado ningun usuario para eliminar" );
		return false;
		} 
	document.getElementById("formList").action = action;
	document.getElementById("formList").method = method;
	document.getElementById("formList").submit();
}


</script>
</body>
</html>