<?php
	
	require 'CursoClient.php';

	$c = new CursoClient();
	//echo $_POST['id'];
	echo $c->deleteCurso($_POST['id']);
?>