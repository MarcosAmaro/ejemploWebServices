<?php
	
	require 'CursoClient.php';

	$c = new CursoClient();
	
	$curso["id"] = "";
	$curso["lenguaje"] = $_POST["lenguaje"];
	$curso["precio"] = $_POST["precio"];
	$curso["duracion"] = $_POST["duracion"];
	echo $c->addCurso($curso);
?>