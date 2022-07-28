
Reto Tecnico,
Base de Datos Mongodb (se encuentra montado en la nube y ya posee cargado los datos basicos)


Controlador BloodTestTypeController:  // Controlador para manejar los tipos de examenes (Sangre, Grasa etc)

	GET	localhost:8080/blood-test-type/get-all
	POST localhost:8080/blood-test-type/create



Controlador RiskRangeController:  // Controlador para los rangos de riesgo segun los estudios por tipo de examen

	GET	localhost:8080/risk-range/get-all
	POST localhost:8080/risk-range/create
	
	
	
Controlador PatientController:   // Controlador para cargar los pacientes y obtener los resultados finales

	GET localhost:8080/patient/get-test-result-by-document/{id} // Ruta que obtiene el resultado de los examenes del paciente y el riesgo 
	GET	localhost:8080/patient/get-all
	POST localhost:8080/patient/create
	
	
	
Controlador BloodTestController:   // Controlador para cargar los pacientes y obtener los resultados finales

	GET	localhost:8080/blood-test/get-all
	POST localhost:8080/blood-test/create
	POST localhost:8080/blood-test/create-many // Ruta para carga masiva de pacientes y pruebas de sangre
			Ejemplo del Body
			[
			{
				"patientDocument": "797950",
				"patientName": "Jose Manuel Palacios",
				"tests": [
					{
						"bloodTest": "EX01",
						"percentageResult": 11.1
					},
					{
						"bloodTest": "EX02",
						"percentageResult": 11.3
					},
					{
						"bloodTest": "EX03",
						"percentageResult": 33.2
					}
				]
			},
			{
				"patientDocument": "797941",
				"patientName": "Josue Flores",
				"tests": [
					{
						"bloodTest": "EX01",
						"percentageResult": 33.3
					},
					{
						"bloodTest": "EX02",
						"percentageResult": 56
					},
					{
						"bloodTest": "EX03",
						"percentageResult": 89.2
					}
				]
			}
		]