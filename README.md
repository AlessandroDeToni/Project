# Project

### Esempi di Test

###### POST: 
	
	path: "/Filter"
 Di seguito elenco alcuni esempi di body per effettuare la request.
 Tenere conto conto che:
 	
 - "fieldname1" e "fieldname2" possono essere un qualunque campo della classe Record ma gli anni sono scritti per esteso (2000, 2001 ecc.)
 - "operator" può essere uno tra i seguenti operatori: "<",">","==","and","or". 
 	
 	- **"==", "<", ">";** 
	
		> body:
		 {
			"fieldname1": 2017,
			"operator":"==",
			"value1": 7.5
		 } 
	 
	 *(per gli anni "==" può essere sostituito da "<",">")*
 	 
 	- **"==" campi tipo Stringa;** 
	
		> body:
		{
			"fieldname1": "geo",
			"operator":"==",
			"value1": "IT"
		}
	
	- **"or", "and" (su un campo unico)** 

		> body:
		{
			"fieldname1": "geo",
			"operator":"or",
			"value1": "IT",
			"value2": "DE"
		} 

	*("or" può essere sostituito con "and")*
	
	- **"or", "and" (2 campi diversi);**
	
		> body:
		{
			"fieldname1": "geo",
			"fieldname2": 2014,
			"operator":"or",
			"value1": "IT",
			"value2": 0
		} 
	
	*("or" può essere sostituito con "and")*
	
	
