<?php

	class CursoClient {
		
		private $soapClient;
		
		function __construct() {
			$wsdl = 'http://localhost:9000/CursoService?wsdl'; //URL del servicio SOAP

			$options = array(
				'uri'=>'http://schemas.xmlsoap.org/soap/envelope/',
				'style'=>SOAP_DOCUMENT,
				'use'=>SOAP_LITERAL,
				'connection_timeout'=>15,
				'encoding'=>'UTF-8',
				'exceptions'=>true,
			);
			
			$this->soapClient =  new SoapClient($wsdl,$options);	
		}
 
		function getCursos(){
			$json["data"] = array();
			$data = $this->soapClient->getCursos();
			
			$data->data = $data->return;
			unset($data->return);
			
			if (count($data->data) == 1){
				$data->data= array($data->data);
			}
			
			return json_encode($data, JSON_PRETTY_PRINT);
		}
		
		function addCurso($curso){
			$data = $this->soapClient->addCurso($curso);
	
			return json_encode($data, JSON_PRETTY_PRINT);
		}
		
		function updateCurso($curso){
			$data = $this->soapClient->updateCurso($curso);
	
			return json_encode($data, JSON_PRETTY_PRINT);
		}
		
		function deleteCurso($id){
			$params = array("id" => $id);
			$json["data"] = array();
			$data = $this->soapClient->deleteCurso($params);
	
			return json_encode($data, JSON_PRETTY_PRINT);
		}
	}

?>