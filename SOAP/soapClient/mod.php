<?php
	
	require 'CursoClient.php';

	$c = new CursoClient();
	
	$curso["id"] = $_POST["id"];
	$curso["lenguaje"] = $_POST["lenguaje"];
	$curso["precio"] = $_POST["precio"];
	$curso["duracion"] = $_POST["duracion"];
	echo $c->updateCurso($curso);
?>