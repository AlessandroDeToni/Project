# Project

##### Esempi di Test

###### POST: 
	
	path: "/Filter"
 Di seguito elenco alcuni esempi di body per effettuare la request.
 Tenere conto conto che:
 	
 	* "fieldname1" e "fieldname2" possono essere un qualunque campo della classe Record.
 	* "operator" può essere uno tra i seguenti operatori: "<",">","==","and","or". 
 	
 	body:
	 {
		"fieldname1": 2017,
		"operator":"==",
		"value1": 7.5
 	 } 
 	 
 	 body:
	 {
		"fieldname1": 2017,
		"operator":"or",
		"value1": 7.5
 	 } 